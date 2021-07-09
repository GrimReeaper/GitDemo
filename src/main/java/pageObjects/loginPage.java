package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="user_email")
	WebElement emailAddress;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath="//div//input[@type=\"submit\"]")
	WebElement logIn;
	
	public WebElement enterEmail()
	{
		return emailAddress;
	}
	
	public WebElement enterPassword()
	{
		return password;
	}
	
	public WebElement logInBtn()
	{
		return logIn;
	}

}
