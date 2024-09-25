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

/**
 * **********************************************************************
 * Method Name: CheckoutCompletePage
 *
 * Description:
 *     Contains WebElements and Actions methods for CheckoutCompletePage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for CheckoutCompletePage
 *
 * **********************************************************************
 */
public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    //Web Elements ------------------------------------------------------------------------
    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement checkoutCompleteTitle;

    @FindBy (xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    public WebElement orderSuccessText;

    @FindBy (xpath = "//*[@id=\"back-to-products\"]")
    public WebElement backHomeButton;

    //Action Methods ----------------------------------------------------------------------
}
