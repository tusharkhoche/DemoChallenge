package com.sample.test.demo.pages;

import com.sample.test.demo.utils.WebDriverUtils;
import com.sample.test.demo.utils.WebElementLocator;
import org.openqa.selenium.WebDriver;

public class PageBase {

    protected WebDriver driver;
    public WebDriverUtils webDriverUtils;
    public WebElementLocator webElementLocator;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        webDriverUtils = new WebDriverUtils(this.driver);
        webElementLocator = new WebElementLocator();
    }
}