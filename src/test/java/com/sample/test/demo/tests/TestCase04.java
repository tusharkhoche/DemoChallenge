package com.sample.test.demo.tests;

import com.sample.test.demo.constants.Messages;
import dataproviders.DataProviderTestCase04;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase04 extends TestBase {

    @Test(dataProviderClass = DataProviderTestCase04.class, dataProvider = "DPTestCase04Details")
    public void AssertTest04(String userName, String userEmail, String userPhone) {

        inputCustomerDetails(userName, userEmail, userPhone);
        selectPaymentMethod();
        placePizzaOrderAndWaitForConfirmation();
        String actualDialogBoxText = getActualOrderConfirmationText();
        String expectedDialogBoxText = getExpectedOrderConfirmationText();

        try {
            Assert.assertEquals(actualDialogBoxText, expectedDialogBoxText);
        } catch (AssertionError e) {
            assertAndLogInReportPortal(actualDialogBoxText, expectedDialogBoxText, e.getMessage());
        }
        Assert.assertEquals(actualDialogBoxText, expectedDialogBoxText);
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

    private String getActualOrderConfirmationText() {
        return pizzaOrderPage.getTextDisplayedOnOrderConfirmationBox().trim();
    }

    private String getExpectedOrderConfirmationText() {
        return Messages.PIZZA_ERROR_MESSAGE.getDisplayName();
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


