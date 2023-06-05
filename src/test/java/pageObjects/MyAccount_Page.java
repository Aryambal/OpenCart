package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends Base_Page
{

	public MyAccount_Page(WebDriver driver)
	{
		super(driver);
	}
	
	//Locating Elements
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headingMyAccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement linkLogout;
	
	//Actions for the WebElements
	
	public boolean isMyAccount_PageExists()
	{
		try
		{
		return headingMyAccount.isDisplayed();
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clickLogout()
	{
		linkLogout.click();
		
		//linkLogout.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(linkLogout).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", linkLogout);
		
		//Sol 5
		//linkLogout.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(linkLogout)).click();

		
	}

	
	
}
