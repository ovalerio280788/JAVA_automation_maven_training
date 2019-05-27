package org.automation.locators;

import org.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardLocators extends PageObjectBase {
    public DashBoardLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/admin/logout/']")
    protected WebElement logOutElementElement;

    @FindBy(css="[href='/admin/password_change/']")
    protected WebElement changePasswordElement;

}
