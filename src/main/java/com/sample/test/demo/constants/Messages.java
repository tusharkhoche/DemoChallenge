package com.sample.test.demo.constants;

public enum Messages {

    NAME_ERROR_MESSAGE("Missing name"),
    PHONE_ERROR_MESSAGE("Missing phone number"),
    PIZZA_ERROR_MESSAGE("Missing pizza details"),
    PIZZA_QUANTITY_ERROR_MESSAGE("Missing pizza quantity details"),
    PAYMENT_ERROR_MESSAGE("Missing payment details"),
    THANK_YOU_MESSAGE("Thank you for your order!");

    private String displayName;

    private Messages(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
