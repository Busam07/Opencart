package testcase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger  logger;
	public Properties p;
	
	@BeforeClass(groups={"Sanity","Master","Regression"})
	@Parameters ({"os","browser"})
	public void setup( String os, String br) throws IOException
	{
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case"chrome":driver=new ChromeDriver();break;
		case"edge":driver=new EdgeDriver();break;
		default:System.out.println("invalid...");return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass(groups={"Sanity","Master","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	public String ranplhabet()
	{
		String genstring=RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}
	public String rannumeric ()
	{
		String gennum=RandomStringUtils.randomNumeric(5);
		return gennum;
	}
	public String ranaplpha()
	{
		String genalphastrg=RandomStringUtils.randomAlphabetic(3);
		String genalphanum=RandomStringUtils.randomNumeric(3);
		return (genalphastrg+"@"+genalphanum);
	}
	
	public String captureScreen(String tname) {
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timestamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourcefile.renameTo(targetFile);
		return targetFilePath;
		
		
	}
	
	
}