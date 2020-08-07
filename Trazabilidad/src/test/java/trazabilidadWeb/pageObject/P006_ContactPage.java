package trazabilidadWeb.pageObject;
//import sun.security.x509.URIName;
import trazabilidadWeb.helpers.BasePage;

//CAMBIAR CONTACTO
public class P006_ContactPage extends BasePage {

    public  final String cb_CambiarContacto = "//*[@id=\"contacts-radio\"]/fieldset/div/label[2]/span[2]";
    //Añadir Contacto
    public final String btn_AñadirContacto = "//*[@id=\"lbl-add-contactsadd\"]";
    //Contacto 1
    public final String txt_NombreContacto_1 = "//*[@id=\"input-contact-name-0\"]";
    public final String txt_CelularContacto_1 = "//*[@id=\"input-contact-phone-0\"]";
    //Contacto 2
    public final String txt_NombreContacto_2 = "//*[@id=\"input-contact-name-1\"]";
    public final String txt_CelularContacto_2 = "//*[@id=\"input-contact-phone-1\"]";
    //Contacto 1
    public final String txt_NombreContacto_3 = "//*[@id=\"input-contact-name-2\"]";
    public final String txt_CelularContacto_3 = "//*[@id=\"input-contact-phone-2\"]";
    //Contacto 1
    public final String txt_NombreContacto_4 = "//*[@id=\"input-contact-name-3\"]";
    public final String txt_CelularContacto_4 = "//*[@id=\"input-contact-phone-3\"]";
    //------------------boton enviar----
    public final String btn_Enviar = "//*[@id=\"btn-save-contactsadd\"]/span[1]";

    //CAMBIAR CONTACTO

    public void doCambiarContacto(String indice, String personaNueva, String NumeroCelular) throws Exception{
        validateObject("Registro_"+indice+"_Validar existencia de Listado CambiarContacto",cb_CambiarContacto,"DISPLAYED", true);

        doClick("[Registro"+indice+"]Click_Cambiar_Contacto", cb_CambiarContacto, true);

        doAddTextField("Ingresar_name_1"+indice+"]_Agregar_NombreContacto_1", txt_NombreContacto_1, personaNueva, true);
        doAddTextField("Ingresar_cel_1"+indice+"]_Agregar_CelularContacto_1", txt_CelularContacto_1, NumeroCelular, true);


        /*if(personaNueva.equals("CONTACTO 1")) { //Primer Contacto
            doAddTextField("Ingresar_name_1"+indice+"]_Agregar_NombreContacto_1", txt_NombreContacto_1, personaNueva, true);
            doAddTextField("Ingresar_cel_1"+indice+"]_Agregar_CelularContacto_1", txt_CelularContacto_1, NumeroCelular, true);
        }

        if(personaNueva.equals("CONTACTO 2")) { //Segundo Contacto
            doAddTextField("[Ingresar_name_2"+indice+"]_Agregar_NombreContacto_2", txt_NombreContacto_2, personaNueva, true);
            doAddTextField("[Ingresar_cel_2"+indice+"]_Agregar_CelularContacto_2", txt_CelularContacto_2, NumeroCelular, true);

        }
        if(personaNueva.equals("CONTACTO 3")) { //Tercer Contacto
            doAddTextField("[Ingresar_name_3"+indice+"]_Agregar_NombreContacto_3", txt_NombreContacto_3, personaNueva, true);
            doAddTextField("[Ingresar_cel_3"+indice+"]_Agregar_CelularContacto_3", txt_CelularContacto_3, NumeroCelular, true);
        }

        if(personaNueva.equals("CONTACTO 4")) { //Cuarto Contacto
            doAddTextField("[Ingresar_name_4"+indice+"]_Agregar_NombreContacto_4", txt_NombreContacto_4, personaNueva, true);
            doAddTextField("[Ingresar_cel_4"+indice+"]_Agregar_CelularContacto_4", txt_CelularContacto_4, NumeroCelular, true);

        }*/
        doClick("[Registro_"+indice+"]_Click_AgendarPedido", btn_Enviar,true);



    }



}
