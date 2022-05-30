package TestClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart01 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\New folder\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");

	}

}
