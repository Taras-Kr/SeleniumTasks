package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import com.taraskrasitskiy.seleniumtasks.timvroom.ui.runner.TestRunner;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSuite extends TestRunner {

    @Test
    @Description("Verifies that Home Page opened")
    public void verifiesThatHomePageIsOpened() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String actualUrl = homePage.getUrl();
        softAssert.assertEquals(actualUrl, "http://timvroom.com/selenium/playground/");
        String actualTopHeader = homePage.getTopHeader();
        softAssert.assertEquals(actualTopHeader, "Selenium Testing Tasks");
        softAssert.assertAll();
    }

    @Test
    @Description("Verifies that page title correctly entered in the Input")
    public void verifiesThatPageTitleCorrectlyEnteredInInput() {
        HomePage homePage = new HomePage(driver);
        homePage.setTextInInput(homePage.getAnswerOneInput(), homePage.getPageTitle());
        String expected = "Selenium Playground";
        String actual = homePage.getTextFromInput(homePage.getAnswerOneInput());
        Assert.assertEquals(actual, expected);
    }

    @Test
    @Description("Verifies that Name correctly entered in the Input")
    public void verifiesThatNameEnteredInInput() {
        HomePage homePage = new HomePage(driver);
        String expectedName = "Kilgore Trout";
        homePage.setTextInInput(homePage.getNameInput(), expectedName);
        String actualName = homePage.getTextFromInput(homePage.getNameInput());
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    @Description("Verifies that Occupation correctly selected in the Select")
    public void verifiesThatOccupationCorrectlySelected(){
        HomePage homePage = new HomePage(driver);
        homePage.setOccupation(Occupation.SCIENCE_FICTION_AUTHOR.getValue());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
