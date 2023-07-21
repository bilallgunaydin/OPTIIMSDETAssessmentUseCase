package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileWriter;
import java.io.IOException;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static FileWriter logWriter;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
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
        writeToLogFile(status + " - " + message);
    }

    public static synchronized void log(Status status, Throwable throwable) {
        getTest().log(status, throwable);
        writeToLogFile(status + " - " + throwable);
    }

    private static void writeToLogFile(String logMessage) {
        try {
            if (logWriter == null) {
                logWriter = new FileWriter("test-log.txt");
            }
            logWriter.write(logMessage + "\n");
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeLogFile() {
        try {
            if (logWriter != null) {
                logWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
