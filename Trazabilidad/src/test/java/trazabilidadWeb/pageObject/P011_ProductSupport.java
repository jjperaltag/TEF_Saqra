package trazabilidadWeb.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trazabilidadWeb.helpers.BasePage;

public class P011_ProductSupport extends BasePage {
    WebDriver driver;
    public final String btn_VerSoportePedido = "/html//button[@id='btn-getschedule-boxproduct']";
    public final String btn_VerSoportePedido2 = "//div[@class='container']//div[2]//div[1]//div[2]//button[1]";
    public final String btn_Volver = "//div[@class='icon-back']//img[1]";

    public final String ac = "//*[contains(text(),'VER PEDIDO')]";

    public void doVerSoportePedido(String indice) throws Exception {
        try{

        if (btn_VerSoportePedido.isEmpty()) {
            Thread.sleep(1000);
            System.out.println("NO HAY BOTÓN VER PEDIDO");
        }


        if (!btn_VerSoportePedido.isEmpty()) {
            Thread.sleep(4000);
            doClick("Click_en_Ver_Pedido 1", btn_VerSoportePedido, true);
            System.out.printf("VER PEDIDO ");
            doClick("Click_en_Ver_Pedido 1", btn_Volver, true);
            Thread.sleep(3000);
            doClick("Click_en_Ver_Pedido 2", btn_VerSoportePedido2, true);
        }
    }
        catch (Exception e) {
            e.printStackTrace();
        }}}





