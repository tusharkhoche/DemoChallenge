package com.sample.test.demo.tests;

import com.sample.test.demo.constants.Messages;
import dataproviders.DataProviderTestCase06;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase06 extends TestBase {

    @Test(dataProviderClass = DataProviderTestCase06.class, dataProvider = "DPTestCase06Details")
    public void AssertTest06(String pizzaType, Integer pizzaQuantity) {

        selectPizzaToOrder(pizzaType);
        inputPizzaQuantity(pizzaQuantity);
        selectPaymentMethod();
        placePizzaOrderAndWaitForConfirmation();
        String actualDialogBoxText = getActualOrderConfirmationText();
        String expectedDialogBoxText = getExpectedOrderConfirmationText();

        try {
            Assert.assertEquals(actualDialogBoxText, expectedDialogBoxText);
        } catch (AssertionError error) {
            assertAndLogInReportPortal(actualDialogBoxText, expectedDialogBoxText, error.getMessage());
        }
        Assert.assertEquals(actualDialogBoxText, expectedDialogBoxText);
    }

    private void selectPizzaToOrder(String pizza) {
        pizzaOrderPage.selectPizza(pizza);
    }

    private void inputPizzaQuantity(Integer quantity) {
        String quantityOfPizza = Integer.toString(quantity);
        pizzaOrderPage.inputPizzaQuantity(quantityOfPizza);
    }

    private void selectPaymentMethod() {
        pizzaOrderPage.selectCreditCardForPayment();
    }

    private void placePizzaOrderAndWaitForConfirmation() {
        pizzaOrderPage.placePizzaOrder();
        pizzaOrderPage.waitTillOrderConfirmationBoxIsDisplayed();
    }

    private String getActualOrderConfirmationText() {
        String actualDialogBoxText = pizzaOrderPage.getTextDisplayedOnOrderConfirmationBox().trim();
        return actualDialogBoxText.replaceAll("[\n\r]", "");
    }

    private String getExpectedOrderConfirmationText() {
        return Messages.NAME_ERROR_MESSAGE.getDisplayName() + Messages.PHONE_ERROR_MESSAGE.getDisplayName();
    }

    @AfterMethod
    public void cleanup() {
        closeOrderConfirmationDialogBox();
        resetPage();
    }

    private void closeOrderConfirmationDialogBox() {
        pizzaOrderPage.closeOrderConfirmationDialogBox();
    }

    private void resetPage() {
        pizzaOrderPage.resetPizzaOrderPage();
    }
}


