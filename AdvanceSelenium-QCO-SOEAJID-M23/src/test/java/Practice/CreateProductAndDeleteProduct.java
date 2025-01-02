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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreateProductAndDeleteProduct {
public static void main(String[] args) throws Throwable {
	//launching Browser
	//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertiesfile.properties");
	//Properties pro = new Properties();
	//pro.load(fis);
	//String BROWSER = pro.getProperty("browser");
	//String URL = pro.getProperty("url");
   // String USERNAME = pro.getProperty("username");
    //String PASSWORD = pro.getProperty("password");
	
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
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
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
		Sheet sheet = book.getSheet("Product");

		// step4:- Navigates into particular Row
		Row row = sheet.getRow(0);

		// step5:-Navigates into particular cell

		Cell cell = row.getCell(0);

		String ProdName = cell.getStringCellValue() + ranNum;
		System.out.println(ProdName);

		driver.findElement(By.name("productname")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
// --------------------------------------------------------------------------------------------
		
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(ProdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}
// -------------------------------------------------------------------------------------------------------------------------
		driver.findElement(By.linkText("Products")).click();
		// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='"+ProdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	
	driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
	
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
//-------------------------------------------------------------------------------------------------------------------------	
	
	WebElement prd=driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td[3])//a[text()='"+ProdName+"']"));
    if(prd.equals(ProdName))
	{
		System.out.println("Product Name is Present");
	}
	else
	{
		System.out.println("Product name is not Present");
	}
    
    driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
    driver.findElement(By.linkText("Sign Out")).click();
	

}
}
