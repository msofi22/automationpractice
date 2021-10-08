package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class IFramePage extends BasePage {
    private String iFrameURL= "https://automatenow.io/iframes/";
    private String frameName1 = "frame1";
    private By searchFieldFrame1 = By.id("searchInput");
    private By searchButtonFrame1 = By.xpath("//i[@class='sprite svg-search-icon']");
    private By titleOfSearch = By.cssSelector("h1#firstHeading");
    

    private String frameName2= "frame2";
    private By whatsNewButton= By.xpath("//a[@href='/google-features-on-android/summer-2021/']");
    private By titleOfNewSection = By.xpath("//h1[@class='is-8']");

    public IFramePage(){
        super(driver);
    }

    public void navigateToIFrame(){
        navigateTo(iFrameURL);
    }

    public void enterFrame1(){
        switchToIFrame(frameName1);
    }

    public void searchInFrame1(String searchInput){
        driver.findElement(searchFieldFrame1).sendKeys(searchInput);
        clickElement(searchButtonFrame1);
    }

    public String getSearchResultText(){
        return driver.findElement(titleOfSearch).getText();
    }

    public void enterFrame2(){
        switchToIFrame(frameName2);
    }

    public void clickButtonOnIFrame2(){
        scrollToElement(whatsNewButton);
        clickElement(whatsNewButton);

    }

    public String buttonText(){
        scrollToElement(whatsNewButton);
        return driver.findElement(whatsNewButton).getText();
    }

    public String getNewPageSectionTitleFrame2(){
        clickElement(titleOfNewSection);
        return driver.findElement(titleOfNewSection).getText();
    }


}
