package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilpkartFashion {
	@FindBy(xpath="//div[text()='Fashion']")private WebElement Fashion;
	@FindBy(xpath="(//a[@class='_6WOcW9 _3YpNQe'])[7]")private WebElement MensBlazer;
	WebDriver driver;
	public FilpkartFashion(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void openFashion()
	{
		Actions F = new Actions(driver);
		F.moveToElement(Fashion).perform();
		F.moveToElement(MensBlazer).click().build().perform();
		
	}

}
