package Organisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.BaseClass;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreateOrganizationTest extends BaseClass {
public static void main(String[] args) throws Throwable {
	//launching Browser
	//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertiesfile.properties");
	//Properties pro = new Properties();
	//pro.load(fis);
	//String BROWSER = pro.getProperty("browser");
	//String URL = pro.getProperty("url");
    //String USERNAME = pro.getProperty("username");
    // PASSWORD = pro.getProperty("password");
	
	File_Utility flib = new File_Utility();
	String BROWSER = flib.getKeyAndValuePair("browser");
	String URL = flib.getKeyAndValuePair("url");
	String USERNAME = flib.getKeyAndValuePair("username");
	String PASSWORD = flib.getKeyAndValuePair("password");
	
	
	WebDriver driver;

	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	} else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else {
		driver = new ChromeDriver();
	}
	
    driver.get(URL);
    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
	// ------------------------------------------------------------------------------------------------
	// To Avoid the Duplicates

	//Random ran = new Random();
	//int ranNum = ran.nextInt(1000);
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNum();
	// ----------------------------------------------------------------------------------------------------
	// step1:- path connection
	FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");

	// step2:- keep workbook in read mode
	Workbook book = WorkbookFactory.create(fis1);

	// step3:- Navigates into particular sheet
	Sheet sheet = book.getSheet("Organization");

	// step4:- Navigates into particular Row
	Row row = sheet.getRow(0);

	// step5:-Navigates into particular cell

	Cell cell = row.getCell(0);

	String OrgName = cell.getStringCellValue() + ranNum;
	System.out.println(OrgName);

	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	// --------------------------------------------------------------------------------------------
	Row row1 = sheet.getRow(1);

	// step5:-Navigates into particular cell

	Cell cell1 = row1.getCell(0);

	DataFormatter format = new DataFormatter();
	String phnNum = format.formatCellValue(cell1);
	System.out.println(phnNum);
	driver.findElement(By.id("phone")).sendKeys(phnNum);
	// -----------------------------------------------------------------------------------------
	Row row2 = sheet.getRow(2);

	// step5:-Navigates into particular cell

	Cell cell2 = row2.getCell(0);

	String mailID = cell2.getStringCellValue();
	System.out.println(mailID);

	driver.findElement(By.id("email1")).sendKeys(mailID);
	// --------------------------------------------------------------------------------------------
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	Thread.sleep(2000);
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

	if (actData.contains(OrgName)) {
		System.out.println("Orgnization is created");
	}

	else {
		System.out.println("Orgnization not created");
	}

//	driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
//	driver.findElement(By.linkText("Sign Out")).click();

	//home.logOutApp();

}
}