package com.sample.test.demo.tests;

import com.sample.test.demo.constants.Messages;
import dataproviders.DataProviderTestCase08;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase08 extends TestBase {

    @Test(dataProviderClass = DataProviderTestCase08.class, dataProvider = "DPTestCase08Details")
    public void AssertTest08(String pizzaType, Integer pizzaQuantity, String userName, String userEmail, String userPhone) {

        selectPizzaToOrder(pizzaType);
        inputPizzaQuantity(pizzaQuantity);
        selectPaymentMethod();
        inputCustomerDetails(userName, userEmail, userPhone);
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

    private void inputCustomerDetails(String userName, String userEmail, String userPhone) {
        pizzaOrderPage.inputCustomerName(userName);
        pizzaOrderPage.inputCustomerEmail(userEmail);
        pizzaOrderPage.inputCustomerPhone(userPhone);
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


