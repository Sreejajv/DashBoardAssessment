package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.BaseClass;

public class HomePageLE extends BaseClass {

	public HomePageLE(ChromeDriver driver){
		this.driver = driver;
	}
	
	public HomePageLE clickWaffle() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	
	public HomePageLE clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	
	public HomePageLE clickSales() {
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		return this;
	}
	
	public HomePageLE clickArrowNearOpportunity() {	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
			e.printStackTrace();
	}
	driver.findElement(By.xpath("//span[text()='Opportunities']/following::a[1]//*[name()='svg'][@class='slds-icon slds-icon-text-default slds-icon_xx-small']")).click();
	return this;
	}
	
	public OpportunityPage clickNewOpportunity() {
		WebElement newOppr = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newOppr);
		return new OpportunityPage(driver);
	}
	
	public AccountsPage clickAccountsTab() {
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Accounts']")));
		return new AccountsPage(driver);
	}
	
	public DashBoardPage clickServiceConsole() {
		driver.findElement(By.xpath("//p[text()='Service Console']/parent::span")).click();
		return new DashBoardPage(driver);
	}
	
	public DashBoardPage enterSearchAppsOrItemsAndSelectDashBoard(String searchApp) {
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Search apps or items')]")).sendKeys(searchApp);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//mark[text()='Dashboard']/ancestor::span[1]")).click();
		return new DashBoardPage(driver);
	}
	

}
