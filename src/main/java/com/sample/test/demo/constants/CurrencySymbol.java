package com.sample.test.demo.constants;

public enum CurrencySymbol {


    Dollar("$");

    private String displayName;

    private CurrencySymbol(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
