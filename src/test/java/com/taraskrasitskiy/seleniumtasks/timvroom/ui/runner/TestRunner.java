package com.taraskrasitskiy.seleniumtasks.timvroom.ui.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import properties.SystemProperties;

import java.util.concurrent.TimeUnit;

public class TestRunner {
    protected static WebDriver driver;
    private SystemProperties properties = new SystemProperties();

    @BeforeClass
    public void getDriver(){
        switch (properties.getBrowser()){
            case  "chrome" :{
                System.setProperty("webdriver.chrome.driver", properties.getChromeDriver());
                driver = new ChromeDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getBaseUrl());
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.close();
        }
    }

}
