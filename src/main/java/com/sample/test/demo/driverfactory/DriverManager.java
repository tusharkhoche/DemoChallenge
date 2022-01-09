package com.sample.test.demo.driverfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;
    static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    abstract void createDriver();

    public WebDriver getDriver() {
        driver = webDriverThreadLocal.get();
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
