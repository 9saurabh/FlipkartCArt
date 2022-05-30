package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")private WebElement SearchBox;
	@FindBy(xpath="//button[@class='L0Z3Pu']")private WebElement SearchButton;
	@FindBy(xpath="(//div[@class='_4rR01T'])[1]")private WebElement iphone;
	@FindBy(xpath="(//li[@class='col col-6-12'])[1]")private WebElement AddtoCart;
    @FindBy(xpath="(//div[@class='_28p97w'])[1]")private WebElement Profile;
    @FindBy(xpath="(//div[@class='_3vhnxf'])[10]")private WebElement Logout;
    WebDriver driver;
    
    
    public MainPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    public void SearchBoxClick()
    {
    	SearchBox.sendKeys("iphone 13 pro max");
    }
    public void SearchButtonClick()
    {
    	SearchButton.click();
    }
    public void iphoneSelect()
    {
    	iphone.click();
    }
    public void ClickAddtoCart()
    {
    	AddtoCart.click();
    }
    public void LogoutProfile() throws Exception
    {
    	Actions S = new Actions(driver);
    	S.moveToElement(Profile).perform();
    	S.moveToElement(Logout).click().build().perform();
    	Thread.sleep(1500);
    }
    
}
