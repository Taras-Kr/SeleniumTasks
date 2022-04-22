package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import com.taraskrasitskiy.seleniumtasks.timvroom.ui.runner.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends TestRunner {
    @Test
    public void verifiesThatHomePageIsOpened(){
        HomePage homePage = new HomePage(driver);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifiesThatPageTitleCorrectlyEnteredInInput(){
        HomePage homePage = new HomePage(driver);
        homePage.setTextInInput(homePage.getAnswerOneInput(), homePage.getPageTitle());
        String expected = "Selenium Playground";
        String actual = homePage.getTextFromInput(homePage.getAnswerOneInput());
        Assert.assertEquals(actual, expected);
    }


}
