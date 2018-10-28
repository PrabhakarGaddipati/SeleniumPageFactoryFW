/**
 * 
 */
package com.mpt.ui.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpt.base.TestBase;
import com.mpt.ui.pages.HomePage;

/**
 * @author beheraav
 *
 */
public class HomePageTest extends TestBase{

	HomePage HomePage; // Declaring as class level to use through out the class
	//Calling the TestBase class 
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		HomePage =new HomePage();
	}
	
	@Test(priority=1,description="Check logo")
	public void validateLogo(){
		boolean vlogo=HomePage.verifyLogo();
		assertEquals(vlogo, true);
	}
	@Test(priority=2,description="check title")
	public void validateTitle(){
		String title=HomePage.verifyHomePageTitle();
		assertEquals(title, "Premium Title");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
