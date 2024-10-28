package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Login']") WebElement loginButton;
	
	@FindBy(xpath="//input[@name='email']") WebElement emailBox;
	
	@FindBy(xpath="//input[@name='password']") WebElement passwordBox;
	
	@FindBy(xpath="//input[@type='submit']") WebElement submitButton;
	
	
	
	public void loginButtonClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
	
	public void emailBoxClick(String s)
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(emailBox)).sendKeys(s);
	}
	
	public void passwordBoxClick(String s)
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(passwordBox)).sendKeys(s);
	}
	
	public void submitLoginButtonClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
}
