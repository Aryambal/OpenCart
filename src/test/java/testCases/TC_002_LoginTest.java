package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Login_Page;
import pageObjects.MyAccount_Page;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	
	
	@Test(groups= {"Sanity", "Master"})
	public void Login_Test() 
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{
		logger.info("Clicking the Login link");
		Home_Page hp=new Home_Page(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		
		Login_Page lp=new Login_Page(driver);
		
		logger.info("Entering the Login Details");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		logger.info("Verifying the Account Page");
		MyAccount_Page myaccp=new MyAccount_Page(driver);
		boolean targetpage=myaccp.isMyAccount_PageExists();
		if(targetpage==true)
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			Assert.assertTrue(false);
			logger.info("Login not Successful");
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished LoginTest");
		
		
	}
	
	
	
}
