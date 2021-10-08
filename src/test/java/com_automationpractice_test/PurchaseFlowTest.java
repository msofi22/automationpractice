package com_automationpractice_test;

import com_automationpractice_pages.HomePage;
import com_automationpractice_pages.OrderAddressPage;
import com_automationpractice_pages.OrderConfirmationPage;
import com_automationpractice_pages.OrderPaymentPage;
import com_automationpractice_pages.OrderShippingPage;
import com_automationpractice_pages.OrderSignInPage;
import com_automationpractice_pages.OrderSummaryPage;
import com_automationpractice_pages.SearchPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;
import basetest.BaseTest;

/*This is an End-2-end Test of a Purchase flow of 3 items, in this case containing the word "dresses".
The path is as follows: HomePage, SearchPage, Order(Summary, Address, SignIn, Shipping, Payment), OrderConfirmation.
Precondition: User must be registered and have a saved address */

public class PurchaseFlowTest extends BaseTest {
    HomePage homePage= new HomePage();
    SearchPage searchPage= new SearchPage();
    OrderSummaryPage orderSumPage= new OrderSummaryPage();
    OrderAddressPage orderAddressPage= new OrderAddressPage();
    OrderSignInPage orderSignInPage= new OrderSignInPage();
    OrderShippingPage orderShipPage= new OrderShippingPage();
    OrderPaymentPage orderPaymentPage= new OrderPaymentPage();
    OrderConfirmationPage orderConfirmPage= new OrderConfirmationPage();
    

    @Test(groups = "a", description = "User accesses the HomePage and searchs for 'dresses'")
    public void testSearchForCriteria(){
        homePage.goToAutomationPracticeHomePage();
        homePage.enterCriteria();
    }

    //User validates the search results match the criteria and adds first 3 items to cart, check if there are 3 items in cart")
    @Test(groups= "b", dependsOnGroups = "a")
    public void testSearchResultsAndAdd3ToCart(){
        logger= extent.createTest("Test search results match search criteria");
        String titleOfSearch=searchPage.getSearchTitle();
        String searchCriteria= "DRESSES";
        boolean resultsMatchCriteria = titleOfSearch.contains(searchCriteria);
        Assert.assertTrue(resultsMatchCriteria);
            if(resultsMatchCriteria==true)
                {logger.log(Status.PASS, "The search results match the search criteria");}
            else{
                logger.log(Status.FAIL,"WARNING! The search title DOES NOT match the entered criteria");}
        searchPage.addElementsToCart();
        searchPage.clickCart();
    }
    @Test(groups = "c", dependsOnGroups = {"a","b"})
    public void testItemsInCart(){
        logger=extent.createTest("Test number of items in cart");
        int numberOfItems=orderSumPage.getNumberOfItems();
        Assert.assertEquals(numberOfItems, 3);
            if(numberOfItems!=3)
                {logger.log(Status.FAIL,"FAIL: The number of items in the cart is incorrect");}
            else
                {logger.log(Status.PASS, "The number of items in cart is correct");}
        orderSumPage.clickProceedToCheckout();
    }
    
        //Enter signIn credentials, access to Address tab and validate the checkbox is selected
    @Test(groups = "d", dependsOnGroups = {"a","b","c"})
    public void testAddressCheckboxIsSelected(){
        orderSignInPage.enterCredentials();
        logger= extent.createTest("Test address checkbox is selected");
        boolean checkboxStatus=orderAddressPage.istheAddressCheckboxSelected();
        Assert.assertTrue(checkboxStatus);
            if(checkboxStatus==true)
                {logger.log(Status.PASS, "The Address checkbox was selected");}
            else
                {logger.log(Status.FAIL, "The address checkbox is NOT selected");}
        orderAddressPage.proceedToCheckout();
    }
        //Tick the Terms of Service checkbox
    @Test(groups = "e",dependsOnGroups = {"a","b","c","d"})
    public void testTermsOfServiceCheckbox(){
        logger= extent.createTest("Test the 'Terms of Service' checkbox is selected");
        orderShipPage.checkTerms();
        boolean termsCheckboxStatus= orderShipPage.isTermsCheckboxSelected();
        Assert.assertTrue(termsCheckboxStatus);
            if(termsCheckboxStatus==true)
                {logger.log(Status.PASS, "The Terms of Service checkbox is selected");}
            else
                {logger.log(Status.FAIL, "WARNING: The TermsOfService checkbox is NOT selected");}
        orderShipPage.proceedToCheckout();
    }
        //Assert the correct number of items in the cart, select bankwire payment option
    @Test(groups="f",dependsOnGroups = {"a","b","c","d","e"})
    public void testNumberOfItemsPreConfirmation(){
        logger= extent.createTest("Test number of items in cart");
        int itemsInCart=orderPaymentPage.itemsInCart();
        Assert.assertEquals(itemsInCart, 3);
            if(itemsInCart!=3)
                {logger.log(Status.FAIL,"FAIL: Item quantity is incorrect!");}
            else
                {logger.log(Status.PASS, "Item quantity is correct");}
        orderPaymentPage.clickBankWire();
    }
        //Validate bankwire payment was selected
    @Test(groups="g",dependsOnGroups = {"a","b","c","d","e","f"})
    public void testPaymentMethod(){
        logger= extent.createTest("Test the correct payment method was selected");
        String headerText=orderPaymentPage.getBankHeaderText();
        String bankWire= "BANK-WIRE";
        boolean headerContent= headerText.contains(bankWire);
        Assert.assertTrue(headerContent);
            if(headerContent==true)
                {logger.log(Status.PASS, "Correct payment method selected!");}
            else
                {logger.log(Status.FAIL, "FAIL: The header text does not contain the payment method");}
    }
        //Validate the user is in the Order confirmation page
    @Test(groups = "h",dependsOnGroups ={"a","b","c","d","e","f","g"})
    public void testAccessToConfirmationPage() throws AssertionError{
        logger= extent.createTest("Test user is in Order Confirmation page");
        String confirmationTitle=orderConfirmPage.getConfirmationPageTitle();
        String expectedConfirmTitle= "My Store";
        boolean titleStatusContainsConfirmation = confirmationTitle.contains(expectedConfirmTitle);
        Assert.assertTrue(titleStatusContainsConfirmation);
            if(titleStatusContainsConfirmation==true)
                {logger.log(Status.PASS, "User is on the Order confirmation page");}
            else
                {logger.log(Status.FAIL, "FAIL: User is NOT on the Order confirmation page");}
    }
}
