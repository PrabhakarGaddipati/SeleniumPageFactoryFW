/**
 * 
 */
package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author beheraav
 *
 */
public class Common {
	public static String driverPath = "C:\\Users\\beheraav\\workspace\\Selenium_Drivers\\";
	public static String PTS_URL="https://www.qa-mypremiumtitle.com/V2Public/place-order";
	static WebDriver driver=null;
	static String browser="chrome";
	public static WebDriver initWebDriver() {
		System.out.println("*******************");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("**launching Chrome browser");
			System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver_2.43.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.out.println("**launching IE browser..");
			System.setProperty("webdriver.ie.driver",driverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println("launching Firefox browser");
			System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver-v0.18.0-win64.exe");
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("Invalid browser type!");
		}
		driver.manage().window().maximize();
		return driver;
		
	}
}
