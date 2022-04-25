package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
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

    @Step("Home Page: Open 'click me' link")
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

    @Step("Home Page: Run javascript script")
    public HomePage runScript(String script){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script);
        return this;
    }

    @Step("Home Page: Enter answer eight")
    public HomePage enterAnswerEight(String text){
        WebElement answerEightInput = driver.findElement(By.xpath("//input[@id='answer8']"));
        answerEightInput.click();
        answerEightInput.clear();
        answerEightInput.sendKeys(text);
        return this;
    }

    @Step("Home Page: Run javascript function")
    public Long runFunction(String jsFunction) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Long)js.executeScript(String.format("return %s", jsFunction));
    }

    @Step("Home Page: Select radio button 'Wrote Book'")
    public HomePage selectWroteBook(){
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='wrotebook']"));
        if(!radioButton.isSelected()){
            radioButton.click();
        }
        return this;
    }

    @Step("Home Page: Get text from red box")
    public String getTexFromRedBox(){
        return driver.findElement(By.xpath("//span[@id='redbox']")).getText();
    }

    @Step("Home Page: Enter answer Ten")
    public HomePage enterAnswerTen(String text){
        WebElement answerEightInput = driver.findElement(By.xpath("//input[@id='answer10']"));
        answerEightInput.click();
        answerEightInput.clear();
        answerEightInput.sendKeys(text);
        return this;
    }

    @Step("Home Page: Get coordinates Orange Box")
    public Point getCoordinatesOrangeBox(){
        return driver.findElement(By.xpath("//span[@id='orangebox']")).getLocation();
    }

    @Step("Home Page: Get coordinates Green Box")
    public Point getCoordinatesGreenBox(){
        return driver.findElement(By.xpath("//span[@id='greenbox']")).getLocation();
    }
    @Step("Home Page: Enter answer Eleven")
    public HomePage enterAnswerEleven(){
        Point coordinatesGreenBox = getCoordinatesGreenBox();
        Point coordinatesOrangeBox = getCoordinatesOrangeBox();
        WebElement answerEightInput = driver.findElement(By.xpath("//input[@id='answer11']"));
        answerEightInput.click();
        answerEightInput.clear();
        String answer = coordinatesGreenBox.getY() < coordinatesOrangeBox.getY() ? "green" : "orange";
        answerEightInput.sendKeys(answer);
        return this;
    }

}



