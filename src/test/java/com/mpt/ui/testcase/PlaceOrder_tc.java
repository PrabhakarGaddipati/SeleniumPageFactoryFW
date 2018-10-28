package com.mpt.ui.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mpt.ui.pages.PlaceOrderPage;
import com.util.Common;

public class PlaceOrder_tc {
	
	public WebDriver driver=null;
	
		// Grouping: (groups = { "Fees and Orders" })
		//Dependent Test: (dependsOnMethods = { "methodName" })
		//@Test(priority = 0, alwaysRun = true)
		//@Test( enabled=false )
		//Description of test: description="Some text"
	
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
	public void PO_YourCompany_Mdt() throws InterruptedException {
		PlaceOrderPage.EnterYourCompanyMdtFields(driver);
	}
	
	@Test(priority=3,description="This testcase is to enter values for only optional fields in YOUR COMPANY section")
	public void PO_YourCompany_Opt() throws InterruptedException {
		PlaceOrderPage.EnterYourCompanyOptFields(driver);
	}
	
	@Test(priority=4,description="This testcase is to enter values for only Mandatory fields in PROPERTY ADDRESS section")
	public void PO_PropertyAdd_mdt() throws InterruptedException {
		PlaceOrderPage.EnterPropertyAddMdtFields(driver);
	}
	
	@Test(priority=5,description="This testcase is to enter values for only Mandatory fields in PROPERTY ADDRESS section")
	public void PO_PropertyAdd_opt() throws InterruptedException {
		PlaceOrderPage.EnterPropertyAddOptFields(driver);
	}
	
	@Test(priority=6,dependsOnMethods = {"PO_PropertyAdd_mdt" },description="This test case is to enter values for "
			+ "mandatory fields for Order details section")
	public void PO_OrderDetails_mdt() throws InterruptedException {
		PlaceOrderPage.EnterOrderDetailsMdtFields(driver);
	}
	
	@Test(priority=7,dependsOnMethods = {"PO_PropertyAdd_mdt" },description="This test case is to enter values for "
			+ "optional fields for Order details section")
	public void PO_OrderDetails_opt() throws InterruptedException {
		PlaceOrderPage.EnterOrderDetailsOptFields(driver);
	}
	
	@Test(priority=8,description="This test case is to enter values for Mandatory fields of File Details section")  
	public void PO_FileDetails_mdt() throws InterruptedException {
	}
	
	@Test(priority=9,description="This test case is to enter values for Mandatory fields of File Details section")  
	public void PO_FileDetails_opt() throws InterruptedException {
		PlaceOrderPage.EnterFileDetailsOptFields(driver);
	}
	
	@Test (priority=10) 
	public void PO_PrimaryBuyerBrwrMdt() throws InterruptedException {
		PlaceOrderPage.EnterPrimaryBorrowerMdtFields(driver);
		
	}
	@Test (priority=11) 
	public void PO_PrimaryBuyerBrwrOpt() throws InterruptedException {
		PlaceOrderPage.EnterPrimaryBorrowerOptFields(driver);
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		if(driver!=null) {
//			System.out.println("Closing IE browser");
//			driver.quit();
//		}
//	}
}
