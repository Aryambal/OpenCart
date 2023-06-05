package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Login_Page;
import pageObjects.MyAccount_Page;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDTest extends BaseClass
{

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void Login_DDT(String email,String pwd,String exp)
	{
		logger.info("Starting Login DDT .......");
		
		try
		{
		
		Home_Page hp=new Home_Page(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Login_Page lp=new Login_Page(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		logger.info("Successfuly Logged In");
		MyAccount_Page myaccp=new MyAccount_Page(driver);
		boolean targetpage=myaccp.isMyAccount_PageExists();
		
		
		
		if(exp.equals("Valid"))
		{
			logger.info("If both Email and Password Valid");
			if(targetpage==true)
			{
				myaccp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		
		}
		
		if(exp.equals("Invalid"))
		{
			logger.info("If Either Email or Password Invalid");
			if(targetpage==true)
			{
				MyAccount_Page myaccpage=new MyAccount_Page(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}

		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished LoginDDT............");
		
	}
		
}
