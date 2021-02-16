package trazabilidadWeb.helpers;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ConectionsMethods {
    //Metodo que construye la request basica antes de hacer la peticion
    public RequestSpecification BuildRequestBasic(String Url_Request){
        RestAssured.baseURI=Url_Request;
        RequestSpecification request= RestAssured.given();
        return  request;
    }
    //Funcion que da otra opcion para pasar parametros en la request.
    public  RequestSpecification  BuildForm(RequestSpecification request,String name,String value){
        request.formParam(name,value);
        return request;
    }
    //Metodo para añadir parametros al header en peticiones post
    public RequestSpecification BuildHeaderRequest(String NameParametro,String ParametroValue,RequestSpecification request){
        request.header(NameParametro,ParametroValue);
        return request;
    }
    //Metodo para construir el body en peticiones post
    public RequestSpecification BuildBodyRequest(JSONObject peticion, RequestSpecification request){
        request.body(peticion.toJSONString());
        return request;
    }

    //Metodo Post
    public Response doPetitionPost(RequestSpecification request,String Seccion_request) throws IOException, ParseException {
        Response response=null;
        try{
            response =request.post(Seccion_request);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Fallo la conexion");
            response=null;
        }
        return response;
    }
    //Metodo GET
    public  Response DoPetitionGet(RequestSpecification Request,String Seccion_request){
        Response response=null;
        try{
            response=Request.request(Method.GET,Seccion_request);
        }catch ( Exception e){
            e.printStackTrace();
            System.out.println("Fallo la conexion");
            response=null;
        }
        return response;
    }
}
