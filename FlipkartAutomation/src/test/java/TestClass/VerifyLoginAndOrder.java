package TestClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Browser;
import PomClasses.LoginPage;
import PomClasses.MainPage;
import utils.Utility;

public class VerifyLoginAndOrder {
	WebDriver driver;
	LoginPage loginpage;
	MainPage mainpage;
	ArrayList<String> addr;
	@Parameters("browsername")
	@BeforeTest
	public void lauchdriver(String browser)
	{
		System.out.println(browser);
	if(browser.equals("Chrome"))
	{
		driver=Browser.openChromeBrowser();
	}
	if(browser.equals("Firefox"))
	{
		driver=Browser.openFirefoxBrowser();
	}
	if(browser.equals("Edge"))
	{
		driver=Browser.openEdgeBrowser();
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	  @BeforeClass
	  public void DeclareObject()
	  {
		  loginpage = new LoginPage(driver);
		  mainpage = new MainPage(driver);
		  
	  }
	  @BeforeMethod
	  public void LaunchFlipkart() throws Exception
	  {
		  driver.get("https://www.flipkart.com/");
		  Thread.sleep(5000);

          loginpage.SendMobile(Utility.getDataFromExcel(2, 0));
		  
		  loginpage.SendPassw(Utility.getDataFromExcel(2, 1));
		  loginpage.clickLogin();
	  }
	  
	  @Test
	  public void AddItems() throws Exception
	  {
		  Thread.sleep(2000);
		  mainpage.SearchBoxClick();
		  mainpage.SearchButtonClick();
		  Thread.sleep(5000);
		  mainpage.iphoneSelect();
		  Thread.sleep(5000);
		  addr = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(addr.get(1));
	      Thread.sleep(2500);
	      mainpage.ClickAddtoCart();
	      Thread.sleep(3000);
	  }
	  
	 @AfterMethod
	  public void LogoutFromApp(ITestResult result) throws Exception
	  { 
		 if (ITestResult.SUCCESS==result.getStatus())
		 {
			 Utility.captureScreenshot(driver, 10);
		 }
		
		 Thread.sleep(2500);
	    mainpage.LogoutProfile();
	  }
	 @AfterClass
	 public void ClearObject()
	 {
		 loginpage = null;
		 mainpage = null;
	 }
	  
	  @AfterTest
	  public void CloseBrowse()
	  {
		  driver.quit();
		  driver=null;
		  System.gc();
	  }
	  
}  

