package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccounts extends Basepage{
	public myaccounts(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgheading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlogout;
	public boolean ismyacct()
	{
		try
		{
			return(msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;	
		}
		
	
	}
	
	public void logout()
	{
		btnlogout.click();
	}
	
}
