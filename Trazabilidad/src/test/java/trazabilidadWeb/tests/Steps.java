/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Input Parameters:
 a) iNumeroDocumento = # de DNI del usuario
 b) aCuenta = Nombre del usuario
 c) iCelular = # celular asociado al usuario
 d) aPedidoRegistrado = Nombre del pedido registrado
 e) Turno = TARDE o MANANA
 f) aTurno = Si Turno=TARDE, entonces corresponde el texto: Turno: de 1 pm a 6 pm
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/

package trazabilidadWeb.tests;

import trazabilidadWeb.helpers.BasePage;
import trazabilidadWeb.helpers.Hook;
import trazabilidadWeb.pageObject.*;
import trazabilidadWeb.utility.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import trazabilidadWeb.utility.MongoDBUtils2;

import java.util.Date;


public final class Steps {
	public WebDriver driver;
	private String stId;
	private Hook hook = new Hook();

	P001_LoginPage p001_LoginPage = new P001_LoginPage();
	P002_TokenPage p002_tokenPage = new P002_TokenPage();
	P003_HomePage p003_HomePage = new P003_HomePage();
	P004_SchedulePage p004_schedulePage = new P004_SchedulePage();
	P005_ScheduleConfirmPage p005_scheduleConfirmPage = new P005_ScheduleConfirmPage();
	P006_ContactPage p006_ContactPage = new P006_ContactPage();
	P007_ChangeDireccionPage p007_ChangeDireccionPage = new P007_ChangeDireccionPage();
	P008_LoginBackOfficePage p008_loginBackOfficePage = new P008_LoginBackOfficePage();
	P009_CancelAfterScheduling p009_CancelAfterScheduling = new P009_CancelAfterScheduling();
	P010_CancelBeforeScheduling p010_CancelBeforeScheduling = new P010_CancelBeforeScheduling();
	P011_ProductSupport p011_ProductSupport = new P011_ProductSupport();

	public final String lbl_notificacion = "//*[@id=\"lbl-error-login\"]";

	@Given("^Soy Cliente e ingreso al sistema \"([^\"]*)\"$")
	public void ingreso_al_sistema(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = this.loadURL("DatosValidacionAcceso");

			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();


			// Abrir el navegador
			driver = hook.browser(sBrowser, sURL);


		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	@When("^Hacemos" +
			" login seleccionando el tipo_documento y numero_documento \"([^\"]*)\"$")
	public void seleccion_tipo_documento_y_numero_documento(int id) throws Throwable {
		Object[][] Parameters2 = this.loadURL("DatosValidacionAcceso");//loadAgendarPedido();

		String sTipoDocumento = Parameters2[(id - 1)][4].toString();
		String sNumDocumento = Parameters2[(id - 1)][5].toString();
		String sNombreUsuario = Parameters2[(id - 1)][6].toString();
		String indice = Integer.toString(id);
		String sCelular = Parameters2[(id - 1)][7].toString();
		String sCollectionLogin = Parameters2[(id - 1)][26].toString();
		String sKey1 = Parameters2[(id - 1)][27].toString();
		String sKey2 = Parameters2[(id - 1)][28].toString();
		try {
			String sURI = Parameters2[(id - 1)][1].toString();
			this.p001_LoginPage.doLogin(sTipoDocumento, sNumDocumento, sNombreUsuario, indice);
			p002_tokenPage.doLoginToken(sURI, sCelular, sCollectionLogin, sKey1, sKey2);
			// Captura el mensaje de error del label
			//String lbl_notificacion = driver.findElement(By.xpath("//*[@id=\"lbl-error-login\"]")).getText();

			// Almacenar el mensaje en una variable
			//String notificacion = "Lo sentimos, no encontramos un pedido registrado para este documento";
			//String notificacion2 = "El número de documento ingresado no es válido";

			//Validación del error

/*

			if (lbl_notificacion==notificacion)
			{
				Assert.assertEquals(lbl_notificacion, notificacion);

			}
			else if((lbl_notificacion==notificacion2)){
				System.out.print("Validación exitosa");
			}
			else
			{
				Assert.assertEquals(lbl_notificacion, notificacion2);

			}

 */


		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Falló en validación", e);

		}
	}


	@Then("^El inicio de sesión es exitoso \"([^\"]*)\"$")
	public void inicio_de_sesion_es_exitoso(int id) throws Exception {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = this.loadURL("DatosValidacionAcceso");
			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();
			Thread.sleep(8000);


			this.p003_HomePage.doLogHome(indice);
			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Falló en iniciar sesión", e);
		}
	}


