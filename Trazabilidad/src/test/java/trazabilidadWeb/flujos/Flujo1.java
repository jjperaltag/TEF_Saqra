package trazabilidadWeb.flujos;

import trazabilidadWeb.helpers.BasicMethods;
import io.restassured.response.Response;

public class Flujo1 extends BasicMethods {
    String path_message="header.message";
    String path_resultCode="header.resultCode";
    String path_codigo="additionalData[3].value";
    String reason="statusChangeReason";
    public String obtenerMessage(Response response){
        String codigo;
        codigo = getStringValue(path_message,response);
        return codigo;
    }
    public String obtenerResultCode(Response response){
        String token;
        token = getStringValue(path_resultCode,response);
        return token;
    }
    public  Boolean validarStatus(Response response,int status){
        boolean result;
        String statuscode = Integer.toString(status);
        result = ValidateStatusCode(statuscode,response);
        return result;
    }



}
