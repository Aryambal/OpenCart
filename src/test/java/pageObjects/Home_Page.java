package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page
{
		
	public Home_Page(WebDriver driver)
	{
		super(driver);
	}
	
	//Locating all the Elements
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	
	
	//Actions
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
		
	}
	
	public void clickRegister()
	{
		linkRegister.click();
		
	}
	
	public void clickLogin()
	{
		linkLogin.click();
		
	}
	
	
}
