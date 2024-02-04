package rahulshettyacademy.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstarctComponent;

public class ConfirmationPage extends AbstarctComponent{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="h1.hero-primary")
	WebElement fullConfirmationMessage;

	
	public String getConfirmationMessage() 
	{
		String finalConfirmationMessage = fullConfirmationMessage.getText();
		return finalConfirmationMessage;
	}
}
