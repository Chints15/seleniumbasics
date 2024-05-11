package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//select checkbox1
		driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).click();
		//checks if checkboix is true, returns true if checkbox is checked
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).isSelected());
		
		//uncheck checkbox again by clicking on it
		driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).isSelected());
		//now we need to print the count of checkboxes.
		
		//now we need to find the count of checkboxes present on page
		//common attribute in all 3 checboxes //input[@type="checkbox"]
		System.out.println( driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());
		
		
	}

}
