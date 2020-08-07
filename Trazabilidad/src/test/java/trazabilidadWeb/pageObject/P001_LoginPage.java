/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package trazabilidadWeb.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import trazabilidadWeb.helpers.BasePage;
import trazabilidadWeb.helpers.Hook;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class P001_LoginPage extends BasePage {

	WebDriver driver;
	////*[@id="loginWeb"]/div/div[2]/div/div[1]/div
	//|id|sel-doctype-login
	public final String cob_tipoDocumento = "//*[@id=\"sel-doctype-login\"]";
	public final String cob_DNI = "//*[@id=\"menu-\"]/div[3]/ul/li[1]";
	public final String cob_Carnet_de_extranjería = "//*[@id=\"menu-\"]/div[3]/ul/li[2]";
	public final String cob_RUC = "//*[@id=\"menu-\"]/div[3]/ul/li[3]";
	public final String cob_Pasaporte = "//*[@id=\"menu-\"]/div[3]/ul/li[4]";
	public final String cob_PTP = "//*[@id=\"menu-\"]/div[3]/ul/li[5]";
	public final String txt_numDocumento = "//input[@id='txt-docnumber-login']";
	public final String btn_continuar = "|id|btn-continue-login";
	//public final String lbl_notificacion = "//*[@id=\"lbl-error-login\"]";
	public final String lbl_notificacion = "//*[@id=\"lbl-error-login\"]";


	public final String btn_continuar_token = "|id|btn-enter-token";


	public final String lnk_reenviar = "//a[@id='lnk-resend-token']";


	public final String txt_smsDigito1 = "|id|item1";



	public void doLogin(String sTipoDocumento, String sNumDocumento, String sNombreUsuario, String indice) throws Exception, IOException, AWTException {

		try {
			// Valida que el DNI tenga 8 dígitos
			if (sTipoDocumento.equals("DNI") && sNumDocumento.length() == 8) {
				doClick("Front_de_Trazabilidad", cob_tipoDocumento, true);
				Thread.sleep(2000);
				doClick("Seleccionar_Tipo_de_Documento", cob_DNI, true);
				Thread.sleep(2000);
				doAddTextField("Ingresar_Número_de_Documento", txt_numDocumento, sNumDocumento, true);
				Thread.sleep(2000);
				doClick("Click_en_Botón_CONTINUAR", btn_continuar, true);

			}

			// Valida que el Carnet de extranjería tenga 12 dígitos y culmine en A
			if (sTipoDocumento.equals("Carnet de extranjeria") && sNumDocumento.length() == 12 && sNumDocumento.endsWith("A")) {
				doClick("Front_de_Trazabilidad", cob_tipoDocumento, true);
				Thread.sleep(2000);
				doClick("Seleccionar_Tipo_de_Documento", cob_Carnet_de_extranjería, true);
				Thread.sleep(2000);
				doAddTextField("Ingresar_Número_de_Documento", txt_numDocumento, sNumDocumento, true);
				Thread.sleep(2000);
				doClick("Click_en_Botón_CONTINUAR", btn_continuar, true);
			}

			// Valida que el RUC tenga 11 dígitos y empiece con 10
			if (sTipoDocumento.equals("RUC") && sNumDocumento.length() == 11 && sNumDocumento.startsWith("10")) {
				doClick("Front_de_Trazabilidad", cob_tipoDocumento, true);
				Thread.sleep(2000);
				doClick("Seleccionar_Tipo_de_Documento", cob_Carnet_de_extranjería, true);
				Thread.sleep(2000);
				doAddTextField("Ingresar_Número_de_Documento", txt_numDocumento, sNumDocumento, true);
				Thread.sleep(2000);
				doClick("Click_en_Botón_CONTINUAR", btn_continuar, true);
			}

			// Valida que el Pasaporte tenga 12 dígitos y culmine en A --&& sNumDocumento.endsWith("A")
			if (sTipoDocumento.equals("Pasaporte") && sNumDocumento.length() == 12) {
				doClick("Front_de_Trazabilidad", cob_tipoDocumento, true);
				Thread.sleep(2000);
				doClick("Seleccionar_Tipo_de_Documento", cob_Carnet_de_extranjería, true);
				Thread.sleep(2000);
				doAddTextField("Ingresar_Número_de_Documento", txt_numDocumento, sNumDocumento, true);
				Thread.sleep(2000);
				doClick("Click_en_Botón_CONTINUAR", btn_continuar, true);
			}

			// Valida que PTP tenga 9 dígitos
			if (sTipoDocumento.equals("PTP") && sNumDocumento.length() == 9) {
				doClick("Front_de_Trazabilidad", cob_tipoDocumento, true);
				Thread.sleep(2000);
				doClick("Seleccionar_Tipo_de_Documento", cob_Carnet_de_extranjería, true);
				Thread.sleep(2000);
				doAddTextField("Ingresar_Número_de_Documento", txt_numDocumento, sNumDocumento, true);
				Thread.sleep(2000);
				doClick("Click_en_Botón_CONTINUAR", btn_continuar, true);
			}

			} catch (Exception e){
				e.printStackTrace();
			}}

	public void doResultado() throws Exception {
		try {/*
		Thread.sleep(4000);
		if (lbl_notificacion.isEmpty()) {
			System.out.println("1");
			//doClick("Resultado_de_la_validación", txt_numDocumento, false);
			System.out.println("Resultado: El documento ingresado tiene un pedido o reporte de avería registrado");
			//System.out.println("El documento ingresado tiene un pedido o reporte de avería registrado");
		}
		if (lbl_notificacion.length()>0) {
			System.out.println("2");
			//doClick("Resultado_de_la_validación", btn_continuar, true);
			doClick("Resultado_de_la_validación", txt_numDocumento, true);
			System.out.println("Resultado: El documento ingresado no tiene un pedido o reporte de avería registrado");
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail();
		}*/


		/*

		if (btn_continuar_token.length()!=0) {
				System.out.println("1");
				//doClick("Resultado_de_la_validación", txt_numDocumento, false);
				System.out.println("Resultado: El documento ingresado tiene un pedido o reporte de avería registrado");
				//System.out.println("El documento ingresado tiene un pedido o reporte de avería registrado");}
			}
			if (btn_continuar.size()=0){
			System.out.println("2");
			//doClick("Resultado_de_la_validación", btn_continuar, true);
			doClick("Resultado_de_la_validación", txt_numDocumento, true);

			System.out.println("Resultado: El documento ingresado no tiene un pedido o reporte de avería registrado");
			Hook.closeBrowser(BasePage.handleDriver());
			System.out.println("antes");
			Assert.fail();
		 */



			//btn_continuar_token.isEmpty() && lnk_reenviar.isEmpty()
/*if(!btn_continuar.isEmpty() && !txt_numDocumento.isEmpty())
{
	System.out.println("2");
	//doClick("Resultado_de_la_validación", btn_continuar, true);
	doClick("Resultado_de_la_validación", txt_numDocumento, true);

	System.out.println("Resultado: El documento ingresado no tiene un pedido o reporte de avería registrado");
	Hook.closeBrowser(BasePage.handleDriver());
	Assert.fail();
} */
		if(!btn_continuar.isEmpty() && !txt_numDocumento.isEmpty() && !lnk_reenviar.isEmpty()) {
			//validateObject("Resultado_de_la_validación",lbl_notificacion,"DISPLAYED", true);
			System.out.println("1");
			}
// if(!btn_continuar.isEmpty() && !txt_numDocumento.isEmpty()){
			if(!lbl_notificacion.isEmpty()){
				System.out.println("2");
			//doClick("Resultado_de_la_validación", btn_continuar, true);
			//doClick("Resultado_de_la_validación", txt_numDocumento, true);
			//validateObject("Resultado_de_la_validación",lbl_notificacion,"DISPLAYED", true);
			Hook.closeBrowser(BasePage.handleDriver());
			// Assert.fail();

		}

	} catch (Exception e){
		e.printStackTrace();
	}}}