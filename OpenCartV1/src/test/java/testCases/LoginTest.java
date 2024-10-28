package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test(groups= {"Master","Regression"})
	public void loginTestCase()
	{
		try
		{
		
		HomePage hp = new HomePage(driver); 
		plogger.info("Logging to the Page");
		hp.myAccountClick();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButtonClick();
		lp.emailBoxClick(p.getProperty("email"));
		plogger.info("Email ID provided");
		lp.passwordBoxClick(p.getProperty("password"));
		plogger.info("Password Provided");
		lp.submitLoginButtonClick();
		plogger.info("clicked on login button..");
		System.out.println("Running testMethod");
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage = mp.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage,true);
		plogger.info("Login Succeed");
		}
		catch(Exception e)
		{
			plogger.error("Login Failed.. check the credentials");
			Assert.fail();
		}
	
		plogger.info("**** Finished LoginTest  ****");
		
	}
}
