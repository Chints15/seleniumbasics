package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		// below we use findElements instead of findElement as we are trying to get list of options
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		//here we use enhanced for loop as we need to provide each dropdown to variable to check
		
		for(WebElement option :options) // the located dropdown value is passed from options to option
		{
			if(option.getText().equalsIgnoreCase("India")) //compare the text from dropdown option with India by ignoring the Case 
			{
				option.click(); //click on option having India
				break;
			}
		}
		
	}

}
