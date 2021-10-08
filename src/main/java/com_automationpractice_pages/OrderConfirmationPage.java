package com_automationpractice_pages;

import base.BasePage;

public class OrderConfirmationPage extends BasePage {
    

    public OrderConfirmationPage(){
        super(driver);
    }

    //get page title
    public String getConfirmationPageTitle(){
        return driver.getTitle();
    }

    
}
