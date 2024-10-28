package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	//constructor
	public HomePage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locators
	//By myAccount=By.xpath("//*[@id='top']/div/div[2]/ul/li[2]/div/a/span");
	//By register=By.xpath("//*[@id='top']/div/div[2]/ul/li[2]/div/ul/li[1]/a");
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logoutButton;
	
	@FindBy(xpath="//a[text()='Continue']") WebElement logoutContinueButton;
	
	//Action Methods
	public void myAccountClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();

	}
	
	public void registerClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
	}
	
	public void logoutClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	}
	
	public void logoutContinueButtonClick()
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(logoutContinueButton)).click();
	}

}
