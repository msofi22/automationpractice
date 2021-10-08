package io_automatenow_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class HomePage extends BasePage {
    private By welcomeMessage= By.cssSelector("#post-36 > div > h4:nth-child(5) > span");
    private String homepageURL= "https://automatenow.io";
    Actions actions =new Actions(driver);
    
    public HomePage(){
        super(driver);
    }
    public void navigateToAutomateNow(){
        navigateTo(homepageURL);
    }
    public String getHomePageTitle(){
        return getPageTitle();
    }

    public String getWelcomeMessage(){ 
        return getTextFromElement(welcomeMessage);
    }


    
}
