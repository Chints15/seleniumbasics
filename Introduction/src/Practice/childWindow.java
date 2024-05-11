package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		//adding implicit wait mechanism
		
		WebDriver driver = new ChromeDriver();
		//adding implioit wait mechanism
	//	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		//after clicking opens seperate tab
		// our goal is to switch from parent to child browser , pick the username text , switch back to parent window and paste the username text
		
		Set<String> windows= driver.getWindowHandles(); //parentid,childID
		Iterator<String> it=windows.iterator();
		String parentID= it.next();
		String chuildID= it.next();
		driver.switchTo().window(chuildID);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailID);
		driver.switchTo().window(parentID);
	//	Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		
		
		
	}

}
