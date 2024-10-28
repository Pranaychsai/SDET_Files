package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		plogger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.myAccountClick();
			plogger.info("**** myAccountClick TC_003_LoginDDT *****");
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.loginButtonClick(); //Login link under MyAccount
			lp.emailBoxClick(email);
			lp.passwordBoxClick(password);
			lp.submitLoginButtonClick(); //Login button
			plogger.info("**** submitLoginButtonClick TC_003_LoginDDT *****");	
			//My Account Page
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			plogger.info("**** targetPage TC_003_LoginDDT *****");
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				plogger.info("**** Valid *****");
				if(targetPage==true)
				{
					hp.myAccountClick();
					hp.logoutClick();
					hp.logoutContinueButtonClick();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				plogger.info("**** InValid *****");
				if(targetPage==true)
				{
					hp.myAccountClick();
					hp.logoutClick();
					hp.logoutContinueButtonClick();
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
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		plogger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








