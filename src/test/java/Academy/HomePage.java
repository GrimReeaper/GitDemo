package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;


public class HomePage extends base{
	
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());

	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));

		
		landingPage lP=new landingPage(driver);
		lP.getLogIn().click();
		
		loginPage loP=new loginPage(driver);
		loP.enterEmail().sendKeys(Username);
		Log.info("Email Address Entered Successfully");
		loP.enterPassword().sendKeys(Password);
		Log.info("Password Entered Successfully");
		loP.logInBtn().click();
		System.out.println("Welcome to Home Page");
	}
	
	@DataProvider
	public Object[][] getData()
	{
	 Object [][] data=new Object[2][2];
	 data[0][0]="shivamnagpal67@gmail.com";
	 data[0][1]="Shivam129nagpal";
	 
	 
	 data[1][0]="shivamnagpal@gmail.com";
	 data[1][1]="Shivam129nagpal";
	 
	 return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
