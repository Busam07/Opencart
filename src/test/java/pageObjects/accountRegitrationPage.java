package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegitrationPage extends Basepage
{
	public accountRegitrationPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtpassconf;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normlize-space()='Your Account Has Been Created!']")
	WebElement msgconform;
	
	//actoins
	public void setfname(String fname)
	{
		txtfname.sendKeys(fname);
	}
		
	public void setlname(String lname)
		{
			txtlname.sendKeys(lname);
		}
		
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setphone(String phone)
	{
		txtphone.sendKeys(phone);
	}
	
	public void setpassword(String password)
		{
		txtpass.sendKeys(password);
		}
	public void setpassconf(String passconf)
	{
		txtpassconf.sendKeys(passconf);
	}
	public void setagree()
	{
		agree.click();
	}
	public void setnext()
	{
		btncontinue.click();
	}
	
	public String getconformmsg() {
		try {
			return(msgconform.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
		
		
			
		
}
