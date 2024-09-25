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
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import testBase.BaseClass;

import java.util.List;

/**
 * **********************************************************************
 * Method Name: YourCartPage
 *
 * Description:
 *     Contains WebElements and Actions methods for YourCartPage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for YourCartPage
 *
 * **********************************************************************
 */
public class YourCartPage extends BasePage {
    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements ------------------------------------------------------------------------
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement cartPageTitle;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartIcon;

    @FindAll(@FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]//div[contains(@class, 'cart_item')]/div[2]/div[2]/div"))
    public List<WebElement> prices;

    @FindAll(@FindBy(xpath = "//*[@id=\"cart_contents_container\"]//button[starts-with(@id, 'remove-')]"))
    public List<WebElement> removeButtons;

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    public WebElement checkoutButton;
    //Action Methods ----------------------------------------------------------------------
}
