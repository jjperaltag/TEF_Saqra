package trazabilidadWeb.pageObject;

//import sun.security.util.Password;
import trazabilidadWeb.helpers.BasePage;

public class P008_LoginBackOfficePage extends BasePage {

    //Input a llenar

    public  final String txt_IngresarDNI = "//*[@id=\"login\"]";

    public  final String txt_IngresarPassword = "//*[@id=\"password\"]";

    public  final String btn_Login = "//*[@id=\"btn-login\"]";


    //Se ejecutaran las siguientes acciones

    public void doIngresaralBackOffice(String NumeroDocumento, String Password , String indice) throws Exception{
        validateObject("Registro_"+indice+"_Validar existencia de Boton Login",btn_Login,"DISPLAYED", true);

        doAddTextField("[Ingresar_dni"+indice+"]Ingresar_dni", txt_IngresarDNI, NumeroDocumento ,  true);

        //System.out.println("valor:"+NumeroDocumento);
        doAddTextField("[Ingresar_password"+indice+"]Ingresar_password", txt_IngresarPassword, Password ,true);

        doClick("[Registro_"+indice+"]_Click_PopUpAceptar", btn_Login,true);


    }







}