	// PASOS PARA AGENDAR
	@Given("^Me logue con mi SMS y ubico mi \"([^\"]*)\"$")
	public void login_y_ubicar_pedido(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);
			Object[][] Parameters = loadURL("DatosValidacionAcceso");

			//Object[][] Parameters = loadURL("DatosValidacionAcceso");
			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();
			String sCuenta = Parameters[(id)][7].toString();
			String sCelular = Parameters[(id)][8].toString();
			String sNombreProducto = Parameters[(id)][9].toString();
			String sStatusAgendamiento = Parameters[(id)][10].toString();

			String sCollectionLogin = Parameters[(id - 1)][26].toString();
			String sKey1 = Parameters[(id - 1)][27].toString();
			String sKey2 = Parameters[(id - 1)][28].toString();


			///

			// Sirve para abrir el navegador
			driver = hook.browser(sBrowser, sURL);

			p001_LoginPage.doLogin(sTipoDocumento, sNumDocumento, sNombreUsuario, indice);
			Thread.sleep(1500);
			p002_tokenPage.doLoginToken(sURI, sCelular, sCollectionLogin, sKey1, sKey2);

			// Sirve para validaciones
			/*Assert.assertTrue(p003_HomePage.doValidarUsuario(sCuenta, indice));
			Assert.assertTrue(p003_HomePage.doValidarNombreProducto(sNombreProducto, indice));
			Assert.assertTrue(p003_HomePage.doValidarStatusAgendamiento(sStatusAgendamiento,indice));*/

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	@When("Agendo pedido de visita, en la fecha de hoy  y turno mañana, donde recibire al tecnico, en la direccion registrada. \"([^\"]*)\"$")
	public void agendoPedidoDeVisitaEnLaFechaDeHoy2YTurnoMañanaDondeRecibireAlTecnicoEnLaDireccionRegistrada(int id) throws Throwable {
		Object[][] Parameters3 = this.loadURL("DatosValidacionAcceso");
		;//loadAgendarPedido();

		String turno = Parameters3[(id-1)][14].toString();
		String date_Scheduling = Parameters3[(id - 1)][13].toString();
		String indice = Integer.toString(id);

		try {
			this.p003_HomePage.doAgendarPedido(indice);
			this.p004_schedulePage.doAgendarPedido(indice, turno, date_Scheduling);
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo agendamiento de pedido", e);
		}
	}

	@When("Se programa visita en fecha seleccionada \"([^\"]*)\"$")
	public void seProgramaVisitaEnFechaSeleccionada(int id) throws Throwable {

		Object[][] Parameters = loadURL("DatosValidacionAcceso");
		//String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();

		String indice = Integer.toString(id);

		try {
			//Assert.assertTrue(
			//p005_scheduleConfirmPage.doVerifyStatusPerfecto(assertConfirmacionTextoPerfecto, indice);
			//Assert.assertTrue(p005_scheduleConfirmPage.doVerifyConfirmacionTurno(assertTurno, indice));

			p005_scheduleConfirmPage.doAceptarConfirmacion(indice);
			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo en programacion de visita", e);
		}
	}

