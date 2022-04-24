package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import com.taraskrasitskiy.seleniumtasks.timvroom.ui.runner.TestRunner;
import io.qameta.allure.Description;
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
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(1), "OK");
    }

    @Test
    @Description("Verifies that Name correctly entered in the Input")
    public void verifiesThatNameEnteredInInput() {
        HomePage homePage = new HomePage(driver);
        String expectedName = "Kilgore Trout";
        homePage.setTextInInput(homePage.getNameInput(), expectedName);
        String actualName = homePage.getTextFromInput(homePage.getNameInput());
        Assert.assertEquals(actualName, expectedName);
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(2), "OK");
    }

    @Test
    @Description("Verifies that Occupation correctly selected in the Select")
    public void verifiesThatOccupationCorrectlySelected() {
        HomePage homePage = new HomePage(driver);
        homePage.setOccupation(Occupation.SCIENCE_FICTION_AUTHOR.getValue());
        String expectedOccupation = Occupation.SCIENCE_FICTION_AUTHOR.getText();
        String actualOccupation = homePage.getOccupation();
        Assert.assertEquals(actualOccupation, expectedOccupation);
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(3), "OK");
    }
    @Test
    @Description("Verifies that blue boxes count correctly")
    public void verifiesThatBlueBoxesCountCorrectly() {
        HomePage homePage = new HomePage(driver);
        String countBlueBoxes = String.valueOf(homePage.countBlueBoxes());
        homePage.enterAnswerFour(countBlueBoxes);
        String actualCountBlueBoxes = homePage.getTextFromAnswerFour();
        Assert.assertEquals(actualCountBlueBoxes, String.valueOf(homePage.countBlueBoxes()));
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(4), "OK");
    }

    @Test
    @Description("Verifies that click on \'click me\' link successful")
    public void verifiesThatClickMeOpened(){
        HomePage homePage = new HomePage(driver);
        homePage.openClickMe();
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(5), "OK");
    }

    @Test
    @Description("Verifies that red box css class got correctly")
    public void verifyThatRedBoxClassGetCorrectly(){
        HomePage homePage = new HomePage(driver);
        homePage.enterAnswerSix(homePage.getRedBoxClass());
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(6), "OK");
    }
}
