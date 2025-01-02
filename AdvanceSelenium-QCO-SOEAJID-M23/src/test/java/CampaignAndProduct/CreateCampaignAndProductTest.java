//package CampaignAndProduct;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Iterator;
//import java.util.Properties;
//import java.util.Random;
//import java.util.Set;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;
//
//import com.google.protobuf.Duration;
//
//import Generic_Utility.BaseClass;
//import Generic_Utility.Excel_Utility;
//import Generic_Utility.File_Utility;
//import Generic_Utility.Java_Utility;
//import Generic_Utility.WebDriver_Utility;
//import POM_Repo.CampLookUp;
//import POM_Repo.CampValidatePage;
//import POM_Repo.CreateCampPage;
//import POM_Repo.CreateProductPage;
//import POM_Repo.HomePage;
//import POM_Repo.LoginPage;
//import POM_Repo.PrdLookUpImg;
//import POM_Repo.ProductValidatePage;
//import POM_Repo.WindowSwtiching;
//
//public class CreateCampaignAndProductTest extends BaseClass {
//	public static void main(String[] args) throws Throwable {
//		@Test(groups = "smoke")
//		public void createCampaignWithProductTest() throws Throwable {
//
//			WebDriver_Utility wlib = new WebDriver_Utility();
//			File_Utility flib = new File_Utility();
//			Excel_Utility elib = new Excel_Utility();
//			Java_Utility jlib = new Java_Utility();
//
//			String URL = flib.getKeyAndValuePair("url");
//			String USERNAME = flib.getKeyAndValuePair("username");
//			String PASSWORD = flib.getKeyAndValuePair("password");
//
////			if (BROWSER.equalsIgnoreCase("chrome")) {
////				driver = new ChromeDriver();
////			} else if (BROWSER.equalsIgnoreCase("firefox")) {
////				driver = new FirefoxDriver();
////			} else if (BROWSER.equalsIgnoreCase("edge")) {
////				driver = new EdgeDriver();
////			} else {
////				driver = new ChromeDriver();
////			}
////			wlib.maximizeWindow(driver);
////			wlib.waitForPageToLoad(driver);
////			driver.get(URL);
//
//			// using business logics
////			LoginVtigerPage login = new LoginVtigerPage(driver);
////			login.loginIntoVtiger(USERNAME, PASSWORD);
//
//			HomePage home = new HomePage(driver);
//			home.clickPrdLink();
//
//			ProductDetailedPage prdPlus = new ProductDetailedPage(driver);
//			prdPlus.clickPrdLookUpImg();
//
//			// RanDom Class----->generating unique values(Avoid Duplicate value)
//
//			int ranNum = jlib.getRandomNum();
//			// ----------------------------------------------------------------------------------------------------------
//
//			String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
//			System.out.println(PrdName);
//
//			CreateProductPage prdPage = new CreateProductPage(driver);
//			prdPage.enterPrdName(PrdName);
//			prdPage.getSaveButton();
//
//	//------------------------------------------------------------------------------------------------------
//			home.clickPrdLink();
//			home.getCampLink();
//
//			CampDetailedPage plusCamp = new CampDetailedPage(driver);
//			plusCamp.clickCampLookUpImg();
//
//			// ----------------------------------------------------------------------------------------------------------
//
//			String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;
//
//			System.out.println(CampName);
//
//			CreateCampPage campPage = new CreateCampPage(driver);
//			campPage.enterCampName(CampName);
//
//			SwitchingWindowCampWithProd winSwitch = new SwitchingWindowCampWithProd(driver);
//			winSwitch.clickPlusSign();
//
//			wlib.windowSwtiching(driver, "Products&action");
//
//			winSwitch.enterPrdNameInCamp(PrdName);
//			winSwitch.clickSearchBar();
//
//			Thread.sleep(2000);
//
//			// Dynamic xpath
//
//			winSwitch.clickProductName(driver, PrdName);
//
//			wlib.WindowSwtiching(driver, "Campaigns&action");
//
//			campPage.clickSaveButton();
//
//			CampValidatePage validate = new CampValidatePage(driver);
//			validate.validateCamp(driver, CampName);
//			validate.ProductValidatePage(driver, PrdName);
//
//			// -------------------------------------------------------------------------------------
//
//			// home.logoutApp();
//
//		}
//
//}



