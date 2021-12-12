package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;

public class DashBoardPage extends BaseClass {
	WebDriverWait wait;
	public SoftAssert sassert = new SoftAssert();

	public DashBoardPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public DashBoardPage clickNavigationMenuArrow() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Show Navigation Menu']/ancestor::button")).click();
		return this;
	}

	public DashBoardPage selectHomeFromDropDown() {
		//driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[name()='svg'][@data-key='home']/ancestor::a")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
					e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[name()='svg'][@data-key='home']/ancestor::a")).click();
		System.out.println("done home");
		try {
				Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public DashBoardPage selectDashBoardFromDropDown() {
		driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[name()='svg'][@data-key='dashboard']/ancestor::a")));
		driver.findElement(By.xpath("//*[name()='svg'][@data-key='dashboard']/ancestor::a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
		}
	
	public DashBoardPage clickNewDashboard() {
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text()='New Dashboard']/parent::a")));
			return this;
	}
	
	public DashBoardPage enterDashBoardName(String dashboardName) {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("dashboardNameInput"))));
		driver.findElement(By.id("dashboardNameInput")).sendKeys(dashboardName);
		return this;
	}
	
	public DashBoardPage enterDBDescription (String dBDescription) {
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys(dBDescription);
		return this;
	}
	
	public DashBoardPage clickCreate() {
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		return this;
	}
	
	public DashBoardPage clickDone() {
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		/*
		 * do { System.out.println("its here");
		 * }while(!driver.getTitle().contains("Sreeja"));
		 */
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));		
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Done']")));
		
		return this;
	}
	
	public DashBoardPage verifyDashBoardCreated(String dashBoardName) {
		WebElement msg = driver.findElement(By.xpath("//span[text()='Dashboard']/following-sibling::span[text()='"+dashBoardName+"']"));
		System.out.println(msg+"dashboard created"+msg.isDisplayed());
		sassert.assertTrue(msg.isDisplayed(),"DashBoard created");
		return this;
	}
	
	public DashBoardPage clickSubscribe() {
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public DashBoardPage selectFrequencyAsDaily() {
		driver.findElement(By.xpath("//span[text()='Daily']/parent::label")).click();
		return this;
	}
	
	public DashBoardPage selectTimeas10AM() {
		driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='Time']/following::select")));
		Select dropDown = new Select(driver.findElement(By.xpath("//span[text()='Time']/following::select")));
		dropDown.selectByVisibleText("10:00 AM");
		return this;
	}
	
	public DashBoardPage clickSave() {
		driver.findElement(By.xpath("//span[text()='Save']/parent::button")).click();
		return this;
	}
	
	public DashBoardPage verifySubscribeSucessmsg() {
		WebElement msg = driver.findElement(By.xpath("//span[contains(text(),'You started a dashboard subscription')]"));
		System.out.println(msg+"sucess subscribe"+ msg.isDisplayed());
		sassert.assertTrue(msg.isDisplayed(),"sucess subscribe");
		return this;
	}
	
	public DashBoardPage closeCurrentWorkoutTab() {
		driver.findElement(By.xpath("//span[text()='Close SreejaJV_Workout']/ancestor::button")).click();
		return this;
	}
	
	public DashBoardPage clickOnPrivateDashboardLink() {
		driver.findElement(By.xpath("//a[@title=\"Private Dashboards\"][1]")).click();
		return this;
	}
	
	public DashBoardPage searchDashBoard(String dashBoardName) {
		driver.findElement(By.xpath("//input[contains(@class,'search-text-field')]")).clear();
		driver.findElement(By.xpath("//input[contains(@class,'search-text-field')]")).sendKeys(dashBoardName+Keys.ENTER);
		return this;
	}
	
	public DashBoardPage deleteDashBoard() {
		driver.findElement(By.xpath("(//span[contains(text(),'Sreeja')]/ancestor::tr/td[6]//span[text()='Show actions']/ancestor::button)[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Delete']/parent::a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Delete']/parent::button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public DashBoardPage assertAll() {
		sassert.assertAll();
		return this;
	}
	
	public DashBoardPage noResults() {
		WebElement msg = driver.findElement(By.xpath("//span[text()='No results found']"));
		System.out.println(msg+"noresult"+msg.isDisplayed());
		sassert.assertTrue(msg.isDisplayed(), "no result message");
		return this;
	}
}
