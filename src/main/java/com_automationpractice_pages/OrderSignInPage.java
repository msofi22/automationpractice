package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class OrderSignInPage extends BasePage {
    private String email= "testwithme1.0@gmail.com";
    private String pass= "TestWithMe";
    private By emailField= By.xpath("//input[@id='email']");
    private By passwordField= By.xpath("//input[@id='passwd']");
    private By signInButton=By.id("SubmitLogin");

    public OrderSignInPage(){
        super(driver);
    }

    //enter valid user credentials
    public void enterCredentials(){
        scrollToElement(emailField);
        sendInput(emailField, email);
        scrollToElement(passwordField);
        sendInput(passwordField, pass);
        clickElement(signInButton);
    }
}
