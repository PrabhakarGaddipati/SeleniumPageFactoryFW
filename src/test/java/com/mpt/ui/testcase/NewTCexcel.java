/**
 * 
 */
package com.mpt.ui.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mpt.base.TestBase;
import com.util.Common;
import com.util.ExcelReader;


/**
 * @author beheraav
 *
 */
public class NewTCexcel extends TestBase{
	
	WebDriver driver;
	
	@Test(dataProvider="testdata")
	public void DemoProj(String username,String password) throws InterruptedException
	{
		driver=Common.initWebDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
		ExcelReader config=new ExcelReader("C:\\Users\\beheraav\\workspace\\MPT_Automation\\src\\main\\java\\com\\util\\testDataFile.xlsx");
		int rows=config.getRowCount(0);
		Object[][] credentials=new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			credentials[i][0]=config.getData(0, i, 0);
			credentials[i][1]=config.getData(0, i, 1);
		}
		return credentials;
	}
	
}
