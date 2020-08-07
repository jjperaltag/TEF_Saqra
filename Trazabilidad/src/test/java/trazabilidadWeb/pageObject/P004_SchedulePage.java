/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/

package trazabilidadWeb.pageObject;

import org.junit.Assert;
import trazabilidadWeb.helpers.BasePage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P004_SchedulePage extends BasePage {

	public final String lbl_TituloPagina = "|id|lbl-title-schedule";
	public final String cob_Mañana = "//div[@class='boxTurns']//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'][contains(text(),'De 9:00 am a 1:00 pm')]";
    public final String cob_Tarde = "//div[@class='boxTurns']//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'][contains(text(),'De 1:00 pm a 6:00 pm')]";
	public final String lbl_fechaSeleccionada = "|id|lbl-descriptionturn-schedule";
	public final String btn_AgendarPedido = "//*[@id=\"btn-schedule\"]/span[1]";
	public final String btn_day = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'15')]";

	// Día
	public final String btn_day1 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'1')]";
	public final String btn_day2 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'2')]";
	public final String btn_day3 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'3')]";
	public final String btn_day4 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'4')]";
	public final String btn_day5 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'5')]";
	public final String btn_day6 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'6')]";
	public final String btn_day7 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'7')]";
	public final String btn_day8 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'8')]";
	public final String btn_day9 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'9')]";
	public final String btn_day10 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'10')]";
	public final String btn_day11 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'11')]";
	public final String btn_day12 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'12')]";
	public final String btn_day13 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'13')]";
	public final String btn_day14 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'14')]";
	public final String btn_day15 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'15')]";
	public final String btn_day16 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'16')]";
	public final String btn_day17 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'17')]";
	public final String btn_day18 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'18')]";
	public final String btn_day19 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'19')]";
	public final String btn_day20 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'20')]";
	public final String btn_day21 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'21')]";
	public final String btn_day22 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'22')]";
	public final String btn_day23 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'23')]";
	public final String btn_day24 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'24')]";
	public final String btn_day25 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'25')]";
	public final String btn_day26 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'26')]";
	public final String btn_day27 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'27')]";
	public final String btn_day28 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'28')]";
	public final String btn_day29 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'29')]";
	public final String btn_day30 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'30')]";
	public final String btn_day31 = "//div[@class='react-calendar calendario']//div[@class='react-calendar__viewContainer']//div[contains(@class,'react-calendar__month-view')]//div//div//abbr[contains(text(),'31')]";

	//

	//FUNCION de AGENDAR y REAGENDAR

	/*
	public void doAgendarPedido(String indice, String turno) throws IOException {
		try {
			validateObject("Registro_" + indice + "_Validar existencia de Boton AgendarPedido", btn_AgendarPedido, "DISPLAYED", true);
			Date date = new Date();
			System.out.println("date:" + date.getDate());

			doClick("Selección_día_del_agendamiento", btn_day, true);
			//date = date.getDate()+1;
			System.out.println(String.format("date2:" + date.getTime()));
			Thread.sleep(3000);
			//if(turno.equals("MANANA")) { //Turno mañana
			doClick("[Registro_" + indice + "]_Click_Turno_Manana", lbl_TurnoManana, false);
			Thread.sleep(3000);
			//}

			//if(turno.equals("TARDE")) { //Turno tarde
			//	doClick("[Registro_"+indice+"]_Click_Turno_Tarde",lbl_TurnoTarde,false);

			//}
			doClick("[Registro_" + indice + "]_Click_AgendarPedido", btn_AgendarPedido, true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}

	 */
