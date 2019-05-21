package org.automation.testcases.sesion1suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Session1Practica {
    private WebDriver driver;
    private String appUrl = "http://127.0.0.1:9000/admin";

    @BeforeMethod
    public void beforeMethod() {
        driver = new InternetExplorerDriver();
        driver.get(appUrl);
    }

    /**
     * Crear un test case que use todas las interacciones con el driver que vimos y que se listan comentadas dentro del
     * test case
     */
    @Test
    public void TestDriverActions() {
        // .get()
        //.getCurrentUrl()
        //getTitle()
        //getPageSource()
        //findElement()
        //findElements()
        //close()
        //quit()
        //getWindowHandle()
        //getWindowHandles()
        //swithTo()
        //navigateTo()
        //manage()
    }

    /**
     * Crear un test case que use todas las acciones con los elementos que vimos y que se listan comentadas dentro del
     * test case
     */
    @Test
    public void TestElementActions() {
        // .click()
        //.sendKeys()
        //.clear()
        //.getText()
        //.getTagName()
        //.getLocation()
        //.isSelected()
        //.isDisplayed()
        //.isEnabled()
        //.getAttribute()
    }

    /**
     * Crear un test case que haga login exitoso en la url http://127.0.0.1:9000/admin/ y verificar que si se logueo
     * correctamente
     */
    @Test
    public void TestSuccessLogin() {

    }

    /**
     * Crear un test case que haga login invalido en la url http://127.0.0.1:9000/admin/ y verificar que aun sigue en
     * la pagina de login
     */
    @Test
    public void TestInvalidLogin() {

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
