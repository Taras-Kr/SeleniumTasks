package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private WebElement answerOneInput;

    public WebElement getAnswerOneInput() {
        answerOneInput = driver.findElement(By.cssSelector("input#answer1"));
        return answerOneInput;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public HomePage setTextInInput(WebElement input, String text) {
        input.click();
        input.clear();
        input.sendKeys(text);
        input.click();
        return this;
    }

    public String getTextFromInput(WebElement input) {
        return input.getAttribute("value");
    }

}