	@Then("^Se confirma el agendamiento \"([^\"]*)\"$")
	public void se_confirma_el_agendamiento(int id) throws Throwable {
		Object[][] Parameters = loadURL("DatosValidacionAcceso");
		String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();
		String indice = Integer.toString(id);


		/// Datos de conexion a la BD para confirmar envio de SMS:

		MongoDBUtils2 mongoDBUtils2 = new MongoDBUtils2();

		String sURIS = Parameters[(id - 1)][19].toString();
		String key1_select = Parameters[(id - 1)][20].toString();
		String key2_information = Parameters[(id - 1)][21].toString();
		String generic_Speech = Parameters[(id - 1)][22].toString();
		String valorConsulta = Parameters[(id - 1)][5].toString();
		String sCollection = Parameters[(id - 1)][23].toString();

		String sUri = Parameters[(id - 1)][1].toString();
		try {
			System.out.println("valor consulta STEPS:"+valorConsulta);
			Boolean valorBD = mongoDBUtils2.validarTextoSelectBD(sURIS, valorConsulta, sCollection, key1_select, key2_information, generic_Speech);
			Assert.assertTrue(valorBD);


			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/

			//	Hook.closeBrowser(BasePage.handleDriver());

			Hook.closeBrowser(BasePage.handleDriver());

			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}}

	//PASOS PARA REAGENDAR

	@Given("^Me logue con mi SMS y ubico mi cita para reagendar \"([^\"]*)\"$")
	public void meLogueConMiSMSYUbicoMiCitaParaReagendar(int id) throws Exception {
		try {
			String indice = Integer.toString(id);
			Object[][] Parameters2 = loadURL("DatosValidacionAcceso");

			//Object[][] Parameters = loadURL("DatosValidacionAcceso");
			String sURI = Parameters2[(id - 1)][1].toString();
			String sURL = Parameters2[(id - 1)][2].toString();
			String sBrowser = Parameters2[(id - 1)][3].toString();
			String sTipoDocumento = Parameters2[(id - 1)][4].toString();
			String sNumDocumento = Parameters2[(id - 1)][5].toString();
			String sNombreUsuario = Parameters2[(id - 1)][6].toString();
			String sCuenta = Parameters2[(id)][7].toString();
			String sCelular = Parameters2[(id)][8].toString();
			String sNombreProducto = Parameters2[(id)][9].toString();
			String sStatusAgendamiento = Parameters2[(id)][10].toString();



			String sCollectionLogin = Parameters2[(id - 1)][26].toString();
			String sKey1 = Parameters2[(id - 1)][27].toString();
			String sKey2 = Parameters2[(id - 1)][28].toString();


			// Sirve para abrir el navegador
			driver = hook.browser(sBrowser, sURL);

			p001_LoginPage.doLogin(sTipoDocumento, sNumDocumento, sNombreUsuario, indice);
			Thread.sleep(1500);
			p002_tokenPage.doLoginToken(sURI, sCelular, sCollectionLogin, sKey1, sKey2);

			// Sirve para validaciones
			/*Assert.assertTrue(p003_HomePage.doValidarUsuario(sCuenta, indice));
			Assert.assertTrue(p003_HomePage.doValidarNombreProducto_Reagendar(sNombreProducto, indice));*/

			//Assert.assertEquals(sNombreProducto, p003_HomePage.doValidarNombreProductoEquals());
			//	Assert.assertTrue(p003_HomePage.doValidarStatusAgendamiento());

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de datos de cuenta para reagendamiento", e);
		}
	}

	@When("^Reagendo pedido de visita, al dia siguiente. \"([^\"]*)\"$")
	public void reagendoPedidoDeVisitaAlDiaSiguiente(int id) throws Exception {
		try {
			String indice = Integer.toString(id);
			Object[][] Parameters = loadURL("DatosAgendamiento");
			String turno = Parameters[(id - 1)][14].toString();
			String date_Scheduling = Parameters[(id - 1)][13].toString();
			p003_HomePage.doReagendarPedido(indice);
			p004_schedulePage.doAgendarPedido(indice, turno,date_Scheduling); // Método para agendar y reagendar
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo reagendamiento de pedido", e);

		}
	}

