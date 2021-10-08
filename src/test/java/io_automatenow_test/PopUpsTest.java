package io_automatenow_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.PopUpsPage;

public class PopUpsTest extends BaseTest {

    PopUpsPage popUps= new PopUpsPage();

    @Test(description= "Test open and close JS alert")
    public void testJsAlert(){
        popUps.navigateToPopUps();
        popUps.clickJSAlert();
    }

    @Test(description = "Test popup confirmation, asses text is correct")
    public void testConfirmPopUp(){
        popUps.navigateToPopUps();
        popUps.clickConfirmPopUp();
        String message= popUps.confirmResult();

        Assert.assertTrue(message.contains("OK"),"INCORRECT message");
        System.out.println(message);
    }

    @Test(description = "Test entering a String into a popup")
    public void testPopUpInput(){
        String inputText = "Dolores Abernathy";
        popUps.navigateToPopUps();
        popUps.clickAndInputInPrompt(inputText);
        String niceToMeetYouMessage = popUps.promptResponse();
        
        Assert.assertTrue(niceToMeetYouMessage.contains(inputText), "INCORRECT message");
        System.out.println(niceToMeetYouMessage);
    }
    
}
