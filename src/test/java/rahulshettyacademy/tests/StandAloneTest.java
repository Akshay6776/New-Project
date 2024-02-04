package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		
		String itemName = "IPHONE 13 PRO";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.id("userEmail")).sendKeys("akshayj6776@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Akshayj@6776");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']//b")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']//b"));
		
		for(int i=0;i<products.size();i++) 
		{
			String productName = products.get(i).getText();
			if(productName.contains(itemName)) 
			{
				driver.findElements(By.xpath("//button[2]")).get(i).click();
				break;
			}
		}
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();

		
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		for(int i=0;i<cartProducts.size();i++) 
		{
			String cartProductName = cartProducts.get(i).getText();
			if(cartProductName.contains(itemName)) 
			{
				Assert.assertEquals(itemName, cartProductName);
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		List<WebElement> countries = driver.findElements(By.xpath("//button[@type='button']"));
		
		for(WebElement country: countries) 
		{
			if(country.getText().equalsIgnoreCase("India")) 
			{
				country.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		
		String confirmationMessage = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		
		Assert.assertEquals(confirmationMessage, "THANKYOU FOR THE ORDER.");
		
		driver.quit();
	}

}
