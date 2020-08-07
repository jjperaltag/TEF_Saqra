package trazabilidadWeb.runner;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import java.io.File;


//@RunWith(Cucumber.class)
@CucumberOptions(
        //    features = "src/test/resources/feature/OpenCart.feature"
        features =  "src/test/resources/feature/FlujoConexion.feature" //Se ejecutaran todos los archivos features, por orden alfabetico segun especificado en el campo Feature.
        , plugin = {"com.cucumber.listener.ExtentCucumberFormatter:results/cucumber-reports/report.html",
        "junit:results/cucumber-reports/Cucumber.xml",
        "html:results/cucumber-reports"} //Formato de reporte generado por Cucumber
        , glue = {"trazabilidadWeb.tests"} //Ubicación package de la clase steps
        , tags = {"@SmokeTest"} //Filtra por tags los escenarios a ejecutar
        , dryRun = false //Verifica que todos los pasos en el feature esten implementados en los steps
        , monochrome = true //Muestra en consola el output de las pruebas de Cucumber
)

public class TestRunner extends AbstractTestNGCucumberTests {
//public class TestRunner {
@AfterClass
public static void writeExtentReport() {

    Reporter.loadXMLConfig(new File("./src/extent-config.xml"));
//    Reporter.loadXMLConfig(new File("D:\\Automation\\FrWk_BDD_OpenCart_BK\\BK4\\FrWk_BDD_OpenCart\\src\\extent-config.xml"));
}


    class UsersRunner<Karate> {
        @Karate.Test
        Karate testUsers() {
            return Karate.run("classpath:Triaje/Flujos/FlujoConexion.feature").tags("@SmokeTest").relativeTo(getClass());
        }}



}

// Ejecución Cucumber