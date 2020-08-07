package trazabilidadWeb.utility;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.Objects;

public class MongoDBUtils3OLD {


    public Boolean handleMongoDBConnection3(String uri, String sValorConsulta, String sCollection, String sKey1, String sKey2, String textoAValidar) throws UnknownHostException {
        String value=null;

        MongoClientURI uri_seguridad;
        uri_seguridad = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(uri_seguridad);
        MongoDatabase db = mongoClient.getDatabase(Objects.requireNonNull(uri_seguridad.getDatabase()));
        System.out.println("BD_Conexion_Exito:"+db.getName());

        MongoCursor<Document> cursor = db.getCollection(sCollection).find().iterator();
        String key1;
        Boolean token = false;
//        MongoCollection<Document> collection = db.getCollection("collToken");
        MongoCollection<Document> collection = db.getCollection(sCollection);
        try {
    //        System.out.println("sKey1INIantesWhile:"+sKey1);

            while (cursor.hasNext()&& !token) {
                Document document = cursor.next();
    //            System.out.println("sKey1INIinWhileKEY1:"+sKey1);
                Object key1_object =null;
//                key1_object = document.get("customer");
                key1_object = document.get(sKey1);
                value = document.getString(sKey2);
/*
   System.out.println("Sub_tostring:"+ key1_object.toString().substring(45,53));
                System.out.println("value1_:"+value);
                System.out.println("sValorConsulta:"+sValorConsulta);
System.out.println(key1_object);
                {
*/

if(key1_object.equals(sValorConsulta)){
                    token=true;
                    value = document.getString(sKey2);
                    System.out.println("Valor_BD:"+key1_object);
                    System.out.println("ValorBD:"+key1_object);
                    System.out.println("Valor_consultado:"+value);
                    System.out.println("Valor_esperado:"+textoAValidar);
                }
            }
        }    /*catch(NullPointerException e) {
            System.out.println("Something went wrong.");*/


            finally {
            cursor.close();
        }


           // if (value.compareTo(textoAValidar)==0){
                if(value.equals(textoAValidar)){
                System.out.println("verdadero");
                return true;
        }else {
                System.out.println("falso");
                return false;

            }
        //return value;

    }

    public void insertMongoDB(MongoCollection<Document> collection){
        Document document = new Document("title", "Software Developer")
                .append("id", 1)
                .append("name", "Ajay Yadav")
                .append("age", 26)
                .append("by", "Ajay Yadav");

        collection.insertOne(document);
    }

    public void findMongoDB(MongoCollection<Document> collection){
        Document document = null;
        collection.find();
    }


}
