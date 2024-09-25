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

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import testBase.BaseClass;


/**
 * **********************************************************************
 * Class Name: TC_001_ValidLogin
 * Tests:
 *     @test login()
 *     @test emptyAttemptLogin()
 *     @test wrongCredentialsLogin()
 *

 * Author: Necdet Dogancan Yormaz
 * Created: 9/17/2024
 *
 *
 * **********************************************************************
 */

public class TC_001_ValidLogin extends BaseClass {

    @Test
    public void login(){
        try {
            logger.info("***** Starting login test at TC_001_Login *****");
            //Login Page -->
            logger.info("----- Entering correct credential to login from the config file... -----");
            LoginPage lp=new LoginPage(driver);
            lp.loginWithConfigFile();
            logger.info("----- Heading to Main Page... -----");
            MainPage mp=new MainPage(driver);
            String actualText= mp.mainPageTittle.getText();
            String expectedText="Products";
            logger.info("----- Confirming login is Successful via Main Page title 'Products'... -----");
            Assert.assertEquals(actualText,expectedText);
            logger.info("***** SUCCESS !!! *****");
            logger.info("***** Ending login test at TC_001_Login... *****");
        }
        catch (Exception e){
            Assert.fail();
            logger.info("***** login test at TC_001_Login FAILED because of an Exception !!! *****");
        }
    }

    @Test
    public void emptyAttemptLogin(){
        try{
            logger.info("***** Starting emptyAttemptLogin test at TC_001_Login !!! *****");
            //Login Page -->
            LoginPage lp=new LoginPage(driver);
            logger.info("----- Not Entering any credentials for both username and password... -----");
            lp.userNameBox.sendKeys("");
            lp.passwordBox.sendKeys("");
            lp.loginButton.click();
            logger.info("----- looking for the error message... -----");
            String actualErrorText=lp.errorMsg.getText();
            String expectedErrorText="Epic sadface: Username is required";
            logger.info("----- Verifying expected and actual error messages are matching... -----");
            Assert.assertEquals(actualErrorText,expectedErrorText);
            logger.info("***** SUCCESS !!! *****");
            logger.info("***** Ending emptyAttemptLogin test at TC_001_Login !!! *****");
        }
        catch (Exception e){
            Assert.fail();
            logger.info("***** emptyAttemptLogin test at TC_001_Login FAILED because of an Exception !!! *****");
        }
    }

    @Test
    public void wrongCredentialsLogin(){
        try {
            logger.info("***** Starting wrongCredentialLogin test at TC_001_Login !!! *****");
            //Login Page -->
            LoginPage lp=new LoginPage(driver);
            logger.info("----- Sending Incorrect credentials for both username and password... -----");
            lp.userNameBox.sendKeys("incorrect username");
            lp.passwordBox.sendKeys("incorrect password");
            lp.loginButton.click();
            logger.info("----- looking for the error message... -----");
            String actualErrorText=lp.errorMsg.getText();
            String expectedErrorText="Epic sadface: Username and password do not match any user in this service";
            logger.info("----- Verifying expected and actual error messages are matching... -----");
            Assert.assertEquals(actualErrorText,expectedErrorText);
            logger.info("***** SUCCESS !!! *****");
            logger.info("***** Ending wrongCredentialLogin test at TC_001_Login !!! *****");
        }

        catch (Exception e){
            Assert.fail();
            logger.info("***** wrongCredentialLogin test at TC_001_Login FAILED because of an Exception !!! *****");
        }
    }
}
