package trazabilidadWeb.pageObject;


import org.testng.Assert;
import trazabilidadWeb.helpers.BasePage;

public class P009_CancelAfterScheduling extends BasePage {

    public final String btn_ValidarPedidoAgenda = "//button[@id='btn-schedul-schedulehome']";
    public final String a = "//div[contains(text(),'Reagendar')]";
    // Ver pedido AA
    public final String btn_VerPedidoAA = "/html//button[@id='btn-getschedule-boxproduct']";

    public final String btn_CancelarPedidoAA = "//a[@id='lnk-cancel-home']";
    public final String lbl_status = "//div[@id='lbl-status-tracking']";

    // Validar que el pedido tenga agendamiento

    public void doVerPedidos(String indice) throws Exception {

        if (btn_VerPedidoAA.length() > 0) {

            Thread.sleep(1000);
            jsScrollIntoView("Click_en_Ver_Pedido", btn_VerPedidoAA, false);
            Thread.sleep(1000);
            doClick("Click_en_Ver_Pedido", btn_VerPedidoAA, true);


        }

    }

    public void doValidarPedidoAgenda(String indice) throws Exception {

        try {
            if (btn_ValidarPedidoAgenda.length() > 0) {
                System.out.println("Estado: El pedido tiene agendamiento");
                validateObject("Validar que el pedido tenga agendamiento: Reagendar",lbl_status,"DISPLAYED", true);
                //doClick("Validar que el pedido tenga agendamiento: Reagendar", lbl_status, true);
                }

            if (btn_ValidarPedidoAgenda.length() < 0){

                System.out.println("Estado: El pedido no tiene agendamiento");
                Thread.sleep(2000);
                validateObject("Validar que el pedido tenga agendamiento: Reagendar",lbl_status,"DISPLAYED", true);
                //doClick("Validar que el pedido tenga agendamiento", lbl_status, true);
                Assert.fail();

        }}
            catch (Exception e){
                e.printStackTrace();
            }}}