package com.sample.test.demo.tests;

import com.sample.test.demo.constants.Messages;
import dataproviders.DataProviderTestCase03;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.function.BiFunction;

public class TestCase03 extends TestBase {

    @Test(dataProviderClass = DataProviderTestCase03.class, dataProvider = "DPTestCase03Details")
    public void AssertTest03(String pizzaType, String pizzaTopping1, String pizzaTopping2, Integer pizzaQuantity, BigDecimal pizzaCost, String userName, String userEmail, String userPhone) {

        selectPizzaToOrder(pizzaType);
        selectTopping1ForPizza(pizzaTopping1);
        selectTopping2ForPizza(pizzaTopping2);
        inputPizzaQuantity(pizzaQuantity);
        inputCustomerDetails(userName, userEmail, userPhone);
        selectPaymentMethod();
        placePizzaOrderAndWaitForConfirmation();
        String actualDialogBoxText = getActualOrderConfirmationText();

        Double pizzaCostDouble = convertPizzaCostToDouble(pizzaCost);

        BiFunction<Double, Integer, Double> calculateOrderTotal = (cost, quantity) -> cost * quantity;
        Double OrderTotal = calculateOrderTotal.apply(pizzaCostDouble, pizzaQuantity);

        String finalOrderTotal = getOrderTotalWithRequiredNumberOfDigitsAfterDecimal(OrderTotal,new DecimalFormat("###.##"));
        String expectedPizzaName = getExpectedPizzaName(pizzaType);
        String expectedDialogBoxText = getExpectedOrderConfirmationText(finalOrderTotal, expectedPizzaName);

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

    private void selectTopping1ForPizza(String pizzaTopping1) {
        pizzaOrderPage.selectToppings1(pizzaTopping1);
    }

    private void selectTopping2ForPizza(String pizzaTopping2) {
        pizzaOrderPage.selectToppings2(pizzaTopping2);
    }

    private void inputPizzaQuantity(Integer quantity) {
        String quantityOfPizza = Integer.toString(quantity);
        pizzaOrderPage.inputPizzaQuantity(quantityOfPizza);
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

    private Double convertPizzaCostToDouble(BigDecimal pizzaCosting) {
        String pizzaCostString = pizzaCosting.toString();
        return Double.parseDouble(pizzaCostString);
    }

    private String getOrderTotalWithRequiredNumberOfDigitsAfterDecimal(Double totalOfOrder, Format format) {
        return format.format(totalOfOrder);
    }

    private String getExpectedPizzaName(String typeOfPizza) {
        String[] pizzaName = typeOfPizza.split(" ");
        String space = " ";
        return pizzaName[0] + space + pizzaName[1] + space + pizzaName[2] + space + pizzaName[3] + space + pizzaName[4] + space + pizzaName[5];
    }

    private String getExpectedOrderConfirmationText(String finalOrderTotal, String expectedPizzaName) {
        return Messages.THANK_YOU_MESSAGE.getDisplayName() + " TOTAL:" + " " + finalOrderTotal + " " + expectedPizzaName;
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


