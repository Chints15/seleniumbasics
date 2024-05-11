package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String var ="chintu";
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(var);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		//selenium does not support the alert directly hence asks us to change context from driver to alert
		driver.switchTo().alert().accept(); //clicks on OK from alert
		
		//click on confirm button & cancel the alert: confirmbtn
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
	}

}
