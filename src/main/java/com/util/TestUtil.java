/**
 * 
 */
package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mpt.ui.pages.HomePage;

/**
 * @author beheraav
 *
 */
public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=10;
	
	public static void FlWait(WebElement locator,WebDriver driver) throws InterruptedException{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(60, TimeUnit.SECONDS)
		        .pollingEvery(200, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class);
		WebElement element = (new WebDriverWait(driver, 50))
				   .until(ExpectedConditions.visibilityOf(locator));
		Thread.sleep(8000);
	}
}
