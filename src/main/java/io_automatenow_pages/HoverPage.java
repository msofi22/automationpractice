package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HoverPage extends BasePage {
    private String hoverURL= "https://automatenow.io/hover/";
    private By hoverElement=By.id("mouse_over");
    
    public HoverPage(){
        super(driver);
    }

    public void navigateToHover(){
        navigateTo(hoverURL);
    }

    public String textPreHover(){
        return driver.findElement(hoverElement).getText();
    }

    public String textHovered(){
        scrollToElement(hoverElement);
        return driver.findElement(hoverElement).getText();
    }


}