/*
	public void doAgendoPedido(String indice, String turno) throws IOException {
		try {

	}catch(Exception e){
		e.printStackTrace();
		Assert.fail();
		}
		}}



 */

	public void doAgendarPedido(String indice, String turno, String date_Scheduling) {
		try {
			// validateObject("Registro_" + indice + "_Validar existencia de Boton AgendarPedido", btn_AgendarPedido, "DISPLAYED", true);
			System.out.println("Fecha: " + date_Scheduling);


			// Seleccionar día fecha del agendamiento

			// date_Scheduling.toString().substring(8, 10)
			Thread.sleep(4000);
			if (date_Scheduling.substring(0, 2).equals("1")) {
				doClick("Selección_día_del_agendamiento", btn_day1, true);
			}
			if (date_Scheduling.substring(0, 2).equals("2")) {
				doClick("Selección_día_del_agendamiento", btn_day2, true);
			}
			if (date_Scheduling.substring(0, 2).equals("3")) {
				doClick("Selección_día_del_agendamiento", btn_day3, true);
			}
			if (date_Scheduling.substring(0, 2).equals("4")) {
				doClick("Selección_día_del_agendamiento", btn_day4, true);
			}
			if (date_Scheduling.substring(0, 2).equals("5")) {
				doClick("Selección_día_del_agendamiento", btn_day5, true);
			}
			if (date_Scheduling.substring(0, 2).equals("6")) {
				doClick("Selección_día_del_agendamiento", btn_day6, true);
			}
			if (date_Scheduling.substring(0, 2).equals("7")) {
				doClick("Selección_día_del_agendamiento", btn_day7, true);
			}
			if (date_Scheduling.substring(0, 2).equals("8")) {
				doClick("Selección_día_del_agendamiento", btn_day8, true);
			}
			if (date_Scheduling.substring(0, 2).equals("9")) {
				doClick("Selección_día_del_agendamiento", btn_day9, true);
			}
			if (date_Scheduling.substring(0, 2).equals("10")) {
				doClick("Selección_día_del_agendamiento", btn_day10, true);
			}
			if (date_Scheduling.substring(0, 2).equals("11")) {
				doClick("Selección_día_del_agendamiento", btn_day11, true);
			}
			if (date_Scheduling.substring(0, 2).equals("12")) {
				doClick("Selección_día_del_agendamiento", btn_day12, true);
			}
			if (date_Scheduling.substring(0, 2).equals("13")) {
				doClick("Selección_día_del_agendamiento", btn_day13, true);
			}
			if (date_Scheduling.substring(0, 2).equals("14")) {
				doClick("Selección_día_del_agendamiento", btn_day14, true);
			}
			if (date_Scheduling.substring(0, 2).equals("15")) {
				doClick("Selección_día_del_agendamiento", btn_day15, true);
			}
			if (date_Scheduling.substring(0, 2).equals("16")) {
				doClick("Selección_día_del_agendamiento", btn_day16, true);
			}
			if (date_Scheduling.substring(0, 2).equals("17")) {
				doClick("Selección_día_del_agendamiento", btn_day17, true);
			}
			if (date_Scheduling.substring(0, 2).equals("18")) {
				doClick("Selección_día_del_agendamiento", btn_day18, true);
			}
			if (date_Scheduling.substring(0, 2).equals("19")) {
				doClick("Selección_día_del_agendamiento", btn_day19, true);
			}
			if (date_Scheduling.substring(0, 2).equals("20")) {
				doClick("Selección_día_del_agendamiento", btn_day20, true);
			}
			if (date_Scheduling.substring(0, 2).equals("21")) {
				doClick("Selección_día_del_agendamiento", btn_day21, true);
			}
			if (date_Scheduling.substring(0, 2).equals("22")) {
				doClick("Selección_día_del_agendamiento", btn_day22, true);
			}
			if (date_Scheduling.substring(0, 2).equals("23")) {
				doClick("Selección_día_del_agendamiento", btn_day23, true);
			}
			if (date_Scheduling.substring(0, 2).equals("24")) {
				doClick("Selección_día_del_agendamiento", btn_day24, true);
			}
			if (date_Scheduling.substring(0, 2).equals("25")) {
				doClick("Selección_día_del_agendamiento", btn_day25, true);
			}
			if (date_Scheduling.substring(0, 2).equals("26")) {
				doClick("Selección_día_del_agendamiento", btn_day26, true);
			}
			if (date_Scheduling.substring(0, 2).equals("27")) {
				doClick("Selección_día_del_agendamiento", btn_day27, true);
			}
			if (date_Scheduling.substring(0, 2).equals("28")) {
				doClick("Selección_día_del_agendamiento", btn_day28, true);
			}
			if (date_Scheduling.substring(0, 2).equals("29")) {
				doClick("Selección_día_del_agendamiento", btn_day29, true);
			}
			if (date_Scheduling.substring(0, 2).equals("30")) {
				doClick("Selección_día_del_agendamiento", btn_day30, true);
			}
			if (date_Scheduling.substring(0, 2).equals("31")) {
				doClick("Selección_día_del_agendamiento", btn_day31, true);
			}

			//

			// Selección del turno mañana
			Thread.sleep(4000);
			if (turno.equals("MAÑANA")) {
				doClick("Selección_Turno_Mañana", cob_Mañana, true);
			}

			// Selección del turno tarde
			Thread.sleep(4000);
			if (turno.equals("TARDE")) {
				doClick("Selección_Turno_Tarde", cob_Tarde, false);
			}

			// Confirmar agendamiento
			Thread.sleep(4000);
			doClick("Confirmar_agendamiento", btn_AgendarPedido, true);}

			catch(Exception e){
				e.printStackTrace();
				Assert.fail();
			}
		}
	}