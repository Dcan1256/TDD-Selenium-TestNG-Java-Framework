/**
 * **********************************************************************
 * Project Name: TDD-Framework_Selenium_TestNG_Java
 * Author: Necdet Dogancan Yormaz
 * Date : 9/17/2024
 * Description: ExtentReportManager file to create a detailed report for the test results
 *
 * Revision History:
 * Date | Author | Description
 * ----------------------------------------------------------------------
 * 9/17/2024 | Necdet Dogancan Yormaz | Created
 * [Date] | [Contributor] | [Update Description]
 *
 * **********************************************************************
 */

package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;


/**
 * **********************************************************************
 * Class Name:
 * Description:
 *     onStart(ITestContext testContext)
 *     onTestSuccess(ITestResult result)
 *     onTestFailure(ITestResult result)
 *     onTestSkipped(ITestResult result)
 *     onFinish(ITestContext testContext)
 *
 *
 *
 * Usage:
 *     WebDriver Initialization locally or remotely based on the user preference,
 *     tear down the initialized browser after the usage, and some other needed utilities.
 *
 * Author: Necdet Dogancan Yormaz
 * Created: 9/17/2024
 *
 *
 * **********************************************************************
 */
public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    /**
     * Author:
     * Project:
     *
     * Description: This Class will generate an HTML-Based Extent report with
     * - timeStamp
     * - title
     * - name
     *  extent.setSystemInfo("Application", "SauceLabs");
     *         extent.setSystemInfo("Module", "Admin");
     *         extent.setSystemInfo("Sub Module", "Customers");
     *         extent.setSystemInfo("Dogan", System.getProperty("user.name"));
     *         extent.setSystemInfo("Environemnt", "QA");
     *
     *         String os = testContext.getCurrentXmlTest().getParameter("os");
     *         extent.setSystemInfo("Operating System", os);
     *
     *         String browser = testContext.getCurrentXmlTest().getParameter("browser");
     *         extent.setSystemInfo("Browser", browser);
     *         List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
     *         if(!includedGroups.isEmpty()) {
     *             extent.setSystemInfo("Groups", includedGroups.toString());
     *         }
     */
    public void onStart(ITestContext testContext) {


        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

        sparkReporter.config().setDocumentTitle("SauceLabs Automation Report"); // Title of report
        sparkReporter.config().setReportName("SauceLabs Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "SauceLabs");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("Dogan", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // to display groups in report
        test.log(Status.PASS,result.getName()+" got successfully executed");

    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,result.getName()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        String imgPath = null;
        imgPath = new BaseClass().captureScreen(result.getName());
        test.addScreenCaptureFromPath(imgPath);

    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+" got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {

        extent.flush();

        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}