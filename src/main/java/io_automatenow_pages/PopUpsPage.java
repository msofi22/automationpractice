package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class PopUpsPage extends BasePage{
    private String popUpsURL= "https://automatenow.io/popups/";
    private By alertButton=  By.id("alert");
    private By confirmAlert= By.id("confirm");
    private By promptPopUp= By.id("prompt");
    private By confirmResult = By.id("confirmResult");
    private By promptResponse= By.id("promptResult");

    public PopUpsPage(){
        super(driver);
    }

    public void navigateToPopUps(){
        navigateTo(popUpsURL);
    }

    public void clickJSAlert(){
        clickElement(alertButton);
        closeAlert();
    }

    public void clickConfirmPopUp(){
        clickElement(confirmAlert);
        confirmAlert();
    }

    public void clickAndInputInPrompt(String inputText){
        clickElement(promptPopUp);
        alertInput(inputText);
        confirmAlert();
    }

    public String confirmResult(){
        return driver.findElement(confirmResult).getText();
    }

    public String promptResponse(){
        return driver.findElement(promptResponse).getText();
    }


}
