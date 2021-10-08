package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class GesturePage extends BasePage {
    private String gestureURL="https://automatenow.io/gestures/";
    private By pointToDrag=By.id("d");
    private int targetY= 0;
    private int targetX1=10;
    private int targetX= 30;

    public GesturePage(){
        super(driver);
    }

    public void navigateToGestures(){
        navigateTo(gestureURL);
    }

    public void dragMap(){
        dragAnElementByCoordinates(pointToDrag, targetX1, targetY);
        dragAnElementByCoordinates(pointToDrag, targetX, targetY);
    }

}
