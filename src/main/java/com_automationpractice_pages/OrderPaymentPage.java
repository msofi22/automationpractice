package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class OrderPaymentPage extends BasePage {
    
    private By elementsFromCart= By.xpath("//tbody//tr//td//p[@class='product-name']");
    private By bankWireButton= By.className("bankwire");
    private By headerBank= By.className("page-subheading");
    private By iConfirmMyOrderButton= By.xpath("//button[@class='button btn btn-default button-medium']");

    public OrderPaymentPage(){
        super(driver);
    }
    
    //check if there is the same amount of items in the cart
    public int itemsInCart(){
        return driver.findElements(elementsFromCart).size();
    }

    public void clickBankWire(){
        clickElement(bankWireButton);
    }

    public String getBankHeaderText(){
        return driver.findElement(headerBank).getText();
    }

    public void clickConfirm(){
        clickElement(iConfirmMyOrderButton);
    }
}
