package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTest{
	
	@Test
	public void submitOrder() 
	{
		String itemName = "IPHONE 13 PRO";
		String country = "india";
        
		ProductCatalogPage productCatalogPage = landingPage.loginToApplication("akshayj6776@gmail.com", "Akshayj@6776");	
		productCatalogPage.waitTillProductsToAppear();	
		productCatalogPage.addItemToCart(itemName);
		productCatalogPage.waitTillTheProductIsAdded();	
		CartPage cartPage = productCatalogPage.clickOnCart();
	
		cartPage.verifyProductInCart(itemName);
		CheckoutPage checkoutPage = cartPage.clickCheckOutButton();

		checkoutPage.enterCountryName(country);
		checkoutPage.selectCountry(country);

		ConfirmationPage confirmationPage = checkoutPage.clickPlaceOrderButton();

		String confirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "THANKYOU FOR THE ORDER.");
		
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void confirmOrderPlaced() 
	{
		String itemName = "IPHONE 13 PRO";
		String country = "india";
        
		ProductCatalogPage productCatalogPage = landingPage.loginToApplication("akshayj6776@gmail.com", "Akshayj@6776");	
		OrderPage orderPage = productCatalogPage.goToOrderPage();
		
		Boolean match = orderPage.verifyOrderDisplayed(itemName);
		
		Assert.assertTrue(match);
	}
	

}