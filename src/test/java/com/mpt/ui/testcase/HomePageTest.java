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
import com.util.TestUtil;

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
	
	@Test(priority=1,description="Check MPT logo")
	public void checkLogo() throws InterruptedException{
		TestUtil.FlWait(HomePage.MptLogo, driver);
		boolean vlogo=HomePage.verifyLogo();
		assertEquals(vlogo, true);
	}
	@Test(priority=2,description="Check Homepage title")
	public void validateTitle(){
		String title=driver.getTitle();
		assertEquals(title, "Premium Title");
	}
	@Test(priority=3,description="Check Contact us Phone and Email")
	public void validateContactUsInfo(){
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
