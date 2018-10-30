/**
 * 
 */
package com.mpt.ui.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mpt.base.TestBase;

/**
 * @author beheraav
 *
 */
public class HomePage extends TestBase{

	//Page Factory - Object Repository
	
	@FindBy(linkText="Contact Us")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[@class='router-link-exact-active router-link-active']")
	public static WebElement MptLogo;
	
	@FindBy(xpath="//span[@class='contact-us-text' and contains(.,'Email')]")
	WebElement contactUsEmail;
	
	@FindBy(xpath="//span[@class='contact-us-text' and contains(.,'Call us')]")
	WebElement contactUsPhone;
	
	//Initialize all elements of this page(Page Objects)
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Features
	public boolean verifyLogo(){
		return MptLogo.isDisplayed();
	}
	
	public boolean veifyContactUSinfo(String email, String phone){
		boolean resultEmail=false;
		boolean resultPhone=false;
		String actualEmail=contactUsEmail.getText();
		String actualPhone=contactUsPhone.getText();
		if(actualEmail.equals(email)){
			resultEmail=true;
		}
		else if(actualPhone.equals(phone)){
			resultPhone=true;
		}
		return resultEmail && resultPhone;
	}
	
}
