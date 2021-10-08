package com_automationpractice_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class SearchPage extends BasePage {
    private By searchTitle=By.xpath("//h1[@class='page-heading  product-listing']");
    private By firstProduct= By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]");
    private By secondProduct= By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[2]");
    private By thirdProduct= By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]");
    private By addToCartButton1= By.xpath("//a[@title='Add to cart'][@data-id-product='5']");
    private By addToCartButton2=By.xpath("//a[@title='Add to cart'][@data-id-product='4']");
    private By addToCartButton3= By.xpath("//a[@title='Add to cart'][@data-id-product='6']");
    private By closePopUp= By.xpath("//div[@class='clearfix']//span[@class='cross']");
    private By cartButton= By.xpath("//b[contains(text(),'Cart')]");

    
    public SearchPage(){
        super(driver);
    }

    //get the text from the search title
    public String getSearchTitle(){
        scrollToElement(searchTitle);
        return driver.findElement(searchTitle).getText();
    }

    //hover over elements and add to cart, click continue shopping x3
    public void addElementsToCart(){
        scrollToElement(firstProduct);
        hoverOverElement(firstProduct);
        clickElement(addToCartButton1);
        driver.switchTo().activeElement();
        clickElement(closePopUp);
        hoverOverElement(secondProduct);
        clickElement(addToCartButton2);
        clickElement(closePopUp);
        hoverOverElement(thirdProduct);
        clickElement(addToCartButton3);
        clickElement(closePopUp);
    }

    //click cart
    public void clickCart(){
        scrollToElement(cartButton);
        clickElement(cartButton);
    } 
}
