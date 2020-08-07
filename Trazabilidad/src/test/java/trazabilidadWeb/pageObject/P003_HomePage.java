/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package trazabilidadWeb.pageObject;

import java.awt.*;
import java.io.IOException;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import trazabilidadWeb.helpers.BasePage;
import trazabilidadWeb.helpers.Hook;

public class P003_HomePage extends BasePage {

	public final String lbl_NombreProducto_Reagendar ="//*[@id=\"lbl-name-schedulehome\"]";
	public  final String lbl_NombreUsuario = "//*[@id=\"lbl-name-header\"]";

	public  final String lbl_NombreProducto = "//*[@id=\"lbl-name-product\"]";

	public  final String lbl_StatusTracking = "|id|lbl-status-tracking";

	public  final String btn_AgendarPedido = "|id|btn-schedule-product";
	public  final String btn_AgendarP = "//button[@id='btn-schedule-product']";
	public  final String btn_Reagendar = "//*[@id=\"btn-schedul-schedulehome\"]";

	public final String lbl_dia_instalacion = "//*[@id=\"lbl-date-schedulehome\"]";


	public final String btn_Menu = "//*[@id=\"img-menu-header\"]";

	public final String btn_CerrarSesion = "//*[@id=\"lbl-logout-menu\"]";
    public final String btn_VerPedidoAA = "/html//button[@id='btn-getschedule-boxproduct']";

	//codigo celeste cambiar contacto
	public final String btn_cambiarContacto = "//*[@id=\"lbl-contact-home\"]";
	public final String btn_continuar = "|id|btn-enter-token";

    public final String lbl_notificacion = "//*[@id=\"lbl-error-login\"]";

	public final String btn_continuar_token = "|id|btn-continue-login";

	public final String btn_CancelarPedidoAA = "//a[@id='lnk-cancel-home']";

	public final String btn_home = "/html//img[@id='img-status-tracking']";

	public boolean doValidarUsuario(String sUsuario, String indice) throws Exception {
		validateObject("Registro_"+indice+"_Validar existencia de Label NombreUsuario",lbl_NombreUsuario,"DISPLAYED", true);
		return verifyText(sUsuario,lbl_NombreUsuario,indice,true);
	}

	public boolean doValidarNombreProducto(String sProducto, String indice) throws Exception {
		validateObject("Registro_"+indice+"_Validar existencia de Label NombreProducto",lbl_NombreProducto,"DISPLAYED", true);
		System.out.println("spro:"+sProducto);
		System.out.println("spro2:"+lbl_NombreProducto.toString());

		return verifyText(sProducto, lbl_NombreProducto, indice,true);
	}
	public boolean doValidarStatusAgendamiento(String sStatusAgendamiento, String indice) throws Exception {
		validateObject("Registro_"+indice+"_Validar existencia de Label Status",lbl_StatusTracking,"DISPLAYED", true);
		return verifyText(sStatusAgendamiento,lbl_StatusTracking, indice,true);
	}



	public void doAgendarPedido(String indice) throws Exception, IOException, InterruptedException, AWTException {
		//validateObject("Registro_"+indice+"_Validar existencia de Boton AgendarPedido",btn_AgendarPedido,"DISPLAYED", true);
		Thread.sleep(5000);
		doClick( "[Registro_"+indice+"]Click_Agendar_Pedido",  btn_AgendarPedido,  true);

	}


    public void doReagendarPedido(String indice) throws Exception, IOException, InterruptedException, AWTException {
		//validateObject("Registro_"+indice+"_Validar existencia de Boton Reagendar",btn_Reagendar,"DISPLAYED", true);
		Thread.sleep(5000);
		doClick( "[Registro_"+indice+"]Click_Reagendar_Pedido",  btn_Reagendar,  true);

    }

    //CAMBIO DE CONTACTO
    public void doCambiarContacto(String indice) throws Exception, IOException, InterruptedException, AWTException{
		validateObject("Registro_"+indice+"_Validar existencia de Boton CambiarContacto",btn_cambiarContacto,"DISPLAYED", true);
		doClick( "[Registro_"+indice+"]Click_Cambiar_Contacto",  btn_cambiarContacto,  true);
	}
	//////-----------------------------------------------
    public boolean doValidarNombreProducto_Reagendar(String sProducto, String indice) throws Exception {
		validateObject("Registro_"+indice+"_Validar existencia de Label Nombre_Producto_Reagendar",lbl_NombreProducto_Reagendar,"DISPLAYED", true);
		return verifyText(sProducto,lbl_NombreProducto_Reagendar, indice,true);

	}


	public String getFechaInstalacion() throws Exception {
		validateObject("Registro Validar existencia de Label Dia_instalacion",lbl_dia_instalacion,"DISPLAYED", true);
		System.out.println("getfecha:"+getlabel("ObtenerFecha_Dia", lbl_dia_instalacion));
		return getlabel("ObtenerFecha_Dia", lbl_dia_instalacion);
	}

	public void doLogOut(String indice) throws Exception {
		validateObject("Registro_"+indice+"_Validar existencia de Boton CerrarSesion",btn_CerrarSesion,"DISPLAYED", true);
		doClick( "[Registro_"+indice+"]Click_Menu",  btn_Menu,  true);
		doClick( "[Registro_"+indice+"]Click_CerrarSesion",  btn_CerrarSesion,  true);
	}
	public void doLogHome(String indice) throws Exception {
		doClick("[Registro_" + indice + "]Click_Menu", btn_Menu, true);

	}

    public void doLog_HOME(String indice) throws Exception {
        try{
            if (btn_AgendarP.isEmpty()) {
				System.out.println("1");
                doClick("Click_en_Ver_Pedido", btn_VerPedidoAA, true);
                Thread.sleep(5000);
                doClick("[Registro_" + indice + "]Click_Menu", btn_Menu, true);
                Thread.sleep(3000);
                doClick("[Registro_" + indice + "]Click_CerrarSesion", btn_CerrarSesion, true);

            }
            // if(btn_AgendarP.length()>0){
            if(!btn_AgendarP.isEmpty()){
				System.out.println("2");
                Thread.sleep(5000);
                doClick("Home", btn_Menu, true);
                Thread.sleep(3000);
                doClick("[Registro_" + indice + "]Click_CerrarSesion", btn_CerrarSesion, true);
         }}     catch (Exception e){
        e.printStackTrace();
    }}

	public void doVerPedido(String indice) throws Exception {
		try {
			if (btn_VerPedidoAA.length() > 0) {
				Thread.sleep(1000);
				doClick("Click_en_Ver_Pedido", btn_VerPedidoAA, true);
				Thread.sleep(1000); }
			if (btn_VerPedidoAA.isEmpty()) {

			}
		}
		catch (Exception e){
			e.printStackTrace();
		}}



}