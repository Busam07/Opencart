package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountRegitrationPage;

public class TC001_acc_reg_test extends BaseClass{
		
	
	@Test(groups={"Sanity","Master"})
	public void verify_acc_reg() throws InterruptedException 
	{
		logger.info("***start**");
		
	HomePage hp=new HomePage(driver);
	hp.clickmyaccount();
	hp.clickregister();
	logger.info("**registration page**");
	
	accountRegitrationPage arp=new accountRegitrationPage(driver);
	arp.setfname(ranplhabet());
	arp.setlname(ranplhabet());
	arp.setemail(ranplhabet()+"@gmail.com");
	arp.setphone(rannumeric());
	String psw=ranaplpha();
	arp.setpassword(psw);
	arp.setpassconf(psw);
	
	arp.setagree();
	arp.setnext();
	
	Thread.sleep(2000);
	String msgmsg=arp.getconformmsg();
	
	Assert.assertEquals(msgmsg,arp.getconformmsg() );
	logger.info("**finished**");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
