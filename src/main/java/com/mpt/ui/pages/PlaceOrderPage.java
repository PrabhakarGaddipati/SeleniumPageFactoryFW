/**
 * 
 */
package com.mpt.ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mpt.base.TestBase;
import com.util.Common;

/**
 * @author beheraav
 *
 */
public class PlaceOrderPage extends TestBase{
	
	//Locators
	public static String YC_compName="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div[@class='form-group row required-mark' and contains(.,'Company Name')]/div/input";
	public static String YC_compPhone="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div[@class='form-group row required-mark' and contains(.,'Company Phone')]/div/input";
	public static String YC_contactName="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div[@class='form-group row required-mark' and contains(.,'Contact Name')]/div/input";
	public static String YC_Email="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div[@class='form-group row required-mark' and contains(.,'Email Address')]/div/input";
	public static String YC_Add="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div[@class='form-group row' and contains(.,'Address')]/div/input";
	public static String YC_zip="//div[@class='card border-light-dark mb-3']/div[@class='card-body']/div/div[@class='form-group row' and contains(.,'Zip')]/div/input";
	
	public static String PA_Number="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div[contains(.,'Number')]/div/input";
	public static String PA_Direction="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div[contains(.,'Direction')]/div/div/div/input";
	public static String PA_Street="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div[contains(.,'Street Name')]/div/input";
	public static String PA_suffix="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div[contains(.,'Suffix')]/div/div/div/input";
	public static String PA_Unit="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div[contains(.,'Unit')]/div/input";
	public static String PA_zip="//div[@class='card border-light-dark mb-3' and contains(.,'PROPERTY ADDRESS')]/div[@class='card-body']/div/div/div[@class='form-group row required-mark' and contains(.,'Zip')]/div/input";
	public static String PA_Unincorporated="//div[@class='custom-control custom-checkbox']/label[contains(.,'Unincorporated')]";
	
	public static String OD_ClientFileNumber="//div[@class='card border-light-dark mb-3' and contains(.,'ORDER DETAILS')]/div/div[contains(.,'File Number')]/div/input";
	public static String OD_TransactionType="//div[@class='card border-light-dark mb-3' and contains(.,'ORDER DETAILS')]/div/div/div[@class='form-group row required-mark' and contains(.,'Transaction')]/div/div/div";
	public static String OD_ProdService="//div[@class='card border-light-dark mb-3' and contains(.,'ORDER DETAILS')]/div/div/div[@class='form-group row required-mark' and contains(.,'Product')]/div/div/div";
	
	public static String FD_EstSetDate="//div[@class='card border-light-dark mb-3' and contains(.,'FILE DETAILS')]/div/div[contains(.,'Estimated Settlement Date')]/div/div/div/div/input";
	public static String FD_FstMortgaee="//div[@class='card border-light-dark mb-3' and contains(.,'FILE DETAILS')]/div/div[contains(.,'First Mortgagee')]/div/input";
	public static String FD_SecMortgaee="//div[@class='card border-light-dark mb-3' and contains(.,'FILE DETAILS')]/div/div[contains(.,'Second Mortgagee')]/div/input";
	
