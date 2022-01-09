package com.sample.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PizzaOrderPage extends PageBase {

    public PizzaOrderPage(WebDriver driver) {
        super(driver);
    }

    private final By PIZZA_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("pizza1");
    private final By PIZZA_TOPPINGS1_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("pizza1Toppings1");
    private final By PIZZA_TOPPINGS2_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("pizza1Toppings2");
    private final By PIZZA_QUANTITY_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("pizza1Quantity");
    private final By PIZZA_COST_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("pizza1Cost");
    private final By RADIO_CREDIT_CARD_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("radioCreditCard");
    private final By RADIO_CASH_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("radioCash");
    private final By CUSTOMER_EMAIL_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("email");
    private final By CUSTOMER_NAME_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("customerName");
    private final By CUSTOMER_PHONE_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("phone");
    private final By PLACE_ORDER_BUTTON_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("placeOrderButton");
    private final By RESET_BUTTON_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("resetButton");
    private final By DIALOG_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("dialog");
    private final By DIALOG_BOX_TEXT_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("dialogText");
    private final By DIALOG_BOX_CLOSE_WEB_ELEMENT_LOCATOR = webElementLocator.getLocator("dialogClose");

    public void selectPizza(String pizzaNameToSelect) {
        webDriverUtils.selectInDropdown(PIZZA_WEB_ELEMENT_LOCATOR, pizzaNameToSelect);
    }

    public void selectToppings1(String pizzaToppings1ToSelect) {
        webDriverUtils.selectInDropdown(PIZZA_TOPPINGS1_WEB_ELEMENT_LOCATOR, pizzaToppings1ToSelect);
    }

    public void selectToppings2(String pizzaToppings2ToSelect) {
        webDriverUtils.selectInDropdown(PIZZA_TOPPINGS2_WEB_ELEMENT_LOCATOR, pizzaToppings2ToSelect);
    }

    public void inputPizzaQuantity(String numberOfPizzaRequired) {
        webDriverUtils.typeInTextBox(PIZZA_QUANTITY_WEB_ELEMENT_LOCATOR, numberOfPizzaRequired);
    }

    public int getTotalCostOfOrder() {
        String costInString = webDriverUtils.getTextFromTextBox(PIZZA_COST_WEB_ELEMENT_LOCATOR);
        return convertStringToInteger(costInString);
    }

    private Integer convertStringToInteger(String numberInString) {
        return Integer.parseInt(numberInString);
    }


    public void inputCustomerName(String customerName) {
        webDriverUtils.typeInTextBox(CUSTOMER_NAME_WEB_ELEMENT_LOCATOR, customerName);
    }

    public void inputCustomerEmail(String customerEmail) {
        webDriverUtils.typeInTextBox(CUSTOMER_EMAIL_WEB_ELEMENT_LOCATOR, customerEmail);
    }

    public void inputCustomerPhone(String customerPhone) {
        webDriverUtils.typeInTextBox(CUSTOMER_PHONE_WEB_ELEMENT_LOCATOR, customerPhone);
    }

    public void selectCreditCardForPayment() {
        webDriverUtils.clickOnWebElement(RADIO_CREDIT_CARD_WEB_ELEMENT_LOCATOR);
    }

    public void selectCashForPayment() {
        webDriverUtils.clickOnWebElement(RADIO_CASH_WEB_ELEMENT_LOCATOR);
    }


    public void resetPizzaOrderPage() {
        webDriverUtils.clickOnWebElement(RESET_BUTTON_WEB_ELEMENT_LOCATOR);
    }

    public void placePizzaOrder() {
        webDriverUtils.clickOnWebElement(PLACE_ORDER_BUTTON_WEB_ELEMENT_LOCATOR);
    }

    public void waitTillOrderConfirmationBoxIsDisplayed() {
        webDriverUtils.findWebElements(DIALOG_WEB_ELEMENT_LOCATOR);
    }

    public String getTextDisplayedOnOrderConfirmationBox() {
        return webDriverUtils.getTextFromTextBox(DIALOG_BOX_TEXT_WEB_ELEMENT_LOCATOR);
    }

    public String getTextEnteredInUserNameField() {
        return webDriverUtils.getJsTextFromTextBox(CUSTOMER_NAME_WEB_ELEMENT_LOCATOR);
    }

    public void closeOrderConfirmationDialogBox() {
        webDriverUtils.clickOnWebElement(DIALOG_BOX_CLOSE_WEB_ELEMENT_LOCATOR);
    }

}
