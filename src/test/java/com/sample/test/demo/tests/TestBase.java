package com.sample.test.demo.tests;


import com.sample.test.demo.constants.DriverType;
import com.sample.test.demo.driverfactory.DriverManager;
import com.sample.test.demo.driverfactory.DriverManagerFactory;
import com.sample.test.demo.pages.PizzaOrderPage;
import com.sample.test.demo.utils.AssertAndLog;
import com.sample.test.demo.utils.Configuration;
import com.sample.test.demo.utils.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;
    DriverManager driverManager;
    PizzaOrderPage pizzaOrderPage;
    private ScreenshotUtility screenshotUtility;

    @BeforeClass(alwaysRun = true)
    public void initializeTest() {
        initializeConfiguration();
        getUrlFromConfig();
        initializeDriver();
        initializeClassInstances();
        navigateToSite();
    }

    private void initializeConfiguration() {
        config = new Configuration();
    }

    private void getUrlFromConfig() {
        url = config.getUrl();
    }


    private void initializeDriver() {
        driverManager = DriverManagerFactory.getManager(DriverType.ChromeBrowser.getDisplayName());
        driver = driverManager.getDriver();
    }

    private void initializeClassInstances() {
        pizzaOrderPage = new PizzaOrderPage(driver);
        screenshotUtility = new ScreenshotUtility();
    }


    private void navigateToSite() {
        driver.get(url);
    }

    protected <E> void assertAndLogInReportPortal(E actual, E expected, String log) {
        File screenshot = screenshotUtility.takeScreenshotAsFile(driver);
        AssertAndLog.assertEquals(actual, expected, log, screenshot);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
