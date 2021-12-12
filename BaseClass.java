package baseClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
	public ChromeDriver driver;
	public String excelSheetPath;
	public ArrayList<Integer> dateInExcel;
	//public SoftAssert sassert = new SoftAssert();
	
	@BeforeMethod
	public void launchBrowserAndUrl() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData() throws IOException, ParseException {
		return ReadExcel.readExcel(excelSheetPath, dateInExcel);
	}
}
