package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
public static WebDriver driver = null;
public Properties prop = null;
private static Logger log =LogManager.getLogger(base.class.getName());
public WebDriver initializeDriver() throws IOException {
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
//	String browserName = System.getProperty("browser");
	if (browserName.contains("chrome")) {
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	}
	else if (browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else {
		log.error("Cannot identify the browser");
		System.exit(0);
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
	return driver;

}

public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}
}
