package trazabilidadWeb.pageObject;

import trazabilidadWeb.helpers.BasePage;


//Cambiar dirección de instalación
public class P007_ChangeDireccionPage extends BasePage{

    public  final String btn_DireccionInstalacion = "//*[@id=\"scrollable-auto-tab-1\"]/span[1]";

    public  final String btn_CorregirDireccionInstalacion = "//*[@id=\"btn-update-address\"]";

    public  final String btn_PopUpAceptar = "//*[@id=\"btn-accept-modalinfo\"]";

//CAMBIAR DIRECCION

    public void doCambiarDireccion(String indice) throws Exception{
        validateObject("Registro_"+indice+"_Validar existencia de Boton DireccionInstalacion",btn_DireccionInstalacion,"DISPLAYED", true);

        doClick("[Registro"+indice+"]Click_Direccion_Instalacion", btn_DireccionInstalacion, true);
        doClick("[Registro_"+indice+"]_Click_CorregirDireccionInstalacion", btn_CorregirDireccionInstalacion,true);
        doClick("[Registro_"+indice+"]_Click_PopUpAceptar", btn_PopUpAceptar,true);


    }

}
