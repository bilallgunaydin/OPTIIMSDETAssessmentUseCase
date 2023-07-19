package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("extent-report.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setDocumentTitle("Extent Report");
        htmlReporter.config().setReportName("Test Case Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static synchronized ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        test.assignAuthor("Bilal Günaydın");
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return test;
    }

    public static synchronized void log(Status status, String message) {
        getTest().log(status, message);
    }

    public static synchronized void log(Status status, Throwable throwable) {
        getTest().log(status, throwable);
    }
}
