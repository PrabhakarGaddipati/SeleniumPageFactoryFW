/**
 * 
 */
package com.mpt.ui.pages;

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
	WebElement MptLogo;
	
	//Initialize all elements of this page(Page Objects)
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Features
	public boolean verifyLogo(){
		return MptLogo.isDisplayed();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
}
