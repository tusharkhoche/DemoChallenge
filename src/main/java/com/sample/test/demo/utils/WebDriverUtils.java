package com.sample.test.demo.utils;

import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebDriverUtils {

    WebDriver driver;
    private final FluentWait<WebDriver> fluentWait;
    private ScreenshotUtility screenshotUtility;

    public WebDriverUtils(WebDriver driver) {
        this.driver = driver;
        fluentWait = new FluentWait<>(this.driver);
        screenshotUtility = new ScreenshotUtility();
    }


    private boolean waitForVisibilityOfAllElementsBy(By locator) {
        boolean result = false;
        try {
            fluentWaitForAllElements(locator);
            result = true;
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            File screenshot = screenshotUtility.takeScreenshotAsFile(driver);
            ReportPortal.emitLog(e.getMessage(), "ERROR", new Date(), screenshot);
        }
        return result;
    }

    private void fluentWaitForAllElements(By locator) throws TimeoutException, NoSuchElementException, StaleElementReferenceException {
        final int DEFAULT_WAIT_TIME = 10;
        final int DEFAULT_POLLING_TIME = 500;
        final String TIME_OUT_MESSAGE = "Time Out. Element Not Found! ";
        fluentWait.pollingEvery(Duration.ofMillis(DEFAULT_POLLING_TIME))
                .withTimeout(Duration.ofSeconds(DEFAULT_WAIT_TIME))
                .withMessage(TIME_OUT_MESSAGE + locator.toString())
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> findWebElements(By locator) {

        List<WebElement> webElementList = new ArrayList<>();

        if (waitForVisibilityOfAllElementsBy(locator)) {
            webElementList = driver.findElements(locator);
        }
        return webElementList;
    }

    public void clickOnWebElement(WebElement webElement) {
        webElement.click();
    }

    public void clickOnWebElement(By locator) {
        List<WebElement> webElementList = findWebElements(locator);
        webElementList.get(0).click();
    }


    public void selectInDropdown(By locator, String valueToSelect) {
        WebElement dropdownElement = findWebElements(locator).get(0);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(valueToSelect);
    }

    public String getTextFromTextBox(WebElement webElement) {
        return webElement.getText();
    }

    public String getJsTextFromTextBox(By locator) {
        WebElement webElement = findWebElements(locator).get(0);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("arguments[0].innerHTML", webElement).toString();
    }

    public String getTextFromTextBox(By locator) {
        WebElement webElement = findWebElements(locator).get(0);
        return webElement.getText();
    }

    public void typeInTextBox(WebElement webElement, String valueToType) {
        webElement.clear();
        webElement.sendKeys(valueToType);
    }

    public void typeInTextBox(By locator, String valueToType) {
        WebElement webElement = findWebElements(locator).get(0);
        webElement.clear();
        webElement.sendKeys(valueToType);
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }
}
