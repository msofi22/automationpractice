package io_automatenow_test;

import org.testng.annotations.Test;

import basetest.BaseTest;
import io_automatenow_pages.GesturePage;

public class GestureTest extends BaseTest {
    
    GesturePage gesture = new GesturePage();

    @Test(description= "Test dragging an element in a map")
    public void testDragMap(){
        gesture.navigateToGestures();
        gesture.dragMap();
    }
}
