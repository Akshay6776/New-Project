package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstarctComponent;

public class ProductCatalogPage extends AbstarctComponent{

	
	WebDriver driver;
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='card-body']//b")
	List<WebElement> productsList;
	
	@FindBy(xpath="//button[2]")
	List<WebElement> addToCartButton;
	
	By products = By.xpath("//div[@class='card-body']//b");
	
	public List<WebElement> waitTillProductsToAppear() 
	{
		waitTillElementToAppear(products);
		return productsList;
	}
	
	
	public void addItemToCart(String item) 
	{
		for(int i=0;i<productsList.size();i++) 
		{
			String productName = productsList.get(i).getText();
			if(productName.contains(item)) 
			{
				addToCartButton.get(i).click();
				break;
			}
		}
	}
	
	public void waitTillTheProductIsAdded() 
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
