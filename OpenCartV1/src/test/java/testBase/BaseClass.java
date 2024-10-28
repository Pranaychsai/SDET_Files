package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public static Logger plogger;
public Properties p;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException, URISyntaxException
	{
		plogger= LogManager.getLogger(this.getClass());
		System.out.print("HI PRY 1");
		FileInputStream f = new FileInputStream("C://workspace_eclipse//OpenCartV1//src//test//resources//config.properties");
		p=new Properties();
		p.load(f);
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			System.out.print("HI PRY 2");
			DesiredCapabilities capabilities=new DesiredCapabilities();

			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			URI hubURI = new URI("http://localhost:4444/wd/hub");
            URL hubURL = hubURI.toURL();
            driver=new RemoteWebDriver(hubURL,capabilities);
            
			//driver=new RemoteWebDriver(new URL("http://192.168.228.136:4444/wd/hub"),capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome":
			/*ChromeOptions options = new ChromeOptions();
            
            	System.out.print("Headless is Hit");
            	options.addArguments("--headless=new");  // Updated headless argument
            	options.addArguments("--disable-gpu");  // Required for headless Chrome on some systems
            	options.addArguments("--window-size=1920,1080");  // Ensure that the window size is adequate
            	options.addArguments("--no-sandbox");  // Bypass OS security model
            	options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
            	options.addArguments("--disable-extensions");  // Disable any browser extensions
            	options.addArguments("--disable-software-rasterizer");  // Prevent Chrome from using software-based rendering
            	options.setExperimentalOption("w3c", true);  // Enable the latest WebDriver protocol

				*/
        
			driver=new ChromeDriver();	
			plogger.info("Selected Chrome Browser");
			break;
		case "edge":
			driver=new EdgeDriver();	
			plogger.info("Selected Edge Browser");
			break;
		default: System.out.println("Please Provide correct Browser name in testng xml"); return;
		}
		}
		//driver = new ChromeDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo.opencart.com/");
		//driver.get("https://tutorialsninja.com/demo/");
		
		//
		
		
		driver.get(p.getProperty("appURL1"));
		
		//
		
		
		//Thread.sleep(130);
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='70%'");
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void clean()
	{
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
