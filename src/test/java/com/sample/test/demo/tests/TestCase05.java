package com.sample.test.demo.tests;

import com.sample.test.demo.constants.Messages;
import dataproviders.DataProviderTestCase05;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase05 extends TestBase {


    @Test(dataProviderClass = DataProviderTestCase05.class, dataProvider = "DPTestCase05Details")
    public void AssertTest05(String pizzaType, Integer pizzaQuantity, String userName, String userEmail, String userPhone) {

        selectPizzaToOrder(pizzaType);
        inputPizzaQuantity(pizzaQuantity);
        pizzaOrderPage.inputCustomerName(userName);
        inputCustomerDetails(userName, userEmail, userPhone);
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

    private String getActualOrderConfirmationText() {
        return pizzaOrderPage.getTextDisplayedOnOrderConfirmationBox().trim();
    }

    private void inputCustomerDetails(String userName, String userEmail, String userPhone) {
        pizzaOrderPage.inputCustomerName(userName);
        pizzaOrderPage.inputCustomerEmail(userEmail);
        pizzaOrderPage.inputCustomerPhone(userPhone);
    }

    private void selectPaymentMethod() {
        pizzaOrderPage.selectCashForPayment();
    }

    private void placePizzaOrderAndWaitForConfirmation() {
        pizzaOrderPage.placePizzaOrder();
        pizzaOrderPage.waitTillOrderConfirmationBoxIsDisplayed();
    }


    private String getExpectedOrderConfirmationText() {
        return Messages.PIZZA_QUANTITY_ERROR_MESSAGE.getDisplayName();
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


