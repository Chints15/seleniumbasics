package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//click on FROM dropdown to select departure city
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		// opens dropdown and selects the BLR city //input[@value='BLR']
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		// alternate way to provide locator without hardcoding index value is using Parent Child Relationship
		
		
		
		//Assert.assertEquals(driver.findElements(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
			//	driver.findElement(By.xpath("//select[@value='BLR']")).getText()
//		
//		System.out.println(driver.findElement(By.xpath("//select[@value='BLR']")).getText());
//		System.out.println(driver.findElement(By.xpath("//select[@value='MAA']")).getText());
//		
	//	Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText(),"Bengaluru (BLR)");
	//	Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText(),"Chennai (MAA)");
		}

}
