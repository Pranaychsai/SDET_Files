package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void goToRegister() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		//hp.myAccountClick();// some problem with browser so clicking two times
		plogger.info("Running myAccountClick");
		hp.myAccountClick();
		plogger.info("Running registerClick");
		hp.registerClick();
		//Thread.sleep(300);
		RegistrationPage regpage=new RegistrationPage(driver);
		
		plogger.info("Running RegistrationPage Details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='70%'");

		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setTelephone(randomeString().toUpperCase());
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			plogger.info("final string matched");
		}
		else
		{
			plogger.error("Test failed since final string does not Match");
			Assert.assertTrue(false);
		}
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
		
		//Login of Account
		hp.myAccountClick();
		hp.logoutClick();
		hp.logoutContinueButtonClick();
	}
	

}
