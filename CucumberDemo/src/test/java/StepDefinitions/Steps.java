package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;
	@Given("User opens an application")
	public void user_opens_an_application() {
	    
	    driver = new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    
	  
	}

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
	    
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

	@When("User provide \\(username: {string}, password: {string})")
	public void user_provide_username_and_password(String username, String Password) {
	    
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	}

	@When("User clicked on submit button")
	public void user_clicked_on_submit_button() {
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

	@Then("Myaccount page needs to be displayed")
	public void myaccount_page_needs_to_be_displayed() {
		
		boolean display=driver.findElement(By.xpath("//*[@id='content']/h2[1]")).isDisplayed();
		Assert.assertEquals(display,true);
		
	}

	@Then("username should be on the page")
	public void username_should_be_on_the_page() {

		driver.quit();
	}
}
