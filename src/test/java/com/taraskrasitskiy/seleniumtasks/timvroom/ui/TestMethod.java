package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import com.taraskrasitskiy.seleniumtasks.timvroom.ui.runner.TestRunner;
import org.testng.annotations.Test;

public class TestMethod extends TestRunner {
    @Test
    public void openHomePage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
