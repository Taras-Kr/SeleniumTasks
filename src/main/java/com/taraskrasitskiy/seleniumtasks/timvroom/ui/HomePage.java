package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;
    private WebElement answerOneInput;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("HomePage: Get url")
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    @Step("Home Page: Get web element Input AnswerOne")
    public WebElement getAnswerOneInput() {
        answerOneInput = driver.findElement(By.cssSelector("input#answer1"));
        return answerOneInput;
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

}
