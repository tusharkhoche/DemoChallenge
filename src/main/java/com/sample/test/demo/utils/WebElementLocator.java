package com.sample.test.demo.utils;

import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;



public class WebElementLocator {

    private  String locatorType;
    private  String locatorValue;
    private  String locatorString;
    private  By locator;

    public WebElementLocator() {
        loadProperties();
    }

    private  Properties locatorProperties;
    private FileInputStream fileInputStream = null;

    private void loadProperties() {
        try {
            createFileInputStreamObject();
            createPropertiesObject();
            loadFileInputStream();
            closeFileInputStream();
        } catch (IOException e) {
            ReportPortal.emitLog(e.getMessage(),"ERROR",new Date());
        }
    }

    private void createFileInputStreamObject() throws IOException
    {
        String CONFIG_FILE_NAME = "/locators.properties";
        String CONFIG_FILE_PATH = "src/test/resources";
        fileInputStream = new FileInputStream(CONFIG_FILE_PATH + CONFIG_FILE_NAME);
    }

    private void createPropertiesObject()
    {
        locatorProperties = new Properties();
    }

    private void loadFileInputStream() throws IOException
    {
        locatorProperties.load(fileInputStream);
    }

    private void closeFileInputStream() throws IOException
    {
        fileInputStream.close();
    }

    public  By getLocator(String locatorPath) {
        getLocatorProperty(locatorPath);
        splitLocator();
        selectLocator();
        return locator;
    }

    private  void getLocatorProperty(String logicalElementName) {
        locatorString = locatorProperties.getProperty(logicalElementName);
    }

    private  void splitLocator() {
        locatorType = locatorString.split(">")[0];
        locatorValue = locatorString.split(">")[1];
        locatorType = locatorType.toLowerCase();
    }

    private  void selectLocator() {
        switch (locatorType) {
            case "id":
                locator = By.id(locatorValue);
                break;

            case "name":
                locator = By.name(locatorValue);
                break;

            case "classname":
                locator = By.className(locatorValue);
                break;

            case "tagname":
                locator = By.tagName(locatorValue);
                break;

            case "linktext":
                locator = By.linkText(locatorValue);
                break;

            case "partiallinktext":
                locator = By.partialLinkText(locatorValue);
                break;

            case "cssselector":
                locator = By.cssSelector(locatorValue);
                break;

            case "xpath":
                locator = By.xpath(locatorValue);
                break;

            default:
                throw new RuntimeException(locatorType + " " + locatorValue + " is not defined.");
        }
    }

}
