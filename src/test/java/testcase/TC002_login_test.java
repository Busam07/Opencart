package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginpage;
import pageObjects.myaccounts;

public class TC002_login_test extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_login()
	{
		logger.info("***login page****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		loginpage lp=new loginpage(driver);
		lp.setloginemail(p.getProperty("email"));
		lp.setloginpass(p.getProperty("password"));
		lp.clicklogin();
		
		myaccounts macc=new myaccounts(driver);
		boolean myaccct= macc.ismyacct();
		
		Assert.assertTrue(myaccct);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***finished login  test****");
		
	}
	
	
}
