package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class OrderAddressPage extends BasePage{
    private By addressCheckBox = By.xpath("//input[@id='addressesAreEquals']");
    private By proceedToCheckoutButton=By.xpath("//button//i[@class='icon-chevron-right right']");

    public OrderAddressPage(){
        super(driver);
    }

    //check if use the delivery address as billing address is selected
    public boolean istheAddressCheckboxSelected(){
        scrollToElement(addressCheckBox);
        return driver.findElement(addressCheckBox).isSelected();
    }

    //click proceed to checkout
    public void proceedToCheckout(){
        scrollToElement(proceedToCheckoutButton);
        clickElement(proceedToCheckoutButton);
    }
}
