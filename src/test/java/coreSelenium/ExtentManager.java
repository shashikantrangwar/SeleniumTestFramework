package coreSelenium;
import com.aventstack.extentreports.reporter.ExtentReporter.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/Reports/extent-report.html");
        reporter.config().setReportName("Main Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("TestSystem", "TestSystem");
        extentReports.setSystemInfo("Shashikant", "99.9");
        return extentReports;
    }
}