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

public class P005_ScheduleConfirmPage extends BasePage {

    public  final String lbl_Perfecto = "//*[@id=\"lbl-title-confirmschedule\"]";
    public  final String lbl_ConfirmacionProgramacion = "//*[@id=\"lbl-subtitle-confirmschedule\"]";
    public  final String lbl_Dia = "//*[@id=\"lbl-datedetail-confirmschedule\"]/span";
    public  final String lbl_turno = "//*[@id=\"lbl-timedetail-confirmschedule\"]";
    public  final String btn_Aceptar = "//*[@id=\"btn-accept-confirmschedule\"]/span[1]";


    public boolean doVerifyStatusPerfecto(String sStatusPerfecto, String indice) throws Exception {
        validateObject("Registro_"+indice+"_Validar existencia de Label Perfecto",lbl_Perfecto,"DISPLAYED", true);
        return verifyText(sStatusPerfecto,lbl_Perfecto, indice, true);
    }

    public boolean doVerifyConfirmacionProgramacion(String sStatusConfProgram, String indice) throws Exception {
        validateObject("Registro_"+indice+"_Validar existencia de Label ConfirmacionProgramacion",lbl_ConfirmacionProgramacion,"DISPLAYED", true);
        return verifyText(sStatusConfProgram,lbl_ConfirmacionProgramacion, indice, true);
    }

    public boolean doVerifyConfirmacionTurno(String sStatusConfTurno, String indice) throws Exception {
        validateObject("Registro_"+indice+"_Validar existencia de Label Turno",lbl_turno,"DISPLAYED", true);
        return verifyText(sStatusConfTurno,lbl_turno, indice, false);
    }

    public void doAceptarConfirmacion(String indice) throws Exception {
        //validateObject("Registro_"+indice+"_Validar existencia de Boton Aceptar",btn_Aceptar,"DISPLAYED", true);
        doClick("[Registro_"+indice+"]_Click_Aceptar_Confirmacion_Turno",btn_Aceptar,true);
    }


}