	public static String PBB_Type="//div[contains(.,'PRIMARY BUYER')]/div/div/div/div[contains(.,'Type') and @class='form-group row required-mark']/div/div/div";
	public static String PBB_Prefix="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Prefix')]/div/div/div/input";
	public static String PBB_Fname="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row required-mark' and contains(.,'First Name')]/div/input";
	public static String PBB_Mname="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row' and contains(.,'Middle Name')]/div/input";
	public static String PBB_Lname="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row required-mark' and contains(.,'Last Name')]/div/input";
	public static String PBB_Suffix="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Suffix')]/div/div/div/input";
	public static String PBB_MaritalStatus="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Marital')]/div/div/div/input";
	public static String PBB_SocialSecNo="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row' and contains(.,'Social')]/div/input";
	public static String PBB_Phone="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row' and contains(.,'Phone')]/div/input";
	public static String PBB_Email="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[@class='form-group row' and contains(.,'Email')]/div/input";
	public static String PBB_Prefix_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Prefix')]/div/div/div/input";
	public static String PBB_Fname_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'First')]/div/input";
	public static String PBB_Mname_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Middle')]/div/input";
	public static String PBB_Lname_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Last')]/div/input";
	public static String PBB_Suffix_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Suffix')]/div/div/div/input";
	public static String PBB_SocialSecNo_m="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Social')]/div/input";
	public static String PBB_CPaddCheckBox="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/input";
	public static String PBB_CPstreetName="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Street')]/div/input";
	public static String PBB_CPunit="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Unit')]/div/input";
	public static String PBB_CPzip="//div[@class='card border-light-dark mb-3' and contains(.,'PRIMARY BUYER')]/div/div/div/div/div[contains(.,'Zip')]/div/div/input";
	
	public static String ACB_ExpandCollapse="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div";
	public static String ACB_Type="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div[@class='form-group row required-mark' and contains(.,'Type:')]/div/div/div/input";
	public static String ACB_Prefix="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Prefix:')]/div/div/div/input";
	public static String ACB_Fname="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'First Name')]/div/input";
	public static String ACB_Mname="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Middle Name')]/div/input";
	public static String ACB_Lname="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Last Name')]/div/input";
	public static String ACB_Suffix="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Suffix:')]/div/div/div/input";
	public static String ACB_MaritalStatus="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Marital Status')]/div/div/div/input";
	public static String ACB_SocialSecurity="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Social')]/div/input";
	public static String ACB_Phone="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Phone')]/div/input";
	public static String ACB_Email="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Email')]/div/input";
	public static String ACB_Prefix_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Prefix:')]/div/div/div/input";
	public static String ACB_Fname_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'First')]/div/input";
	public static String ACB_Mname_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Middle')]/div/input";
	public static String ACB_Lname_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Last')]/div/input";
	public static String ACB_Suffix_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Suffix:')]/div/div/div/input";
	public static String ACB_socialSecurity_m="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'If married')]/div[contains(.,'Social')]/div/input";
	public static String ACB_CPaddCheckBox="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/input";
	public static String ACB_CPaddress="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[@class='form-group required-mark row' and contains(.,'Address:')]/div/input";
	public static String ACB_CPunit="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Unit')]/div/input";
	public static String ACB_CPzip="//div[@class='card border-light-dark mb-3' and contains(.,'ADDITIONAL CO-BUYER')]/div/div/div/div/div[contains(.,'Zip')]/div/div/input";
	
	public static String Seller_Type="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div[contains(.,'Type')]/div/div/div/input";
	public static String Seller_Prefix="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Prefix')]/div/div/div/input";
	public static String Seller_Fname="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'First')]/div/input";
	public static String Seller_Mname="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Middle')]/div/input";
	public static String Seller_Lname="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Last')]/div/input";
	public static String Seller_Suffix="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Suffix')]/div/div/div/input";
	public static String Seller_MaritalStatus="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Marital')]/div/div/div/input";
	public static String Seller_SocialSecurity="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Social')]/div/input";
	public static String Seller_Phone="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Phone')]/div/input";
	public static String Seller_Email="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/div[contains(.,'Email')]/div/input";
	
	
	public static String Seller_CPaddCheckBox="//div[@class='card border-light-dark mb-3' and contains(.,'SELLER') and not(contains(.,'ADDITIONAL'))]/div/div/div/div/input";
	
	
	
	
	//Methods for Place Order Page
	public static void navURL(WebDriver driver) throws InterruptedException{
		System.out.println("****** Navigating to the URL: "+Common.PTS_URL);
		driver.navigate().to(Common.PTS_URL);
//		driver.manage().window().fullscreen();
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
//		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(60, TimeUnit.SECONDS)
		        .pollingEvery(200, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class);
		WebElement element = (new WebDriverWait(driver, 50))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath(YC_compName)));
		Thread.sleep(8000);
	}
	
	public static void EnterYourCompanyMdtFields(WebDriver driver){
		System.out.println("***** Entering Mandatory values in YOUR COMPANY section****");
		driver.findElement(By.xpath(YC_compName)).sendKeys("Demo Company");
		driver.findElement(By.xpath(YC_compPhone)).sendKeys("8888888888");
		driver.findElement(By.xpath(YC_contactName)).sendKeys("Test Name");
		driver.findElement(By.xpath(YC_Email)).sendKeys("avishek.behera@altisource.com");
		driver.findElement(By.xpath(YC_Add)).sendKeys("123 Test Street address, #Survey 16, Bangalore");
		driver.findElement(By.xpath(YC_zip)).sendKeys("96001");
	}
	
	public static void EnterYourCompanyOptFields(WebDriver driver) throws InterruptedException{
		System.out.println("***** Entering Optional values in YOUR COMPANY section****");
		driver.findElement(By.xpath(YC_Add)).sendKeys("123 Test Street address, #Survey 16, Bangalore");
		driver.findElement(By.xpath(YC_zip)).sendKeys("96001");
		Thread.sleep(2000);
	}
	
	public static void EnterPropertyAddMdtFields(WebDriver driver) throws InterruptedException{
		System.out.println("***** Entering Mandatory values in PROPERTY ADDRESS section****");
		driver.findElement(By.xpath(PA_Number)).sendKeys("15");
		driver.findElement(By.xpath(PA_Street)).sendKeys("5678 Test Street, # 53 Lane,Bangalore, Karnataka");
		driver.findElement(By.xpath(PA_zip)).sendKeys("55555");
		Thread.sleep(3000);
	}
	
	public static void EnterPropertyAddOptFields(WebDriver driver) throws InterruptedException{
		System.out.println("***** Entering Optional values in PROPERTY ADDRESS section****");
		driver.findElement(By.xpath(PA_Direction)).sendKeys("North");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PA_Direction)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PA_suffix)).sendKeys("Arcade");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PA_suffix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PA_Unit)).sendKeys("54");
	}
	
	public static void EnterOrderDetailsMdtFields(WebDriver driver) throws InterruptedException{
		String TransactionTypeText=null;
		String ProductText=null;
		try{
			TransactionTypeText=driver.findElement(By.xpath(OD_TransactionType+"/span")).getText();
			System.out.println("A default value for Transaction type is  found:"+TransactionTypeText);
		}
		catch (Exception e){
			System.out.println("A default value for Transaction type is not found!!");
		}
		if(TransactionTypeText==null){
			driver.findElement(By.xpath(OD_TransactionType)).sendKeys("Refinance");
			Thread.sleep(1000);
			driver.findElement(By.xpath(OD_TransactionType)).sendKeys(Keys.ENTER);
		}
		try{
			ProductText=driver.findElement(By.xpath(OD_ProdService+"/span")).getText();
			System.out.println("A default value for Product/Service is  found:"+ProductText);
		}
		catch (Exception e){
			System.out.println("A default value for Product/Service is not found!!");
		}
		if(ProductText==null){
			driver.findElement(By.xpath(OD_ProdService)).sendKeys("Refinance – Title & Escrow");
			Thread.sleep(1000);
			driver.findElement(By.xpath(OD_ProdService)).sendKeys(Keys.ENTER);
		}
		driver.findElement(By.xpath(OD_ClientFileNumber)).sendKeys("TestClientNum123");
	}
	
	public static void EnterOrderDetailsOptFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(OD_ClientFileNumber)).sendKeys("TestClientNum123");
	}
	
	public static void EnterFileDetailsMdtFields(WebDriver driver) throws InterruptedException{
		
	}
	
	public static void EnterFileDetailsOptFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(FD_EstSetDate)).sendKeys("10/26/2018");
		driver.findElement(By.xpath(FD_FstMortgaee)).sendKeys("First Test Mortgaee");
		driver.findElement(By.xpath(FD_SecMortgaee)).sendKeys("Second Test Mortgaee");
		
	}
	
	public static void EnterPrimaryBorrowerMdtFields(WebDriver driver) throws InterruptedException{
		String TypeText=null;
		try{
			TypeText=driver.findElement(By.xpath(PBB_Type+"/span")).getText();
			System.out.println("A default value for Type is  found:"+TypeText);
		}
		catch (Exception e){
			System.out.println("A default value for Type is not found!!");
			
		}
		if(TypeText==null){
			driver.findElement(By.xpath(PBB_Type)).sendKeys("Individual");
			Thread.sleep(1000);
			driver.findElement(By.xpath(PBB_Type)).sendKeys(Keys.ENTER);
		}
		driver.findElement(By.xpath(PBB_Fname)).sendKeys("Test Primary buyer");
		driver.findElement(By.xpath(PBB_Lname)).sendKeys("Test Last Name");
	}
	
	public static void EnterPrimaryBorrowerOptFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(PBB_Prefix)).sendKeys("Dr.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PBB_Prefix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PBB_Mname)).sendKeys("Test Middle name");
		driver.findElement(By.xpath(PBB_Suffix)).sendKeys("4th");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PBB_Suffix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PBB_MaritalStatus)).sendKeys("Married");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PBB_MaritalStatus)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PBB_SocialSecNo)).sendKeys("987654321");
		driver.findElement(By.xpath(PBB_Phone)).sendKeys("88888888");
		driver.findElement(By.xpath(PBB_Email)).sendKeys("avishek.behera@altisource.com");
	}
	
	public static void EnterPrimaryBorrowerMarriedFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(PBB_Prefix_m)).sendKeys("Mrs.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PBB_Prefix_m)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PBB_Fname_m)).sendKeys("Test First name");
		driver.findElement(By.xpath(PBB_Mname_m)).sendKeys("Test First name");
		driver.findElement(By.xpath(PBB_Lname_m)).sendKeys("Test First name");
		driver.findElement(By.xpath(PBB_Suffix_m)).sendKeys("3rd");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PBB_Suffix_m)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(PBB_SocialSecNo_m)).sendKeys("5454546654");
		driver.findElement(By.xpath(PBB_CPaddCheckBox)).sendKeys(Keys.SPACE);
		
	}
	
	public static void EnterAdditionalCoBuyerMdtFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(ACB_ExpandCollapse)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ACB_Type)).sendKeys("Individual");
		driver.findElement(By.xpath(ACB_Type)).sendKeys(Keys.ENTER);
	}
	
	public static void EnterAdditionalCoBuyerOptFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(ACB_Prefix)).sendKeys("Mrs.");
		driver.findElement(By.xpath(ACB_Prefix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ACB_Fname)).sendKeys("Test First name");
		driver.findElement(By.xpath(ACB_Mname)).sendKeys("Test Middle name");
		driver.findElement(By.xpath(ACB_Lname)).sendKeys("Test Last name");
		driver.findElement(By.xpath(ACB_Suffix)).sendKeys("4th");
		driver.findElement(By.xpath(ACB_Suffix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ACB_MaritalStatus)).sendKeys("Married");
		driver.findElement(By.xpath(ACB_MaritalStatus)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ACB_SocialSecurity)).sendKeys("8877889945");
		driver.findElement(By.xpath(ACB_Phone)).sendKeys("8877889945");
		driver.findElement(By.xpath(ACB_Email)).sendKeys("avishek.behera@altisource.com");
	}
	
	public static void EnterAdditionalCoBuyerMarriedFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(ACB_Prefix_m)).sendKeys("Dr.");
		driver.findElement(By.xpath(ACB_Prefix_m)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ACB_Fname_m)).sendKeys("Test First Name");
		driver.findElement(By.xpath(ACB_Mname_m)).sendKeys("Test Middle Name");
		driver.findElement(By.xpath(ACB_Lname_m)).sendKeys("Test Last Name");
		driver.findElement(By.xpath(ACB_Suffix_m)).sendKeys("3rd");
		driver.findElement(By.xpath(ACB_Suffix_m)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ACB_socialSecurity_m)).sendKeys("888445555");
		driver.findElement(By.xpath(ACB_CPaddCheckBox)).sendKeys(Keys.SPACE);
		
	}
	
	public static void EnterSellerMdtFields(WebDriver driver) throws InterruptedException{
//		driver.findElement(By.xpath(Seller_Type))).sendKeys("");
//		driver.findElement(By.xpath(Seller_Type)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(Seller_Fname)).sendKeys("Test First");
		driver.findElement(By.xpath(Seller_Lname)).sendKeys("Test Last");
	}
	
	public static void EnterSellerOptFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(Seller_Prefix)).sendKeys("Dr.");
		driver.findElement(By.xpath(Seller_Prefix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(Seller_Mname)).sendKeys("Test Middle");
		driver.findElement(By.xpath(Seller_Suffix)).sendKeys("2nd");
		driver.findElement(By.xpath(Seller_Suffix)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(Seller_MaritalStatus)).sendKeys("Married");
		driver.findElement(By.xpath(Seller_MaritalStatus)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(Seller_SocialSecurity)).sendKeys("887877887");
		driver.findElement(By.xpath(Seller_Phone)).sendKeys("8878788888");
		driver.findElement(By.xpath(Seller_Email)).sendKeys("avishek.behera@altisource.com");
	}
	
	public static void EnterSellerMarriedFields(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath(Seller_Fname)).sendKeys("Test First");
		
		
		driver.findElement(By.xpath(Seller_Lname)).sendKeys(Keys.SPACE);
		
	}
}
