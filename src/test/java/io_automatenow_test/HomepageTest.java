package io_automatenow_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.HomePage;

public class HomepageTest extends BaseTest {
    
    //create an object of the HomePage class at this level to get access in this whole class
    HomePage homePage = new HomePage();

    @Test(description = "a method that gets the page title")
    public void testPageTitle(){
        homePage.navigateToAutomateNow();
        String pageTitle = homePage.getHomePageTitle();
        Assert.assertTrue((pageTitle.contains("Home")), "INCORRECT title");
        System.out.println(pageTitle);
    }

    @Test(description = "a method that test whether the Greeting from HomePage contains the word 'Welcome'") 
    public void testGreeting(){
        homePage.navigateToAutomateNow();
        String message = homePage.getWelcomeMessage();
        Assert.assertTrue(message.contains("Welcome"), "Welcome message did not match");
        System.out.println(message);
    }
}
