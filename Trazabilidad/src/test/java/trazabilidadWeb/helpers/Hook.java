/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package trazabilidadWeb.helpers;

import gherkin.formatter.model.Scenario;
import trazabilidadWeb.utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Hook {
    public WebDriver driver;
    public BasePage basePage;
    Scenario sce;

    /**
     * Borra todos los coockies e instancia el browser indicado
     */
    public  WebDriver  setUp(String sbrowser, String strURL) throws Exception {

        System.out.println("scenario:");
        String sCarpAct = "./results/screenshot/";
        ScreenshotUtility.cleanScreenshot(sCarpAct);
        boolean browserFound = true;
        if (sbrowser.toUpperCase().equals("FIREFOX")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if (sbrowser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            driver = new ChromeDriver();
        } else if (sbrowser.toUpperCase().equals("IE")) {
            System.setProperty("webdriver.ie.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            browserFound = false;
        }
        if (browserFound) {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(strURL);
            basePage = new BasePage();
            basePage.setWebDriver(driver);
            System.out.println("Browser Inicializado"+driver.getTitle());
            return driver;
        } else {
            return null;
        }
    }

    /**
     * Cierra el browser y termina la sesion del WebDriver
     */

   public static void closeBrowser(WebDriver iDriver) throws Exception {
        generarWordFile();
     //   iDriver.quit();
    }

    public static void generarWordFile() throws Exception {
        String sCarpAct = "./results/screenshot/";
        List<String> listScreen = ScreenshotUtility.listScreenshot(sCarpAct);
        if (listScreen != null && listScreen.size() > 0) {

            WordUtils.createDoc("Alta trío Movistar Play", listScreen);
        } else {
            System.out.println("No hay Data");
        }


    }

}