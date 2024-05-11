package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		driver.findElement(By.id("divpaxinfo")).click(); // //locates the dropdown
		Thread.sleep(2000); //adding sleep inorder to locate elements
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText()); //prints the initial value displayed at dropdown
		for(int i=0;i<3;i++)
		{
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText()); //prints the initial value displayed at dropdown
		Assert.assertEquals(driver.findElement(By.cssSelector("div#divpaxinfo")).getText(), "4 Adult");
	}

}
