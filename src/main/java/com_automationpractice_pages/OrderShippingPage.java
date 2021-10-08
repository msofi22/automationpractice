package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class OrderShippingPage extends BasePage {
    private By shippingCheckbox=By.xpath("//input[@id='cgv']");
    private By theTerms= By.xpath("//label[@for='cgv']");
    private By proceedToCheckout= By.xpath("//button[@name='processCarrier']");
    
    public OrderShippingPage(){
        super(driver);
    }

    //tick the Terms of Service checkbox
    public void checkTerms(){
        scrollToElement(theTerms);
        clickElement(theTerms);
    }

    public boolean isTermsCheckboxSelected(){
        scrollToElement(shippingCheckbox);
        return driver.findElement(shippingCheckbox).isSelected();
    }

    //proceed to checkout
    public void proceedToCheckout(){
        scrollToElement(proceedToCheckout);
        clickElement(proceedToCheckout);
    }


}
