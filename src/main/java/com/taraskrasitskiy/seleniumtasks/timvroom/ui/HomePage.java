package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("HomePage: Get url")
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Home Page: Get web element Input AnswerOne")
    public WebElement getAnswerOneInput() {
        return driver.findElement(By.cssSelector("input#answer1"));
    }

    @Step("Home Page: Get page title")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Home Page: Set text {text} in to the input field")
    public HomePage setTextInInput(WebElement input, String text) {
        input.click();
        input.clear();
        input.sendKeys(text);
        return this;
    }

    @Step("Home Page: Get text from the input field")
    public String getTextFromInput(WebElement input) {
        return input.getAttribute("value");
    }

    @Step("Home Page: Get top header")
    public String getTopHeader(){
        return driver.findElement(By.cssSelector("h2#tophead")).getText();
    }

    @Step("HomePage: Get Name input")
    public WebElement getNameInput(){
        return  driver.findElement(By.id("name"));
    }

    @Step("Home Page: Set Occupation")
    public HomePage setOccupation(String occupation){
        driver.findElement(By.cssSelector(String.format("option[value='%s']", occupation))).click();
        return this;
    }

    @Step("Home Page: Get Occupation")
    public String getOccupation() {
        Select selectOccupation = new Select(driver.findElement(By.name("occupation")));
        return selectOccupation.getFirstSelectedOption().getText();
    }

    @Step("Home Page: Count blue boxes")
    public int countBlueBoxes(){
        return  driver.findElements(By.cssSelector("span.bluebox")).size();
    }

    @Step("Home Page: Enter count blue boxes into answers")
    public HomePage enterAnswerFour(String text){
        WebElement answerInput = driver.findElement(By.id("answer4"));
        answerInput.click();
        answerInput.clear();
        answerInput.sendKeys(text);
        return this;
    }

    @Step("Home Page: Get text from answer 4")
    public String getTextFromAnswerFour(){
        return driver.findElement(By.id("answer4")).getAttribute("value");
    }

    @Step("Home Page: Open \'click me\' link")
    public HomePage openClickMe(){
        driver.findElement(By.linkText("click me")).click();
        return this;
    }

    @Step("Home Page: Check results")
    public HomePage checkResults(){
        driver.findElement(By.xpath("//input[@id='checkresults']")).click();
        return this;
    }

    @Step("Home Page: Get result task{taskNumber}")
    public String getResultTask(int taskNumber){
        return driver.findElement(By.xpath(String.format("//span[@id='ok_%s']", taskNumber))).getText();
    }

    @Step("Home Page: Enter answer six")
    public HomePage enterAnswerSix(String text){
        WebElement answerSixInput = driver.findElement(By.xpath("//input[@id='answer6']"));
        answerSixInput.click();
        answerSixInput.clear();
        answerSixInput.sendKeys(text);
        return this;
    }

    @Step("Home Page: Get text from answer six input ")
    public String getTextFromAnswerSix() {
        return driver.findElement(By.xpath("//input[@id='answer6']")).getAttribute("value");
    }

    @Step("Home Page: Get Red Box class")
    public String getRedBoxClass(){
        return driver.findElement(By.xpath("//span[@id = 'redbox']")).getAttribute("class");
    }
}
