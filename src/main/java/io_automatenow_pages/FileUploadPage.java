package io_automatenow_pages;

import org.openqa.selenium.By;

import base.BasePage;

public class FileUploadPage extends BasePage{
    private String fileUploadURL= "https://automatenow.io/file-upload/";
    private By uploadField= By.id("file_upload");
    private String fileToUpload = "C:\\Users\\DELL-5567\\Desktop\\TESTING AND DEV\\Automation PRACTICE\\MavenPractice\\MavenProjectPractice\\mavenpractice\\TestTest.txt";
    private By uploadButton= By.xpath("//input[@value='Upload']"); 
    private By confirmationMessage = By.xpath("//div[@class='wpcf7-response-output']");

    public FileUploadPage(){
        super(driver);
    }

    public void navigateToFileUpload(){
        navigateTo(fileUploadURL);
    }

    public void uploadFile(){
        driver.findElement(uploadField).sendKeys(fileToUpload);
        clickElement(uploadButton);
    }

    public String getUploadConfirm(){
        clickElement(confirmationMessage);
        return driver.findElement(confirmationMessage).getText();
    }


}
