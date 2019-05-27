package org.automation.testcases.webdrivermethodsactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Ejemplo {
    private WebDriver driver;
    private String appUrl = "http://127.0.0.1:9000/admin";

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        // manage().deleteAllCookies()
        System.out.println("Método 'manage().deleteAllCookies()'");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // get()
        System.out.println("Método 'get()'");
        driver.get(appUrl);
    }

    /**
     * Crear un test case que use todas las interacciones con el driver que vimos y que se listan comentadas dentro del
     * test case
     */
    @Test
    public void TestDriverActions() throws InterruptedException {
        //.getCurrentUrl()
        System.out.println("Método 'getCurrentUrl()': ".concat(driver.getCurrentUrl()));

        //getTitle()
        System.out.println("Método 'getTitle()': ".concat(driver.getTitle()));

        //getPageSource()
        System.out.println("Método 'getPageSource()': ".concat(driver.getPageSource()));

        //findElement()
        WebElement userName = driver.findElement(By.id("id_username"));
        WebElement userPassword = driver.findElement(By.name("password"));
        System.out.println("Método 'findElement()': ".concat(String.valueOf(userName)));
        System.out.println("Método 'findElement()': ".concat(String.valueOf(userPassword)));

        //findElements()
        List<WebElement> elementos = driver.findElements(By.tagName("input"));
        System.out.println("Método 'findElements()' -- total de coincidencias: ".concat(String.valueOf(elementos.size())));

        for (WebElement element : elementos) {
            System.out.println(element.getTagName());
        }

        System.out.println("Nos logueamos en la aplicacion y navegamos a 'admin/filer/folder/'");
        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));

        // sendKeys()
        System.out.println("Método 'sendKeys()'");
        userName.sendKeys("automation");
        userPassword.sendKeys("Automation123$");

        // submit()
        System.out.println("Método 'submit()'");
        submitBtn.submit();
        driver.navigate().to("http://127.0.0.1:9000/admin/filer/folder/");
        WebElement newFolderBtn = driver.findElement(By.xpath("//a[contains(text(),'New Folder')]"));

        // getWindowHandle()
        String windowHandleBase = driver.getWindowHandle();
        System.out.println("Método 'getWindowHandle()': ".concat(driver.getWindowHandle()));

        // getWindowHandles()
        System.out.println("Método 'getWindowHandles()': ".concat(String.valueOf(driver.getWindowHandles().size())));

        // click()
        System.out.println("Método 'click()'");
        newFolderBtn.click();

        // getWindowHandle()
        System.out.println("Método 'getWindowHandle()': ".concat(driver.getWindowHandle()));

        // getWindowHandles()
        System.out.println("Método 'getWindowHandles()': ".concat(String.valueOf(driver.getWindowHandles().size())));

        // switchTo()
        System.out.println("Método 'switchTo()': ");
        for (String currentWindow : driver.getWindowHandles()) {
            if (driver.switchTo().window(currentWindow).getTitle().equals("Add new folder | Django site admin")){
                break;
            }
        }

        // getWindowHandle()
        System.out.println("Método 'getTitle()': ".concat(driver.getTitle()));
        System.out.println("Método 'getWindowHandle()': ".concat(driver.getWindowHandle()));

        // isDisplayed()
        WebElement folderName = driver.findElement(By.cssSelector("#folder_form #id_name"));
        System.out.println("Método 'isDisplayed()': ".concat(String.valueOf(folderName.isDisplayed())));
        folderName.sendKeys("Nombre de ");
        folderName.sendKeys("ejemplo");
        folderName.clear();
        folderName.sendKeys("Nombre de ejemplo");


        //close()
        System.out.println("Método 'close()': ");
        driver.close();
        driver.switchTo().window(windowHandleBase);

        // getWindowHandle()
        System.out.println("Método 'getTitle()': ".concat(driver.getTitle()));
        System.out.println("Método 'getWindowHandle()': ".concat(driver.getWindowHandle()));

        // getText()
        WebElement foldersSeleccionados = driver.findElement(By.cssSelector(".action-counter"));
        System.out.println("Método 'getText()' -- Folders seleccionados = ".concat(foldersSeleccionados.getText()));

        // getLocation()
        System.out.println("Método 'getLocation()' -- Folders seleccionados 'location' = ".concat(String.valueOf(foldersSeleccionados.getLocation())));

        // isEnabled()
        System.out.println("Método 'isEnabled()' -- 'New Folder isEnabled' = ".concat(String.valueOf(newFolderBtn.isEnabled())));
        WebElement copyElement = driver.findElement(By.cssSelector("#content .fa-copy"));
        System.out.println("Método 'isEnabled()' -- 'New Folder isEnabled' = ".concat(String.valueOf(newFolderBtn.isEnabled())));
        System.out.println("Método 'isEnabled()' -- 'Copy isEnabled' = ".concat(String.valueOf(copyElement.isEnabled())));

        // getAttribute()
        WebElement actionsWrapper = driver.findElement(By.cssSelector(".actions-wrapper"));
        if(actionsWrapper.getAttribute("class").contains("action-selected") ){
            System.out.println("Las opciones de copiar y cortar estan activas");
        }else{
            System.out.println("Las opciones de copiar y cortar NO estan activas");
        }

        WebElement copyAncestor = copyElement.findElement(By.xpath("./ancestor::a[position()=1]"));
        System.out.println("Método 'getAttribute()' -- 'actionsWrapper getAttribute title' = ".concat(String.valueOf(copyAncestor.getAttribute("title"))));
    }

    /**
     * Crear un test case que use todas las acciones con los elementos que vimos y que se listan comentadas dentro del
     * test case
     */
    @Test
    public void TestElementActions() {
        //.getText()
        //.getLocation()
        //.isSelected()
        //.isDisplayed()
        //.isEnabled()
        //.getAttribute()
    }

    @AfterMethod
    public void afterMethod() {
        //quit()
        System.out.println("Cerrando todas la ventanas abiertas, cerrando el driver.");
        driver.quit();
    }
}
