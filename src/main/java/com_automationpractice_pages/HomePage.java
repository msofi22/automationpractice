package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage {
    private String homePURL="http://automationpractice.com/index.php";
    private By searchField= By.id("search_query_top");
    private String searchCriteria= "dresses";
    private By searchButton= By.name("submit_search");

    public HomePage(){
        super(driver);
    }

    public void goToAutomationPracticeHomePage(){
        navigateTo(homePURL);
    }

    public void enterCriteria(){
        sendInput(searchField, searchCriteria);
        clickElement(searchButton);
    }
}
