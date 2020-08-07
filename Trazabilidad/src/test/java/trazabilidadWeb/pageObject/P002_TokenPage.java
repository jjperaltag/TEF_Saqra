/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/

package trazabilidadWeb.pageObject;

import trazabilidadWeb.helpers.BasePage;
import trazabilidadWeb.utility.MongoDBUtils2;

import java.io.IOException;

public class P002_TokenPage extends BasePage {

	public final String txt_smsDigito1 = "|id|item1";
	public final String txt_smsDigito2 = "|id|item2";
	public final String txt_smsDigito3 = "|id|item3";
	public final String txt_smsDigito4 = "|id|item4";

	public final String btn_ingresar = "|id|btn-enter-token";


	public void doLoginToken(String sURI, String sCelular, String scollectionLogin, String key1, String key2) throws IOException {
		try {
			Thread.sleep(5000);
			MongoDBUtils2 mongoDBUtils = new MongoDBUtils2();
			String sms = mongoDBUtils.handleMongoDBConnection2(sURI, sCelular, scollectionLogin, key1, key2);
			System.out.println("sms: " + sms);

			doAddTextField("Ingresar_sms_digito1", txt_smsDigito1, sms.substring(0, 1), false);
			doAddTextField("Ingresar_sms_digito2", txt_smsDigito2, sms.substring(1, 2), false);
			doAddTextField("Ingresar_sms_digito3", txt_smsDigito3, sms.substring(2, 3), false);
			doAddTextField("Ingresar_sms_digito4", txt_smsDigito4, sms.substring(3), false);
			doClick("Click_en_Botón_INGRESAR", btn_ingresar, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}