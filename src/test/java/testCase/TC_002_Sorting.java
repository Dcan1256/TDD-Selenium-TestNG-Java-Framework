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

package testCase;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import testBase.BaseClass;

/**
 * **********************************************************************
 * Class Name: TC_002_Sorting
 * Tests:
 *     @test sortingTest()
 *
 *
 * Author: Necdet Dogancan Yormaz
 * Created: 9/17/2024
 *
 *
 * **********************************************************************
 */
public class TC_002_Sorting extends BaseClass {

    @Test
    public void sortingTest(){
        try {
            logger.info("***** Starting sortingTest test at TC_002_Sorting !!! *****");
            //Login Page -->
            logger.info("----- Logging in... -----");
            LoginPage lp=new LoginPage(driver);
            lp.loginWithConfigFile(); // Verified Login from the date in the config file...

            // Main Page -->
            MainPage mp=new MainPage(driver);
            Select select=new Select(mp.sortingDropDown);
            logger.info("----- Selecting A to Z at sorting dropdown... -----");
            select.selectByValue("az");
            System.out.println(select.getFirstSelectedOption().getText());
            logger.info("----- Verifying  A to Z is Selected at sorting dropdown... -----");
            Assert.assertEquals(select.getFirstSelectedOption().getText(),"Name (A to Z)");
            logger.info("----- Selecting Z to A at sorting dropdown... -----");
            select.selectByValue("za");
            System.out.println(select.getFirstSelectedOption().getText());
            logger.info("----- Verifying  Z to A is Selected at sorting dropdown... -----");
            Assert.assertEquals(select.getFirstSelectedOption().getText(),"Name (Z to A)");
            logger.info("----- Selecting Low to High at sorting dropdown... -----");
            select.selectByValue("lohi");
            System.out.println(select.getFirstSelectedOption().getText());
            logger.info("----- Verifying  Low to High is Selected at sorting dropdown... -----");
            Assert.assertEquals(select.getFirstSelectedOption().getText(),"Price (low to high)");
            logger.info("----- Selecting High to Low at sorting dropdown... -----");
            select.selectByValue("hilo");
            System.out.println(select.getFirstSelectedOption().getText());
            logger.info("----- Verifying  High to Low is Selected at sorting dropdown... -----");
            Assert.assertEquals(select.getFirstSelectedOption().getText(),"Price (high to low)");
            logger.info("***** SUCCESS !!! *****");
            logger.info("***** Finishing sortingTest test at TC_002_Sorting !!! *****");
        }

        catch (Exception e){
            Assert.fail();
            logger.info("***** sortingTest test at TC_002_Sorting FAILED because of an Exception !!! *****");
        }


    }
}
