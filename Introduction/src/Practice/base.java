package Practice;




import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Documents/RahulShettyCourse/chromedriver-win64/chromedriver.exe");
		//adding implicit wait mechanism
		
		WebDriver driver = new ChromeDriver();
		//adding implioit wait mechanism
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//String[] itemsNeeded= {'Cucumber','Brocolli'};
		String[] itemsNeeded= {"Brocolli","Cucumber","Beetroot"};
		
		addItems(driver,itemsNeeded);
		
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	
	//adding static keyword as function is called without creating object
	public static void addItems(WebDriver driver,String[] itemsNeeded) 
	{
		int j=0;
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			//Brocolli - 1 Kg -> split into 'Brocolli ' & '- 1 Kg'
			
			String[] name= products.get(i).getText().split("-");
			String formattedName= name[0].trim(); //using trim to remove all whitespaces
			//format name to get actual vegetable name using trim
			
			
			// check whether the name which is extracted is contained in the arrayList or not
		
			List itemsNeededList = Arrays.asList(itemsNeeded); //convert array to arraylist for easy search
			
			if(itemsNeededList.contains(formattedName)) //if product name is contained in the LIST
			{
				j++; //counter to break after all products are added
				//click add to cart
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				if(j==itemsNeeded.length) //use length for array & sizeof() for arrayLIST
					break;
			}
			
		}
		
	}

}
