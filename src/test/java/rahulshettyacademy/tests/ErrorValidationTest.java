package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;

import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class ErrorValidationTest extends BaseTest{
	
	@Test(groups= {"ErrorHandling"})
	public void verifyLoginProvidingIncorrectPassword() 
	{
		landingPage.loginToApplication("akshayj6776@gmail.com", "Akshayj6776");	
		String actualerrorMessage = landingPage.getErrorMessage();
		
		Assert.assertEquals(actualerrorMessage, "Incorrect email or password.");	
	}
	
	@Test
	public void productErrorValidation() 
	{
		String itemName = "IPHONE 13 PRO";
		String country = "india";
        
		ProductCatalogPage productCatalogPage = landingPage.loginToApplication("akshayj6776@gmail.com", "Akshayj@6776");	
		productCatalogPage.waitTillProductsToAppear();	
		productCatalogPage.addItemToCart(itemName);
		productCatalogPage.waitTillTheProductIsAdded();	
		CartPage cartPage = productCatalogPage.clickOnCart();
	
		cartPage.verifyProductInCart(itemName);
	}
}