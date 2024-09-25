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
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;


public class BasePage {

    WebDriver driver;

    /**
     * **********************************************************************
     * Method Name: BasePage
     *
     * Description:
     *     Application of PageFactory Model to all PageClasses under the project, this will
     *     make WebElement initialization cleaner at PageClasses.
     *
     * Usage:
     *      Application of PageFactory Model to the all PageClasses under the project.
     *
     * **********************************************************************
     */
    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
