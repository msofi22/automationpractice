package io_automatenow_test;

import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.ModalsPage;

public class ModalsTest extends BaseTest{
   
    private String name= "Sofi";
    private String email= "testwithme1.0@gmail.com";

    ModalsPage modalsPage = new ModalsPage();

    @Test(description = "Test a simple modal open/close")
    public void testSimpleModal(){
        modalsPage.navigateToModalPage();
        modalsPage.clickSimpleModal();
        modalsPage.closeSimpleModal();
    }

    @Test(description = "Fill and submit a form in a modal")
    public void testFormModal(){
        modalsPage.navigateToModalPage();
        modalsPage.clickFormModal();
        modalsPage.enterFormInfo(name, email);
        modalsPage.submitForm();
    }
}
