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

import java.util.List;

/**
 * **********************************************************************
 * Method Name: MainPage
 *
 * Description:
 *     Contains WebElements and Actions methods for MainPage
 *
 *
 * Usage:
 *     Retrieving WebElements or Performing action methods for MainPage
 *
 * **********************************************************************
 */
public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements ------------------------------------------------------------------------
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement mainPageTittle;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    public WebElement sortingDropDown;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    public WebElement burgerButton;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    public WebElement logoutLink;

    @FindAll(@FindBy(xpath = "//button[@class and text()='Add to cart']"))
    List<WebElement> addToCartButtonsList;

    @FindAll(@FindBy(xpath = "//button[@class and text()='Remove']"))
    List<WebElement> removeFromCartButtonsList;
    //Action Methods ----------------------------------------------------------------------
    public void addAll(){
        for(WebElement element:addToCartButtonsList){
            element.click();
        }
    }

    public void removeAll(){
        for(WebElement element:removeFromCartButtonsList){
            element.click();
        }
    }

}
