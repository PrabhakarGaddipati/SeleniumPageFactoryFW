/**
 * 
 */
package com.mpt.ui.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mpt.ui.pages.PlaceOrderPage;
import com.util.Common;

/**
 * @author beheraav
 *
 */
public class TestTC {
	public WebDriver driver=null;
	
	@BeforeClass(description="Initializing WebDriver...")
	public void setUp() {
		driver=Common.initWebDriver();
	}
	
	@Test(priority=1,retryAnalyzer = com.util.RetryAnalyzer.class,description="This test case will perform browser launch and navigate"
			+ "to the Place Order URL")
	public void PO_NavURL() throws InterruptedException {
		PlaceOrderPage.navURL(driver);
		
	}
	@Test(priority=2,description="This testcase is to enter values for only mandatory fields in YOUR COMPANY section")
	public void EnterPropertyAddMdtFields() throws InterruptedException {
		PlaceOrderPage.EnterPropertyAddMdtFields(driver);
	}
	@Test(priority=3,description="This testcase is to enter values for only mandatory fields in YOUR COMPANY section")
	public void EnterAdditionalCoBuyerFields() throws InterruptedException {
		PlaceOrderPage.EnterAdditionalCoBuyerMdtFields(driver);
		PlaceOrderPage.EnterAdditionalCoBuyerOptFields(driver);
		PlaceOrderPage.EnterAdditionalCoBuyerMarriedFields(driver);
	}
	
	
}
