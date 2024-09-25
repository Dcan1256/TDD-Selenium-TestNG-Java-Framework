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
 * Method Name: CheckoutInfoPage
 *
 * Description:
 *     Contains WebElements and Actions methods for CheckoutInfoPage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for CheckoutInfoPage
 *
 * **********************************************************************
 */
public class CheckoutInfoPage extends BasePage{

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }


    //Web Elements ------------------------------------------------------------------------
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    public WebElement zipCodeBox;

    @FindBy(xpath = "//*[@id=\"cancel\"]")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement checkoutInfoTitle;

    //Action Methods ----------------------------------------------------------------------

    public void fillCheckoutInfo(String firstName, String lastName, String zipCode){
        firstNameBox.sendKeys(firstName);
        lastNameBox.sendKeys(lastName);
        zipCodeBox.sendKeys(zipCode);
        continueButton.click();
    }
}
