package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponent.AbstarctComponent;

public class CartPage extends AbstarctComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkoutButton;
	
	

	public void verifyProductInCart(String itemName) 
	{
		for(int i=0;i<cartProducts.size();i++) 
		{
			String cartProductName = cartProducts.get(i).getText();
			if(cartProductName.contains(itemName)) 
			{
				Assert.assertEquals(itemName, cartProductName);
				break;
			}
		}
	}
	
	public CheckoutPage clickCheckOutButton() 
	{
		checkoutButton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

	
}
