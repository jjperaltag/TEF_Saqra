/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package trazabilidadWeb.helpers;

import java.awt.*;
import java.io.IOException;

import trazabilidadWeb.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    private static WebDriver driver;
    public int defaultWaitingTime = 50;
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    public String stepTestName;
    protected Reports reporte = new Reports();


    //Este método se usa para aceptar los alert que aparezcan en los sites.
    public void checkAlert_Accept() throws Exception {
        try {

            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_En_Aceptar_Alert", driver);
            ScreenshotUtility.saveAccion("ERROR_En_Aceptar_Alert");
        }
    }


    //Este método ingresa el texto.
    public void doAddTextField(String UIName, String objTechName, String text, Boolean screenshot) throws IOException, AWTException {
        try {
            WebElement element = wait(objTechName);

            element.clear();
            element.sendKeys(text);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_En_Agregar_El_Texto_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_En_Agregar_El_Texto_" + UIName);
        }
    }

    //Método para hacer click al objeto.
    public void doClick(String UIName, String objTechName, Boolean screenshot) throws IOException, AWTException {
        try {
            WebElement element = wait(objTechName);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            element.click();
        } catch (AssertionError e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en hacer click", e);
            utilitarios.takeScreenshot("ERROR_Click_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Click_" + UIName);
        }
    }
       

    //*************JavaScript**************
    //*************JavaScript**************


    //Método para seleccionar objeto combo
    public void doSelectDropdown(String UIName, String objTechName, String Value, Boolean screenshot)
            throws IOException, AWTException {
        try {
            WebElement element = wait(objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(Value);
            //dropdown.selectByValue(Value);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (AssertionError e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en agregar texto", e);
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }
      /*funciona para RUC, PASAPORTE
        try {

            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            WebElement dropdownElement = driver.findElement(ObjectMap.getLocator(objTechName));
            wait.until(ExpectedConditions.visibilityOf(dropdownElement));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(Value);
            if (screenshot == true) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("Error en " + UIName, driver);


        }
    }*/

    //Método para elegir la opción index del combo
    public void doSelectDropDownByindex(String UIName, String objTechName, int data, Boolean screenshot) throws Exception {
        try {
            WebElement element = wait(objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByIndex(data);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }

    //Método para seleccionar el texto de la opción del elemento
    public void select(String UIName, String objTechName, String data) throws Exception {
        try {

            WebElement element = wait(objTechName);
            Select selectBox = new Select(element);

            selectBox.selectByVisibleText(data);
            utilitarios.takeScreenshot(UIName, driver);
            ScreenshotUtility.saveAccion(UIName);
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }

    //Método para cambiar de frame
    public void switchiframe(String UIName, String objTechName) throws IOException, AWTException {
        try {
            WebElement element = wait(objTechName);
            driver.switchTo().frame(element);
            utilitarios.takeScreenshot(UIName, driver);
            ScreenshotUtility.saveAccion(UIName);
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_switchFrame" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_switchFrame" + UIName);
        }
    }

    public void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public enum properties {
        DISPLAYED, VISIBLE, SELECTED;
    }

    //Valida que un objeto exista
    public boolean ValidateObject(String UIName, String objTechName, String PropertyToBeVerified) throws Exception {
        boolean ActualPropertyValue = false;
        String prop = PropertyToBeVerified.toUpperCase();
        try {
            WebElement element = wait(objTechName);

            switch (properties.valueOf(prop)) {
                case DISPLAYED:
                    ActualPropertyValue = element.isDisplayed();
                    break;
                case VISIBLE:
                    ActualPropertyValue = element.isEnabled();
                    break;
                case SELECTED:
                    ActualPropertyValue = element.isSelected();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!ActualPropertyValue) {
                utilitarios.takeScreenshot("ERROR_Validar_Objeto" + UIName, driver);
                ScreenshotUtility.saveAccion("ERROR_Validar_Objeto" + UIName);
                return false;
            }
        }
        if (ActualPropertyValue) {
            return true;
        }
        return false;
    }

    //Valida que el texto mostrado corresponda al texto comparado
    //No valida mayúsculas, ni minúsculas
    public boolean verifyText(String strText, String objTechName, String indice, Boolean screenshot) throws Exception {

        WebElement element = null;
        element = wait(objTechName);

        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            element = wait(objTechName);
            System.out.println("text:" + strText);
            System.out.println("text:" + element.getText());
            if (screenshot) {

                utilitarios.takeScreenshot("[Registro_" + indice + "]Validacion_Texto_" + strText, driver);
                ScreenshotUtility.saveAccion("[Registro_" + indice + "]Validacion_Texto_" + strText);
            }
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("[Registro_" + indice + "]ERROR_Este_Texto_No_Fue_Encontrado_" + strText, driver);
            ScreenshotUtility.saveAccion("[Registro_" + indice + "]ERROR_Este_Texto_No_Fue_Encontrado_" + strText);
        }
//        assert element != null;
        return element.getText().equalsIgnoreCase(strText);

    }

    //Método que obtiene el texto del label
    public String getlabel(String UIName, String objTechName) throws Exception {
        try {

            WebElement element = wait(objTechName);
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_obtenerTexto" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_obtenerTexto" + UIName);

        }
        return null;
    }

    //Verifica el contenido del texto
    public boolean verifyContainText(String strText, String objTechName) throws Exception {
       WebElement element = null;
       try {
            element = wait(objTechName);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error en metodo getlabel: ");
            utilitarios.takeScreenshot("ERROR_verificar_texto_contain", driver);
            ScreenshotUtility.saveAccion("ERROR_verificar_texto_contain");

        }
        return element.getText().contains(strText);

    }


    public WebElement returnWebElement(String objTechName) throws Exception {
        WebElement element = null;

        try {
           element = wait(objTechName);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error en metodo getlabel: ");
            utilitarios.takeScreenshot("ERROR_Retornar_WebElement", driver);
            ScreenshotUtility.saveAccion("ERROR_Retornar_WebElement");

        }

    return element;
    }

    public static WebDriver handleDriver() {
        return driver;
    }
        //*************JavaScript**************

    public void doclickByJS(String UIName, String objTechName, boolean screenshot) throws IOException, AWTException {

        try {
            WebElement   element =wait(objTechName);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            jse.executeScript("arguments[0].click()", element);
        } catch (AssertionError e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo el click del boton_js",e);
            utilitarios.takeScreenshot("ERROR_Click_JS_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Click_JS_" + UIName);
        }
    }

    public void jsScrollIntoView(String UIName, String objTechName, boolean screenshot) throws Exception {

        try {

            WebElement   element =wait(objTechName);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        } catch (Exception e) {
        e.printStackTrace();
        utilitarios.takeScreenshot("ERROR_ScrollDown_JS_" + UIName, driver);
        ScreenshotUtility.saveAccion("ERROR_ScrollDown_JS_" + UIName);
        }
    }
    public void refresh() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("location.reload()");
    }

    public WebElement wait(String objTechName)
    {
        WebDriverWait wait = new WebDriverWait(driver,defaultWaitingTime);
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    //Valida que un objeto exista
    public  boolean validateObject(String UIName, String objTechName, String PropertyToBeVerified, Boolean screenshot) throws Exception {
        boolean ActualPropertyValue = false;
        //   Thread.sleep(7000);
        String prop = PropertyToBeVerified.toUpperCase();
        try {

            if (screenshot) {
                utilitarios.takeScreenshot(UIName+" ", driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            WebElement element =wait(UIName,objTechName);
            // WebElement element =driver.findElement(By.xpath(objTechName));

            System.out.println("despues wait");

            switch (properties.valueOf(prop)) {

                case DISPLAYED:
                    System.out.println("en displayed");

                    ActualPropertyValue = element.isDisplayed();
                    break;
                case VISIBLE:
                    ActualPropertyValue = element.isEnabled();
                    break;
                case SELECTED:
                    ActualPropertyValue = element.isSelected();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_Validar_Objeto_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Validar_Objeto_" + UIName);
            Assert.fail("Fallo la validacion del objeto",e);

        }
        if (ActualPropertyValue) {
            return true;
        }
        return false;
    }

    public WebElement wait(String UIName, String objTechName) throws IOException, AWTException {
        WebDriverWait wait1 = new WebDriverWait(driver,defaultWaitingTime);
        WebElement element = null;

        try {
            element = wait1.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_En_wait" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_En_wait" + UIName);
            Assert.fail("Fallo la validacion del objeto",e);


        }
        return element;
    }

}
