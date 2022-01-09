package com.sample.test.demo.driverfactory;

public class DriverManagerFactory {

    public static DriverManager getManager(String browserTypeToInvoke) {

        DriverManager driverManager = null;

        switch (browserTypeToInvoke) {
            case "CHROME":
                driverManager =  new ChromeDriverManager();
                break;

                //TODO - Implement FirefoxDriverManager When Needed
            case "FIREFOX":
                //driverManager = new FirefoxDriverManager();
                break;

            default:
                throw new RuntimeException("Unsupported Browser");
        }
        return driverManager;
    }
}
