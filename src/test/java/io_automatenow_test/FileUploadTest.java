package io_automatenow_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.FileUploadPage;

public class FileUploadTest extends BaseTest {
    
    FileUploadPage fileUploadPage= new FileUploadPage();

    @Test(description="Test uploading a file by sending keys")
    public void testFileUpload(){
        fileUploadPage.navigateToFileUpload();
        fileUploadPage.uploadFile();
        String message= fileUploadPage.getUploadConfirm();
        String confirmMessage = "Thank you for uploading";
        
        Assert.assertTrue(message.contains(confirmMessage), "ERROR: File was not uploaded!");
        System.out.println(message);
    }
}
