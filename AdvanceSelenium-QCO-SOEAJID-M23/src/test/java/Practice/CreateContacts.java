package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContacts {
public static void main(String[] args) throws Throwable {
	//launching Browser
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertiesfile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		
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
		String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");
		
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		// To Avoid the Duplicates

		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		// ----------------------------------------------------------------------------------------------------
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet("Contact");

		// step4:- Navigates into particular Row
		Row row = sheet.getRow(0);

		// step5:-Navigates into particular cell

		Cell cell = row.getCell(0);

		String FirstName = cell.getStringCellValue() + ranNum;
		System.out.println(FirstName);

		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		// --------------------------------------------------------------------------------------------
	   Row row1 = sheet.getRow(1);
	   Cell cell1 = row1.getCell(0);
	   String lastName = cell1.getStringCellValue();
	   System.out.println(lastName);

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		// --------------------------------------------------------------------------------------------
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);

}
}
