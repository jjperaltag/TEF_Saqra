package trazabilidadWeb.pageObject;

import org.openqa.selenium.WebDriver;
import trazabilidadWeb.helpers.BasePage;

import java.awt.*;
import java.io.IOException;

public class P010_CancelBeforeScheduling extends BasePage {

    // Ver pedido AA
    public final String btn_VerPedidoAA = "/html//button[@id='btn-getschedule-boxproduct']";
    // Cancelar pedido AA
    public final String btn_CancelarPedidoAA = "//a[@id='lnk-cancel-home']";
    public final String btn_AgendarPedido = "//button[@id='btn-schedule-product']";


    // Radio Botton
    public final String rb_1 = "//label[@id='lbl-item1-cancel']";
    public final String rb_2 = "//label[@id='lbl-item2-cancel']";
    public final String rb_3 = "//label[@id='lbl-item3-cancel']";

    public final String txt_area = "//textarea[@id='txt-reason-cancel']";

    // Cancelación AA
    public final String btn_CancelarAg = "/html//button[@id='btn-cancelorder-cancel']";
            //button[@id='btn-cancelorder-cancel']";


    //Confirmación de cancelación
    public final String btn_ConfiCancAA = "//button[@id='btn-accept-confirmation']";

    WebDriver driver;

public void doCancelar_AA(String indice) throws IOException, AWTException {
    doClick("Click_en_Cancelar_Pedido_Antes_de_Agendamiento", btn_CancelarPedidoAA, true);
}

    public void doVerPedidoAA(String indice) throws Exception {
        try {

            if (btn_VerPedidoAA.length() > 0) {
                Thread.sleep(1000);
                doClick("Click_en_Ver_Pedido", btn_VerPedidoAA, true);
                Thread.sleep(1000);
                if (btn_AgendarPedido.length() > 0) {
                    jsScrollIntoView("Click_en_Ver_Pedido", btn_CancelarPedidoAA, true);
                    Thread.sleep(1000);
                    doClick("Click_en_Cancelar_Pedido_Antes_de_Agendamiento", btn_CancelarPedidoAA, true);
                }
                if (btn_AgendarPedido.length() < 0) {
                    // Assert.fail();}}
                }

                if (btn_CancelarPedidoAA.length() > 0) {
                    jsScrollIntoView("Click_en_Ver_Pedido", btn_VerPedidoAA, true);
                    Thread.sleep(1000);
                    doClick("Click_en_Cancelar_Pedido_Antes_de_Agendamiento", btn_CancelarPedidoAA, true);
                }

                Thread.sleep(1000);
                doClick("Click_en_Cancelar_Pedido_Antes_de_Agendamiento", btn_CancelarPedidoAA, true);

            } else {
                jsScrollIntoView("Click_en_Ver_Pedido", btn_VerPedidoAA, true);

                Thread.sleep(1000);
                doClick("Click_en_Cancelar_Pedido_Antes_de_Agendamiento", btn_CancelarPedidoAA, true);
            }
        }
          catch (Exception e){
            e.printStackTrace();
        }}





/*
    public void doCancelarPedidoAA(String indice) throws Exception {
		/*
		Thread.sleep(3000);
		jsScrollIntoView("Click en Cancelar pedido AA", btn_CancelarPedidoAA, true);
		Thread.sleep(4000);
		doClick("[Registro_" + indice + "]Click_Cancelar_PedidoAA", btn_CancelarPedidoAA, true);
    }
*/

    public void doComboPedidoCancelarAA(String indice, String sUri, String sCancelarAA, String sTipo_Cancelacion, String sMotivoAA) {
        try {
            Thread.sleep(3000);
            if (sTipo_Cancelacion.equals("1")) {
                Thread.sleep(3000);
                doClick("Seleccionar_No_Solicité_el_Pedido", rb_1, true);

                jsScrollIntoView("Seleccionar_Ya_No_Deseo_el_Pedido", rb_1, false);
            }

            if (sTipo_Cancelacion.equals("2")) {
                Thread.sleep(1000);
                doClick("Seleccionar_Ya_No_Deseo_el_Pedido", rb_2, true);
                Thread.sleep(3000);
                jsScrollIntoView("Seleccionar_Ya_No_Deseo_el_Pedido", rb_2, false);
                //System.out.println(sCancelarAA);
                //Thread.sleep(1000);
            }

            if (sTipo_Cancelacion.equals("3")) {
                Thread.sleep(1000);
                doClick("Seleccionar_Otro_Motivo_(Especificar)", rb_3, true);
                jsScrollIntoView("Seleccionar_Otro_Motivo_(Especificar)", txt_area, false);
                Thread.sleep(3000);
                Thread.sleep(1000);
                doAddTextField("Agregar_el_Detalle_de_la_Cancelación", txt_area, sMotivoAA, true);
            }



        } catch (Exception e){
            e.printStackTrace();
        }}












/* Anterior
	public void doComboPedidoCancelarAA(String indice, String sURI, String sCancelarAA) throws IOException {
		try {


			//Thread.sleep(500);

			doClick("[Registro_" + indice + "]Click_No solicité el pedido", rb_1, true);
			//System.out.print(sCancelarAA);
			//Thread.sleep(1000);

			doClick("[Registro_" + indice + "]Click_Ya no deseo el pedido", rb_2, true);
			//System.out.println(sCancelarAA);
			//Thread.sleep(1000);

			doClick("[Registro_" + indice + "]Click_Otro motivo (Especificar)", rb_3, true);
			//System.out.println(sCancelarAA);

			jsScrollIntoView("Click en ver pedido AA", txt_area, false);
			Thread.sleep(1000);

			doAddTextField("Ingresar_Detalle del motivo", txt_area, sCancelarAA, true);


			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

 */
/*
public void doConfCancelarAA(String indice, String sURI,String sCancelarAA) throws IOException, AWTException, InterruptedException {


	//WebElement thanksContactUsPage = driver.findElement(By.xpath("//span[@id='lbl-title-confirmation']"));
	//WaitUntilWebElementIsVisible(thanksContactUsPage);
	//Assert.assertEquals("Tupedidohasidocancelado", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
	//return doConfCancelarAA();


	WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), '')]"));
	Assert.assertEquals(true, askQuestionButton.isDisplayed());
	driver.close();

	try {
		Thread.sleep(3000);
		doClick("Cancelar Pedido", btn_CancelarAg, true);
		doClick("Cancelar Pedido", btn_ConfiCancAA, true);


		Thread.sleep(7000);
		MongoDBUtils2 MongoDBUtils2 = new MongoDBUtils2();
		String sCollection = "collProvision";
		String sValorConsulta = "Tu pedido ha sido cancelado";
		Boolean value = MongoDBUtils2.handleMongoDBConnection(sURI, sValorConsulta, sCollection, );
		System.out.println("value:" + value);

	} catch (Exception e) {
		e.printStackTrace();
	} */

    public void doConfCancelarAA(String indice, String sURI) throws Exception {

        Thread.sleep(4000);
        doClick("Click_en_Botón_Cancelar_Pedido", btn_CancelarAg, true);
        //validateObject("Click_en_Botón_Cancelar_Pedido",btn_CancelarAg,"DISPLAYED", true);


        Thread.sleep(3000);
        doClick("Click_en_Botón_Aceptar", btn_ConfiCancAA, true);
    }
}


