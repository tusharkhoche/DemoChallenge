package com.sample.test.demo.driverfactory;

import com.sample.test.demo.utils.Configuration;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.fail;

public class ChromeDriverManager extends DriverManager {

    private final Configuration config;

    public ChromeDriverManager()
    {
        config = new Configuration();
        createDriver();
    }

    @Override
    void createDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "/Users/tushar_khoche/WorkSpace/Idea/DemoChallenge-main/src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
             webDriverThreadLocal.set(new ChromeDriver());
        } else {
            fail("Unsupported browser " + config.getBrowser());
        }
    }
}
