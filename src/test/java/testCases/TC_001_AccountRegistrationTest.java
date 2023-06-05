package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Register_Page;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{

	@Test(groups= {"Regression", "Master"})
	public void Account_Registration_Test()
	{
		try
		{
		logger.info("Starting TC_001_AccountRegistration");
		Home_Page hp=new Home_Page(driver);
		
		logger.info("Clicking on MyAccount link");
		hp.clickMyAccount();
		logger.info("Clicking on Register link");
		hp.clickRegister();
	
	
		logger.info("Entering Customer Details");
		Register_Page rp=new Register_Page(driver);
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String pwd=randomAlphaNumeric();
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		
		rp.setAgree();
		rp.setContinue();
		
		
		String cnfrmmsg= rp.getmsgConfirmation();
		if(cnfrmmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println(cnfrmmsg);
			logger.error("Test Failed");
			logger.warn("Customer registration is not successful");
			Assert.assertTrue(false);
		}			
		}
		catch(Exception e)
		{
			Register_Page rp=new Register_Page(driver);
			//String cnfrmmsg= rp.getmsgConfirmation();
			//System.out.println(cnfrmmsg);
			Assert.fail();
		}
		
		logger.info("Finished Account Registration");
	}
}