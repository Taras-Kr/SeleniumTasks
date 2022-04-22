package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private WebElement answerOneInput;

    public HomePage(WebDriver driver) {
        this.driver = driver;
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
}
