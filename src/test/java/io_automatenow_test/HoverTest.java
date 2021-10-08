package io_automatenow_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.HoverPage;

public class HoverTest extends BaseTest {
    String expectedPreHoverText= "Mouse over me!";
    String expectedPostHoverText= "You did it!";

    HoverPage hoverPage= new HoverPage();

    @Test(description="Test getting text from an element pre and post hover")
    public void testHoverText(){
        hoverPage.navigateToHover();
        String preHoverText= hoverPage.textPreHover();
        String postHoverText= hoverPage.textHovered();

        Assert.assertEquals(preHoverText, expectedPreHoverText, "The messages do not match");
        Assert.assertEquals(postHoverText, expectedPostHoverText, "The messages do not match");
        System.out.println(preHoverText);
        System.out.println(postHoverText);
    }
}
