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


public class validateNavigationBar extends base{
	
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		landingPage lP= new landingPage(driver);
		Boolean BarDisplay=lP.NavDisplay().isDisplayed();
		Assert.assertTrue(BarDisplay);
		Log.info("Navigation Bar is displayed");

		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

