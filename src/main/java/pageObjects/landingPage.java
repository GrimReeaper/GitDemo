package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement clickOnLogin;
	
	@FindBy(xpath="//div//h2[contains(text(),'Featured Courses')]")
	WebElement pageTitle;
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav navbar-right\"]")
	WebElement NavBar;
	
	public WebElement getLogIn()
	{
		return clickOnLogin;
	}
	
	public WebElement getTitle()
	{
		return pageTitle;
	}
	
	public WebElement NavDisplay()
	{
		return NavBar;
	}

}
