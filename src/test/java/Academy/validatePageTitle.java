package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.landingPage;
import resources.base;


public class validatePageTitle extends base{

	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		Log.info("Driver Initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Successfully landed homepage");
		
	}	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		landingPage lP= new landingPage(driver);
		
		String actualTitle=lP.getTitle().getText();
		String expectedTitle="FEATURED COURSES123";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified the text");
				
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		Log.info("Driver closed");
	}
}

