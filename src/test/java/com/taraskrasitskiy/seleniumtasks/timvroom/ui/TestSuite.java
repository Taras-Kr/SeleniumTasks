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
    @Description("Verifies that click on 'click me' link successful")
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

    @Test
    @Description("Verifies that javascript script runs")
    public void verifyThatScriptRuns(){
        HomePage homePage = new HomePage(driver);
        homePage.runScript("ran_this_js_function()");
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(7), "OK");
    }

    @Test
    @Description("Verifies that javascript script runs")
    public void verifyThatFunctionRuns() {
        HomePage homePage = new HomePage(driver);
        Long result = homePage.runFunction("got_return_from_js_function();");
        homePage.enterAnswerEight(String.valueOf(result));
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(8), "OK");
    }

    @Test
    @Description("Verifies that radio button 'Wrote book' is selected")
    public void verifyThatWroteBookIsSelected() {
        HomePage homePage = new HomePage(driver);
        homePage.selectWroteBook();
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(9), "OK");
    }

    @Test
    @Description("Verifies that text from red box gets correctly")
    public void verifyThatTextFromRedBoxGetsCorrectly() {
        HomePage homePage = new HomePage(driver);
        homePage.enterAnswerTen(homePage.getTexFromRedBox());
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(10), "OK");
    }

    @Test
    @Description("Verifies boxes positions")
    public void verifyBoxesPositions(){
        HomePage homePage = new HomePage(driver);
        homePage.enterAnswerEleven();
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(11), "OK");
    }

    @Test
    @Description ("Verifies that element by id of ishere is on the page")
    public void verifyThatElementOnPage(){
        HomePage homePage = new HomePage(driver);
        homePage.enterAnswerTwelve(homePage.isItemOnPage());
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(13), "OK");
    }

    @Test
    @Description("Verifies that browser size set to 850x650")
    public void verifyThatBrowserSizeChanged(){
       HomePage homePage = new HomePage(driver);
       homePage.setBrowserSize(850,650);
        homePage.checkResults();
        Assert.assertEquals(homePage.getResultTask(12), "OK");
    }

    @Test
    @Description("Verifies that link opened after wait")
    public void verifiesThatLinkOpenedAfterWait(){
        HomePage homePage = new HomePage(driver);
        homePage.openClickThanWaitLink();
        homePage.openClickAfterWaitLink();
        homePage.clickOkOnConfirm();
        homePage.checkResults();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(homePage.getResultTask(15), "OK");
        soft.assertEquals(homePage.getResultTask(16), "OK");
        soft.assertAll();
    }


}
