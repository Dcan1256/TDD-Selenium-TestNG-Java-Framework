/**
 * **********************************************************************
 * Project Name: TDD-Framework_Selenium_TestNG_Java
 * Author: Necdet Dogancan Yormaz
 * Date : 9/17/2024
 * Description: WebDriver Initialization locally or remotely based on the user preference,
 * tear down the initialized browser after the usage, and some other needed utilities
 *
 * Revision History:
 * Date | Author | Description
 * ----------------------------------------------------------------------
 * 9/17/2024 | Necdet Dogancan Yormaz | Created
 * [Date] | [Contributor] | [Update Description]
 *
 * **********************************************************************
 */

package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager; // for log4j logger
import org.apache.logging.log4j.Logger; // for log4j logger
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * **********************************************************************
 * Class Name: BaseClass
 * Description:
 *     setUp()
 *     tearDown()
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
public class BaseClass {

    //The static WebDriver object shared across this class
    public static WebDriver driver;

    // The Logger Instance will be used for logging actions related with the class
    public Logger logger;

    /**
     * **********************************************************************
     * Method Name: setUp
     *
     * Description:
     *     WebDriver Initialization locally or remotely based on the user preference
     *
     * Parameters:
     *     @param "os,browser" / @desc "Operating system, Browser" --> Retrieved from the XML suite file
     *     [Repeat for each parameter]
     *
     * Return:
     *     @return void
     *
     * Exceptions:
     *     @throws "MalformedURLException" --> Condition under MalformedURLException
     *
     * Usage:
     *     Initialization locally or remotely based on the user preference, before each method.
     *
     * **********************************************************************
     */
    @Parameters({"os","browser"}) // Passing Operating system and browser details
    @BeforeMethod(groups = {"Regression","Master","Sanity"}) // Add or replace the groups based on your needs !!!
    public void setUp(String os, String browser) throws MalformedURLException {

        // Reading the config.properties file for the config info shared across this project...
        ResourceBundle config=ResourceBundle.getBundle("config");

        // Returning Class name internally to the log
        logger=LogManager.getLogger(this.getClass());


        // Local Machine Execution Sequence ______________________________________________________________________________
        if (config.getString("exec_env").equalsIgnoreCase("local")){

            /*
            To enable the headless running more add options argument ...Driver() section and
            Uncomment the ...Options lines.
             */


            //Setting Up the Browser __________________________________
            // Chrome Browser (Local) ...
            if(browser.equalsIgnoreCase("chrome")){
                //ChromeOptions options=new ChromeOptions().addArguments("--headless=new");
                driver=new ChromeDriver();
            }

            // Edge Browser (Local) ...
            else if(browser.equalsIgnoreCase("edge")){
                //EdgeOptions options=new EdgeOptions().addArguments("--headless=new");
                driver=new EdgeDriver();
            }

            // Firefox Browser (Local) ...
            else if(browser.equalsIgnoreCase("firefox")){
                FirefoxOptions options=new FirefoxOptions().addArguments("--headless=new");
                driver=new FirefoxDriver();
            }

            // No matching Browser ...
            else{
                System.out.println("No matching browser for local execution !!!");
            }

            // General Driver Specs...

            driver.manage().deleteAllCookies(); // Clearing all cookies !!!
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for 10 seconds
            driver.get(config.getString("AppURL")); // Retrieve application's URL address from the config.properties
            driver.manage().window().maximize(); // Maximize the size of the window
        }

        // Remote Machine Execution Sequence ______________________________________________________________________________
        if(config.getString("exec_env").equalsIgnoreCase("remote")){

            // This is where we are going to store our browser capabilities for our browser
            DesiredCapabilities capabilities=new DesiredCapabilities();

            //Setting Up the Operating System __________________________________

            // WIN10 Operating System...
            if(os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN10);
            }

            //MAC Operating System...
            else if(os.equalsIgnoreCase("mac")){
                capabilities.setPlatform(Platform.MAC);
            }

            //LINUX Operating System...
            else if(os.equalsIgnoreCase("linux")){
                capabilities.setPlatform(Platform.LINUX);
            }

            // No matching OS for the remote execution !!!
            else{
                System.out.println("No Matching Operating system for the remote execution");
            }

            //Setting Up the Browser __________________________________
            // Chrome Browser (Remote) ...
            if(browser.equalsIgnoreCase("chrome")){
                capabilities.setBrowserName("chrome");
            }

            // Firefox Browser (Remote) ...
            else if(browser.equalsIgnoreCase("firefox")){
                capabilities.setBrowserName("firefox");
            }

            // Edge Browser (Remote) ...
            else if (browser.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("MicrosoftEdge");
            }

            // No Matching Browser (Remote) ...
            else{
                System.out.println("No Matching Browser for the remote execution");
            }


            // General Driver Specs...

            /*
                Passing Selenium Grids address and Desired capabilities to the remote WebDriver for remote execution,
                Please replace ""http://172.17.0.1:4444/wd/hub" section if your Selenium Grid address is different from that
             */
            driver=new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"),capabilities);

            driver.manage().deleteAllCookies(); // Clearing all cookies !!!
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for 10 seconds
            driver.get(config.getString("AppURL")); // Retrieve application's URL address from the config.properties

        }


    }

    /**
     * **********************************************************************
     * Method Name: tearDwon
     *
     * Description:
     *     Closing all open drivers or only the current driver depends on preference.
     *
     * Parameters:
     *     None
     *
     * Return:
     *     @return void
     *
     * Exceptions:
     *     None
     *
     * Usage:
     *     Closing all open drivers or only the current driver depends on preference, after each method.
     *
     * **********************************************************************
     */
    @AfterMethod(groups = {"Regression","Master","Sanity"}) // Add or replace the groups based on your needs !!!
    public void tearDown(){

        //Closing all the open drivers at once
        driver.quit();

        // Closing only the current driver
        //driver.close();
    }


    /**
     * **********************************************************************
     * Method Name: captureScreen
     *
     * Description:
     *     it will take a screenshot whenever it is triggered.
     *
     * Parameters:
     *     @param "tname" / @desc "File Name"
     *     [Repeat for each parameter]
     *
     * Return:
     *     @return String
     *
     * Exceptions:
     *     @throws "IOException" --> Condition under IOException
     *
     * Usage:
     *    take a screenshot whenever it is triggered.
     *
     * **********************************************************************
     */
    public String captureScreen(String tname){
        String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
