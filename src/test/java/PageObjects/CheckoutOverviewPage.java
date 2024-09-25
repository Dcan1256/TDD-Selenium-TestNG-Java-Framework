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
 * Method Name: CheckoutOverviewPage
 *
 * Description:
 *     Contains WebElements and Actions methods for CheckoutOverviewPage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for CheckoutOverviewPage
 *
 * **********************************************************************
 */
public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements ------------------------------------------------------------------------
    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement checkoutOverviewTitle;

    @FindBy (xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartLogo;

    @FindBy (xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    public WebElement itemTotalPrice;

    @FindBy (xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    public WebElement taxTotal;

    @FindBy (xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    public WebElement finalTotalPrice;

    @FindBy (xpath = "//*[@id=\"cancel\"]")
    public WebElement cancelButton;

    @FindBy (xpath = "//*[@id=\"finish\"]")
    public WebElement finishButton;
    //Action Methods ----------------------------------------------------------------------
}
