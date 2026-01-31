package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getExtentReport();
    }

    @BeforeMethod
    public void setup(Method method) {
        test = extent.createTest(method.getName());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test skipped");
        }

        driver.quit();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}