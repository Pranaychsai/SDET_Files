package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//*[@id='content']/h2[1]") WebElement myAccountHeader;
	
	public boolean isMyAccountPageExists()
	{

			if(myAccountHeader.isDisplayed())
			{
				return true;
			}
			else
			{	
				return(false);
			}
	}
	

}
