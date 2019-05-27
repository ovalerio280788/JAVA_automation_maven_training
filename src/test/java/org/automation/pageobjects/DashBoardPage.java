package org.automation.pageobjects;

import org.automation.locators.DashBoardLocators;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends DashBoardLocators {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangePasswordDisplayed(){
        return this.getBot().isElementDisplayed(this.changePasswordElement);
    }

    public boolean isLogOutDisplayed(){
        return this.getBot().isElementDisplayed(this.logOutElementElement);
    }
}
