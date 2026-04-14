package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //Log4j2
import org.apache.logging.log4j.Logger; //Log4j2

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@SuppressWarnings("deprecation")
	@BeforeClass(groups = { "Sanity", "Smoke", "Regression", "Master", "datadriven" })

	@Parameters({ "os", "browser" }) // Operating System & Browser is coming from XML file

	public void setup(String os, String br) throws IOException, InterruptedException { // which os and browser is coming
																						// from xml file the same we
																						// need to use on grid env

		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2 code

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) // if execution environment is remote below code
																		// must gets executed
		{
			DesiredCapabilities dc = new DesiredCapabilities();

			// For OS -Which OS we have to use from the Grid

			if (os.equalsIgnoreCase("windows")) {
				dc.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {
				dc.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("mac")) {
				dc.setPlatform(Platform.MAC);
			} else {
				System.out.println("No Matching OS");
				return;
			}

			// For Browser - Which Browser we have to launch from particular node

			switch (br.toLowerCase()) {
			case "chrome":
				dc.setBrowserName("chrome");
				break;
			case "firefox":
				dc.setBrowserName("firefox");
				break;
			case "edge":
				dc.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No Matching Browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) { // Execution Environment=Local
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid Browser");
				return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL")); // reading browser URL from config.properties file
	}

	@AfterClass(groups = { "Sanity", "Smoke", "Regression", "Master", "datadriven" })
	public void tearDown() {

		driver.quit();

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // to save screenshot along
																							// with the timestamp
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourcefile.renameTo(targetFile);
		return targetFilePath;
	}

}
