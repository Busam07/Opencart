package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	public void clickmyaccount()
		{
		lnkMyaccount.click();
		}
	
	public void clickregister()
		{
		lnkRegister.click();
		}
	public void clicklogin()
	{
		lnklogin.click();
	}
}

