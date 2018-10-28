/**
 * 
 */
package com.mpt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.util.TestUtil;

/**
 * @author beheraav
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\beheraav\\workspace\\MPT_Automation\\src\\main\\"
					+ "java\\com\\mpt\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		String driverPath=prop.getProperty("driverPath");
		if(browserName.equalsIgnoreCase("chrome")){
			System.out.println("**launching Chrome browser");
			System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver_2.43.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.out.println("launching Firefox browser");
			System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver-v0.18.0-win64.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")){
			System.out.println("**launching IE browser..");
			System.setProperty("webdriver.ie.driver",driverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Warning: Invalid Broswer name provided!");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
