package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class OrderSummaryPage extends BasePage {
    private By productsInCart= By.xpath("//tbody//tr//td[@class='cart_product']//img[@width='98']");
    private By proceedToCheckoutButton= By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
    //private By cartCell=;


    public OrderSummaryPage(){
        super(driver);
    }
//get size of productInCart 
    public int getNumberOfItems(){
        return driver.findElements(productsInCart).size();
    }

//click proceed to checkout button
    public void clickProceedToCheckout(){
        scrollToElement(proceedToCheckoutButton);
        clickElement(proceedToCheckoutButton);
    }
    
}
