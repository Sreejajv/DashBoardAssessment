package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import baseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(ChromeDriver driver){
		this.driver = driver;
	}
	
	public LoginPage enterUserName(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public HomePageLE clickLogin() {
		driver.findElement(By.id("Login")).click();
		return new HomePageLE(driver);
	}
}
