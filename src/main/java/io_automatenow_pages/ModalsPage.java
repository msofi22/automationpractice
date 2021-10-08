package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class ModalsPage extends BasePage {
    private String modalsURL="https://automatenow.io/modals/";
    private By simpleModalButton= By.id("simpleModal");
    private By formModalButton= By.id("formModal");
    private By closeSimpleModalButton= By.cssSelector("#popmake-1318 button");
    private By nameField= By.id("g1051-name");
    private By emailField= By.id("g1051-email");
    private By submitButton= By.xpath("//button[@type='submit']");

    public ModalsPage(){
        super(driver);
    }
    
    public void navigateToModalPage(){
        navigateTo(modalsURL);
    }

    public void clickSimpleModal(){
        clickElement(simpleModalButton);
    }

    public void closeSimpleModal(){
        clickElement(closeSimpleModalButton);
    }

    public void clickFormModal(){
        clickElement(formModalButton);
    }

    public void enterFormInfo(String keysToSend, String emailToInput){
        driver.findElement(nameField).sendKeys(keysToSend);
        driver.findElement(emailField).sendKeys(emailToInput);
        
    }

    public void submitForm(){
        clickElement(submitButton);
    }
    
}
