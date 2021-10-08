package io_automatenow_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.IFramePage;

public class IFrameTest extends BaseTest {
    
    IFramePage iFramePage = new IFramePage();

    @Test(description= "Test a search input by text on an iFrame, assess results title match input")
    public void testSearchOnAnIFrame(){
        iFramePage.navigateToIFrame();
        iFramePage.enterFrame1();
        String searchInput= "Victoria Pedretti";
        iFramePage.searchInFrame1(searchInput);

        String resultText =iFramePage.getSearchResultText();
        Assert.assertTrue(resultText.contains(searchInput), "INCORRECT search!");
        System.out.println(resultText);
    }

    @Test(description = "Test clicking on a button and validating navigation on an iFrame")
    public void testNavigationOnAnIFrame(){
        iFramePage.navigateToIFrame();
        iFramePage.enterFrame2();
        String buttonText =iFramePage.buttonText();
        iFramePage.clickButtonOnIFrame2();
        String sectionTitle= iFramePage.getNewPageSectionTitleFrame2();

        Assert.assertTrue(buttonText.endsWith(sectionTitle), "INCORRECT navigation title");
        System.out.println("This is the section title: "+ sectionTitle);
        System.out.println("This was the button text: "+ buttonText);
    }
}
