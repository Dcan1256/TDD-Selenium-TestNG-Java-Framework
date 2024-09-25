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

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ResourceBundle;


/**
 * **********************************************************************
 * Method Name: LoginPage
 *
 * Description:
 *     Contains WebElements and Actions methods for LoginPage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for LoginPage
 *
 * **********************************************************************
 */
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements ------------------------------------------------------------------------

    //UserName Box
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    public WebElement userNameBox;

    //Password Box
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox;

    //Login Button
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    public WebElement errorMsg;

    //Action Methods ----------------------------------------------------------------------
    public void loginWithConfigFile(){
        ResourceBundle config=ResourceBundle.getBundle("config");

        userNameBox.sendKeys(config.getString("username"));
        passwordBox.sendKeys(config.getString("pwd"));
        loginButton.click();
    }

    public void login(String username, String password) {
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
