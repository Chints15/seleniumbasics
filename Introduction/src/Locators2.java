import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			String name="rahul";
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password= getPasswd(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
				
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+","); //checks for Hello rahul, text
		driver.findElement(By.xpath("//button[text()='Log Out']"));
	//	System.out.println(password);
		driver.close();
	//	System.out.println("done");
	}

	
	//code to enter password using the reset link
	//providing below method as static as it is called without creating any object
	
	public static String getPasswd(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click(); //using linkTest locator
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); 
		String passwordText= driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray= passwordText.split("'");
		//0th element : Please use temporary password 
		//1st element: rahulshettyacademy' to Login.
		String password=passwordArray[1].split("'")[0];
		
//		String password= passwordArray2[0];
	//	System.out.println(password);
		return password;
	}
}
