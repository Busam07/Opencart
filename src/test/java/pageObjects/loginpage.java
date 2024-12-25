package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends Basepage {
	public loginpage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	
	public void setloginemail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void setloginpass(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void clicklogin()
	{
		btnlogin.click();
	}
	
}
