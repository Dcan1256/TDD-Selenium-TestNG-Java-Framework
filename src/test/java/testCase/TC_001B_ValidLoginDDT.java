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

import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableLatest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.MainPage;
import PageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;


/**
 * **********************************************************************
 * Class Name: TC_001B_ValidLoginDDT
 * Tests:
 *     @test loginDDT()
 *

 * Author: Necdet Dogancan Yormaz
 * Created: 9/17/2024
 *
 *
 * **********************************************************************
 */
public class TC_001B_ValidLoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
    public void loginDDT(String username,String password, String result){
        logger.info("***** Starting loginDDT test at TC_001B_ValidLoginDDT *****");
        //Login Page -->
        logger.info("----- Entering correct credential to login from the config file... -----");
        LoginPage lp=new LoginPage(driver);
        lp.login(username,password);


        if(result.equalsIgnoreCase("valid")){
            logger.info("----- Heading to Main Page... -----");
            MainPage mp=new MainPage(driver);
            logger.info("----- Verifying Main Page title is displayed...");
            Assert.assertTrue(mp.mainPageTittle.isDisplayed());
            logger.info("***** SUCCESS !!! *****");
        }

        else if (result.equalsIgnoreCase("invalid")) {
            logger.info("----- Trying to login with incorrect credentials");
            logger.info("----- Verifying the error message is displayed -----");
            Assert.assertTrue(lp.errorMsg.isDisplayed());
            logger.info("***** SUCCESS !!! *****");

        }
        else {
            logger.info("----- Something went wrong :'(-----");
            Assert.fail();
        }

    }
}
