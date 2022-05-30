package TestClass;

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
import PomClasses.FilpkartFashion;
import PomClasses.LoginPage;
import PomClasses.MainPage;
import utils.Utility;

public class VerifyFashionPage{
	WebDriver driver;
	LoginPage loginpage;
	MainPage mainpage;
    FilpkartFashion flipkartfashion;
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
		flipkartfashion= new FilpkartFashion(driver);
	  }
	  @BeforeMethod
	  public void LaunchFlipkart() throws Exception
	  {
		  driver.get("https://www.flipkart.com/");
		  Thread.sleep(5000);
		  String value= Utility.getDataFromExcel(0, 0);
		  loginpage.SendMobile(value);
		 // loginpage.SendMobile(Utility.getDataFromExcel(2,0));
		  value=Utility.getDataFromExcel(2, 0);
		  loginpage.SendPassw(value);
		  loginpage.clickLogin();	 
	  }
	  @Test
	  public void VerifyMensBlazers() throws Exception
	  {
		  Thread.sleep(5000);
		  flipkartfashion.openFashion();
		  Thread.sleep(5000);
		  String url = driver.getCurrentUrl();
		  String title = driver.getTitle();
		  System.out.println("URL-->"+url);
		  System.out.println("Page Title-->"+title);
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
