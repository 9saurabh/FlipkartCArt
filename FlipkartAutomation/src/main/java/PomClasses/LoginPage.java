package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="(//input[@type='text'])[2]")private WebElement Mobile;
	@FindBy(xpath="//input[@type='password']")private WebElement Passw;
	@FindBy(xpath="(//button[@type='submit'])[2]")private WebElement Login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void SendMobile(String MobileNo)
	{
		Mobile.sendKeys(MobileNo);
	}
	public void SendPassw(String pwd)
	{
		Passw.sendKeys(pwd);
	}
    public void clickLogin()
    {
    	Login.click();
    }
}
