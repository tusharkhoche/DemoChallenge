package com.sample.test.demo.utils;


import com.epam.reportportal.service.ReportPortal;
import org.testng.Assert;

import java.io.File;
import java.util.Date;

public class AssertAndLog {

    private AssertAndLog() {
    }

    public static <E> void assertEquals(E actual, E expected, String log, File file)  {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError assertionError) {
            ReportPortal.emitLog("Expected was" + expected, "ERROR", new Date());
            ReportPortal.emitLog("Actual is" + actual, "ERROR", new Date());
            ReportPortal.emitLog(log, "ERROR", new Date(), file);
        }
    }
}