	@When("Se reprograma la visita en fecha seleccionada \"([^\"]*)\"$")
	public void seReprogramaLaVisitaEnFechaSeleccionada(int id) throws Exception {

		Object[][] Parameters2 = loadURL("DatosAgendamiento");
		String sCuenta = Parameters2[(id - 1)][6].toString();

		Object[][] Parameters = loadReagendar("DatosAgendamiento");//loadReagendar_Pedido();
		String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();
		String assertTurno = Parameters[(id - 1)][16].toString();
		String indice = Integer.toString(id);

		/// Datos de conexion a la BD para confirmar envio de SMS:
		MongoDBUtils2 mongoDBUtils2 = new MongoDBUtils2();

		String sURI = Parameters[(id - 1)][19].toString();
		String key1_select = Parameters[(id - 1)][20].toString();
		String key2_information = Parameters[(id - 1)][21].toString();
		String generic_Speech = Parameters[(id - 1)][22].toString();
		String valorConsulta = Parameters[(id - 1)][5].toString();
		String sCollection = Parameters[(id - 1)][23].toString();
		try {
			Assert.assertTrue(p005_scheduleConfirmPage.doVerifyStatusPerfecto(assertConfirmacionTextoPerfecto, indice));
			Assert.assertTrue(p005_scheduleConfirmPage.doVerifyConfirmacionTurno(assertTurno, indice));

			p005_scheduleConfirmPage.doAceptarConfirmacion(indice);

			Assert.assertTrue(p003_HomePage.doValidarUsuario(sCuenta, indice));
			stId = Integer.toString(id);

			Boolean valorDB = mongoDBUtils2.validarTextoSelectBD(sURI, valorConsulta, sCollection, key1_select, key2_information, generic_Speech);
			Assert.assertTrue(valorDB);

			//	System.out.print("fecha:"+fechaReagendada);
			//	ExcelUtils.setCellData("./src/test/resources/data/TestData_Reagendamiento.xlsx", "AgendarPedido", "oStatus", stId,"EXITO");
			//	ExcelUtils.setCellData("./src/test/resources/data/TestData_Reagendamiento.xlsx", "AgendarPedido", "oFechaReagendamiento", stId,fechaReagendada);

			//	Assert.assertTrue(p003_HomePage.doValidarFecha(sCuenta,indice));
			p003_HomePage.doLogOut(stId);
/*
			stId = Integer.toString(1);
			if ((ExcelUtils.setCellData("./src/test/resources/data/TestData_Reagendamiento.xlsx", "AgendarPedido", "oStatus", stId,"EXITO")) == false)  {
			}
			String fechaReagendada = p003_HomePage.getFechaInstalacion();
			System.out.println("fecha:"+fechaReagendada);
			ExcelUtils.setCellData("./src/test/resources/data/TestData_Reagendamiento.xlsx", "AgendarPedido", "oFechaReagendamiento", stId,fechaReagendada);
*/
			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo en programacion de visita", e);
			stId = Integer.toString(1);

		}
	}

