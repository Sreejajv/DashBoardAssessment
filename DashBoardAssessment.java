package testCases;

import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;

public class DashBoardAssessment extends BaseClass{

	@BeforeTest
	public void setExcelSheet() {
	//location of the excel file for this test case
	excelSheetPath = "./data/DashBoardAssessment.xlsx";
	}
	
	@Test(dataProvider="fetchData")
	public void dashBoard(String uName, String password, String dashBoardName, String description) {
		new LoginPage(driver)
		.enterUserName(uName)
		.enterPassword(password)
		.clickLogin()
		.clickWaffle() 
		.clickViewAll() 
		//.enterSearchAppsOrItemsAndSelectDashBoard("Dashboard")
		.clickServiceConsole()
		.clickNavigationMenuArrow()
		.selectHomeFromDropDown()
		.clickNavigationMenuArrow()
		.selectDashBoardFromDropDown()
		.clickNewDashboard()
		.enterDashBoardName(dashBoardName)
		.enterDBDescription(description)
		.clickCreate()
		.clickDone()
		.verifyDashBoardCreated(dashBoardName)
		.clickSubscribe()
		.selectFrequencyAsDaily()
		.selectTimeas10AM()
		.clickSave()
		.verifySubscribeSucessmsg()
		.closeCurrentWorkoutTab()
		.clickOnPrivateDashboardLink()
		.searchDashBoard(dashBoardName)
		.deleteDashBoard()
		.clickOnPrivateDashboardLink()
		.searchDashBoard(dashBoardName)
		.noResults()
		.assertAll();

			
			

}
}
