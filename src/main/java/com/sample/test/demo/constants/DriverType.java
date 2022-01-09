package com.sample.test.demo.constants;

public enum DriverType {


    ChromeBrowser("CHROME"),
    FirefoxBrowser("FIREFOX");


    private String displayName;

    private DriverType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