	@Then("^Se confirma el reagendamiento \"([^\"]*)\"$")
	public void se_confirma_el_reagendamiento(int id) throws Throwable {
		Object[][] Parameters = loadURL("DatosValidacionAcceso");
		String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();
		String indice = Integer.toString(id);


		/// Datos de conexion a la BD para confirmar envio de SMS:

		MongoDBUtils2 mongoDBUtils2 = new MongoDBUtils2();

		String sURIS = Parameters[(id - 1)][19].toString();
		String key1_select = Parameters[(id - 1)][20].toString();
		String key2_information = Parameters[(id - 1)][21].toString();
		String generic_Speech = Parameters[(id - 1)][22].toString();
		String valorConsulta = Parameters[(id - 1)][5].toString();
		String sCollection = Parameters[(id - 1)][23].toString();

		String sUri = Parameters[(id - 1)][1].toString();
		try {
			System.out.println("valor consulta STEPS:"+valorConsulta);
			Boolean valorBD = mongoDBUtils2.validarTextoSelectBD(sURIS, valorConsulta, sCollection, key1_select, key2_information, generic_Speech);
			Assert.assertTrue(valorBD);


			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/

			//	Hook.closeBrowser(BasePage.handleDriver());



			Hook.closeBrowser(BasePage.handleDriver());

			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/


		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);


		}


	}








	//PASOS DE CAMBIO DE CONTACTO CELESTE
	@Given("^Me logue con mi SMS y ubico mi boton \"([^\"]*)\"$")
	public void meLogueConMiSMSYUbicoMiBoton(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = loadURL("DatosValidacionAcceso");

			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();
			String sCuenta = Parameters[(id - 1)][7].toString();
			String sCelular = Parameters[(id - 1)][8].toString();
			String sNombreProducto = Parameters[(id - 1)][9].toString();
			String sStatusAgendamiento = Parameters[(id - 1)][10].toString();
			/*String sNuevoNombreContacto = Parameters[(id - 1)][10].toString();
			String sNuevoCelularContacto = Parameters[(id - 1)][11].toString();*/


			String sCollectionLogin = Parameters[(id - 1)][26].toString();
			String sKey1 = Parameters[(id - 1)][27].toString();
			String sKey2 = Parameters[(id - 1)][28].toString();


			driver = hook.browser(sBrowser, sURL);
			p001_LoginPage.doLogin(sTipoDocumento, sNumDocumento, sNombreUsuario, indice);
			Thread.sleep(8000);
			p002_tokenPage.doLoginToken(sURI, sCelular, sCollectionLogin, sKey1, sKey2);


			/*Assert.assertTrue(p003_HomePage.doValidarUsuario(sCuenta, indice));
			Assert.assertTrue(p003_HomePage.doValidarNombreProducto(sNombreProducto, indice));
			Assert.assertTrue(p003_HomePage.doValidarStatusAgendamiento(sStatusAgendamiento,indice));*/

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	@When("^Cambio el contacto que recibira al tecnico, en la direccion registrada. \"([^\"]*)\"$")
	public void seCambioElContactoQueRecibiraAlTecnicoEnLaDireccionRegistrada(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = loadURL("DatosValidacionAcceso");
			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();
			String sCelular = Parameters[(id - 1)][7].toString();
			String sNombreProducto = Parameters[(id - 1)][8].toString();
			String sStatusAgendamiento = Parameters[(id - 1)][9].toString();
			String sNuevoNombreContacto = Parameters[(id - 1)][10].toString();
			String sNuevoCelularContacto = Parameters[(id - 1)][11].toString();

			p006_ContactPage.doCambiarContacto(indice, sNuevoNombreContacto, sNuevoCelularContacto);
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	@Then("^Se cambia contacto de instalacion \"([^\"]*)\"$")
	public void seCambiacontactoDeInstalacion(int id) throws Throwable {
		Object[][] Parameters = loadURL("DatosValidacionAcceso");
		String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();
		String indice = Integer.toString(id);


		/// Datos de conexion a la BD para confirmar envio de SMS:

		MongoDBUtils2 mongoDBUtils2 = new MongoDBUtils2();

		String sURIS = Parameters[(id - 1)][19].toString();
		String key1_select = Parameters[(id - 1)][20].toString();
		String key2_information = Parameters[(id - 1)][21].toString();
		String generic_Speech = Parameters[(id - 1)][22].toString();
		String valorConsulta = Parameters[(id - 1)][5].toString();
		String sCollection = Parameters[(id - 1)][23].toString();

		String sUri = Parameters[(id - 1)][1].toString();
		try {
			System.out.println("valor consulta STEPS:"+valorConsulta);
			Boolean valorBD = mongoDBUtils2.validarTextoSelectBD(sURIS, valorConsulta, sCollection, key1_select, key2_information, generic_Speech);
			Assert.assertTrue(valorBD);


			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/

			//	Hook.closeBrowser(BasePage.handleDriver());


			Hook.closeBrowser(BasePage.handleDriver());

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	//---------------------------------------------------------------------------------

	//PASOS PARA CAMBIAR DIRECCION DE INSTALACION DE PRODUCTO ADQUIRIDO

	@Given("^Me logueo con mi SMS y ubico mi boton para cambiar direccion de instalacion \"([^\"]*)\"$")
	public void meLogueoConMiSMSYUbicoMiBotonParaCambiarDireccionDeInstalacion(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = loadURL("DatosValidacionAcceso");

			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			//String sCuenta = Parameters[(id - 1)][6].toString();
			String sCelular = Parameters[(id - 1)][7].toString();
			//String sNombreProducto = Parameters[(id - 1)][8].toString();
			//String sStatusAgendamiento = Parameters[(id - 1)][9].toString();
			String sTipoDocumento = Parameters[(id - 1)][4].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();

			String sCollectionLogin = Parameters[(id - 1)][26].toString();
			String sKey1 = Parameters[(id - 1)][27].toString();
			String sKey2 = Parameters[(id - 1)][28].toString();


			driver = hook.browser(sBrowser, sURL);
			//p001_LoginPage.doLogin(sNumDocumento,indice);
			p001_LoginPage.doLogin(sTipoDocumento, sNumDocumento, sNombreUsuario, indice);

			Thread.sleep(5000);
			p002_tokenPage.doLoginToken(sURI, sCelular, sCollectionLogin, sKey1, sKey2);

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	@When("^Cambio la direcion de instalacion de mi pedido. \"([^\"]*)\"$")
	public void seCambioLaDireccionDeMiPedido(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = loadURL("DatosValidacionAcceso");
			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sNombreUsuario = Parameters[(id - 1)][6].toString();
			String sCelular = Parameters[(id - 1)][7].toString();
			String sNombreProducto = Parameters[(id - 1)][8].toString();
			String sStatusAgendamiento = Parameters[(id - 1)][9].toString();
			String sNuevoNombreContacto = Parameters[(id - 1)][10].toString();
			String sNuevoCelularContacto = Parameters[(id - 1)][11].toString();

			p007_ChangeDireccionPage.doCambiarDireccion(indice);
			Thread.sleep(20000);

			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}

	//---------------------------------------------------------------------------------
	//PASOS PARA INGRESAR A LA PAGINA DE BACK OFFICE

	@Given("^Me logue con mi DNI y mi password \"([^\"]*)\"$")
	public void meLogueoConMiSDNIyMiPassword(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);

			Object[][] Parameters = loadLoginBackOffice("LoginBackOffice");

			String sURI = Parameters[(id - 1)][1].toString();
			String sURL = Parameters[(id - 1)][2].toString();
			String sBrowser = Parameters[(id - 1)][3].toString();
			String sNumDocumento = Parameters[(id - 1)][5].toString();
			String sPassword = Parameters[(id - 1)][6].toString();


			driver = hook.browser(sBrowser, sURL);

			p008_loginBackOfficePage.doIngresaralBackOffice(sNumDocumento, sPassword, indice);
			Thread.sleep(5000);
			//p002_tokenPage.doLoginToken(sURI,sCelular, indice);

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}


//......................................................................................................................

	// 	Cancelar Pedido Antes de Agendamiento

	@When("^Se ingresa a la opción cancelar pedido \"([^\"]*)\"$")
	public void se_ingresa_a_la_opción_cancelar_pedido(int id) throws Throwable {

		try {
			String indice = Integer.toString(id);

			p010_CancelBeforeScheduling.doCancelar_AA(indice);

		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);
		}
	}


	@When("^Se selecciona el motivo \"([^\"]*)\"$")
	public void se_selecciona_el_motivo(int id) throws Throwable {
		try {
			String indice = Integer.toString(id);
			Object[][] Parameters5 = this.loadURL("DatosValidacionAcceso");
			String sUri = Parameters5[(id - 1)][1].toString();
			String sCancelarAA = Parameters5[(id - 1)][8].toString();
			String sTipo_Cancelacion = Parameters5[(id - 1)][24].toString();
			String sMotivoAA = Parameters5[(id - 1)][25].toString();

			this.p010_CancelBeforeScheduling.doComboPedidoCancelarAA(indice, sUri, sCancelarAA, sTipo_Cancelacion, sMotivoAA);
			this.p010_CancelBeforeScheduling.doConfCancelarAA(indice, sUri);

			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);


		}

	}


	@Then("^Confirmamos la cancelación \"([^\"]*)\"$")
	public void confirmamos_la_cancelación(int id) throws Throwable {

		Object[][] Parameters = loadURL("DatosValidacionAcceso");
		String assertConfirmacionTextoPerfecto = Parameters[(id - 1)][15].toString();
		String indice = Integer.toString(id);


		/// Datos de conexion a la BD para confirmar envio de SMS:

		MongoDBUtils2 mongoDBUtils2 = new MongoDBUtils2();

		String sURIS = Parameters[(id - 1)][19].toString();
		String key1_select = Parameters[(id - 1)][20].toString();
		String key2_information = Parameters[(id - 1)][21].toString();
		String generic_Speech = Parameters[(id - 1)][22].toString();
		String valorConsulta = Parameters[(id - 1)][5].toString();
		String sCollection = Parameters[(id - 1)][23].toString();

		String sUri = Parameters[(id - 1)][1].toString();
		try {

			Boolean valorBD = mongoDBUtils2.validarTextoSelectBD(sURIS, valorConsulta, sCollection, key1_select, key2_information, generic_Speech);
			Assert.assertTrue(valorBD);


			/*
			Boolean valorBD=mongoDBUtils3.handleMongoDBConnection2(sURIS, valorConsulta, sCollection, key1_select, key2_information, message_template_text);
			Assert.assertTrue(valorBD);
*/

			Hook.closeBrowser(BasePage.handleDriver());
		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Fallo validacion de cuenta de usuario", e);


		}


	}

//......................................................................................................................

	// 	Cancelar Pedido Después de Agendamiento

	@When("^Se valida que el pedido tenga agendamiento \"([^\"]*)\"$")
	public void se_valida_que_el_pedido_tenga_agendamiento(String indice) throws Throwable {
		try {
			//p009_CancelAfterScheduling.doVerPedidos(indice);
			p009_CancelAfterScheduling.doValidarPedidoAgenda(indice);
			Hook.closeBrowser(BasePage.handleDriver());


		} catch (AssertionError e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			Hook.closeBrowser(BasePage.handleDriver());
			Assert.fail("Falló, el pedido no tiene agendamiento", e);

		}

	}


	public Object[][] loadURL(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_ValidaciondeAcceso.xlsx", tipo));
	}

	public Object[][] loadAgendarURL(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_Agendamiento.xlsx", tipo));
	}

	public Object[][] loadReagendar(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_Reagendamiento.xlsx", tipo));
	}

	public Object[][] loadCambioDeContacto(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/CambiodeContacto.xlsx", tipo));
	}

	public Object[][] loadCambioDeDireccion(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_CambiodeDireccion.xlsx", tipo));
	}

	public Object[][] loadLoginBackOffice(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_LoginBackOffice.xlsx", tipo));
	}

	public Object[][] loadCancelAfterScheduling(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_CancelAfterSheduling.xlsx", tipo));
	}

	public Object[][] loadCancelBeforeScheduling(String tipo) throws Exception {
		return (ExcelUtils.getTableArray("./src/test/resources/data/TestData_CancelBeforeScheduling.xlsx", tipo));
	}

	// Validar que Trazabilidad Soporte más de un producto

	@When("Validamos que tenga más de un producto \"([^\"]*)\"$")
	public void validamosQueTengaMásDeUnProducto(int id) throws Exception {


		String indice = Integer.toString(id);
		p011_ProductSupport.doVerSoportePedido(indice);

	}
		}

