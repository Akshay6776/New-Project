package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponent.AbstarctComponent;

public class CheckoutPage extends AbstarctComponent{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryField;
	
	@FindBy(xpath="//button[@type='button']")
	List<WebElement> countries;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement placeOrderButton;
	
	
	public String enterCountryName(String countryName) 
	{
		countryField.sendKeys(countryName);
		return countryName;
	}
	
	public void selectCountry(String countryName) 
	{
		for(WebElement country: countries) 
		{
			if(country.getText().equalsIgnoreCase(countryName)) 
			{
				country.click();
				break;
			}
		}
	}
	
	public ConfirmationPage clickPlaceOrderButton() 
	{
		placeOrderButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
}
