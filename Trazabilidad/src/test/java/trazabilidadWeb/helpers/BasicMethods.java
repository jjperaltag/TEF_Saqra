/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Portal de Venta Fija
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package trazabilidadWeb.helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class BasicMethods {
    public JSONObject DoOpenFileRequest(String FilePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fr = new FileReader(FilePath);
        Object  obj = parser.parse(fr);
        JSONObject JsonRequest = (JSONObject) obj;
        return JsonRequest;
    }
    public String getStringValue(String path, Response response){
     String value=null;
        try{
          JsonPath jsonpath = response.jsonPath();
          value= jsonpath.get(path);
      }catch (Exception e){
            e.printStackTrace();
            System.out.println("No se encontro el valor");
        }
 return value;
    }
    public String DoExtractBodyResponse(Response response){
        String Body_response=response.getBody().asString();
        return Body_response;
    }
    public List<JSONObject> GetListofJson(Response response, String path){
        List results= null;
        try{
            JsonPath jsonpath = response.body().jsonPath();
            results=jsonpath.get(path);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return  results;
    }
    public boolean ValidateValueofList(Response response,String path, String value_compare){
        boolean result=false;
        try{
            JsonPath jsonpath = response.body().jsonPath();
            List<String> values=jsonpath.get(path);
            String value=values.get(0);

            if(value.equalsIgnoreCase(value_compare)){
                result=true;
                System.out.println("El elemento si coincide");
            }
            else{
                result=false;
                System.out.println("Los elementos no coinciden");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ha ocurrido un error en la comparacion");
        }
        return result;
    }
    public boolean ValidateValue(Response response,String path, String value_compare){
        boolean result=false;
        try{
            JsonPath jsonpath = response.body().jsonPath();
            String value=jsonpath.get(path);

            if(value.equalsIgnoreCase(value_compare)){
                result=true;
                System.out.println("El elemento si coincide");
            }
            else{
                result=false;
                System.out.println("Los elementos no coinciden");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ha ocurrido un error en la comparacion");
        }
        return result;
    }
public boolean ValidateStatusCode( String StatusExpected,Response response){
        boolean result=false;
        try{
            int status=response.getStatusCode();
            String status_string= Integer.toString(status);
            if(status_string.equalsIgnoreCase(StatusExpected)){
                result=true;
                System.out.println("La prueba de status es correca");
            }
            else{
                result=false;
                System.out.println("La prueba de status no coincide");
            }

        }catch (Exception e){
            System.out.println("Ha ocurrido un error en la prueba de estatus");
        }
        return result;
}
public List<String> GetListString(String path,Response response){
List<String> lista;
    JsonPath jsonpath = response.body().jsonPath();
    lista=jsonpath.get(path);

return lista;
}
public JSONObject ChangeParameterInJson(JSONObject json_modified, String parametro_old, String parametro_new) throws ParseException {
    JSONObject json_new=null;
        try{
            String json_string=ConvertJsonToString(json_modified);
            String json_string_new=json_string.replace(parametro_old,parametro_new);
            json_new=ConvertStringToJson(json_string_new);}
        catch (Exception e) {
                e.printStackTrace();
            }


        return json_new;
}
public JSONObject ChangeBlockInJson(JSONObject json_base, String block_to_change, JSONObject BlockNew) throws ParseException {
     String jsonStringBase=ConvertJsonToString(json_base);
     String JsonStringBlockNew=ConvertJsonToString(BlockNew);
     String jsonString_new=jsonStringBase.replace(block_to_change,JsonStringBlockNew);
     JSONObject json_new=ConvertStringToJson(jsonString_new);
     return json_new;
}
public JSONObject ConvertStringToJson(String jsonstring) throws ParseException {
    JSONParser parser = new JSONParser();
    JSONObject json_new = (JSONObject) parser.parse(jsonstring);
    return json_new;
}
public String ConvertJsonToString(JSONObject json){
        String jsonString=json.toJSONString();
        return jsonString;
}
}
