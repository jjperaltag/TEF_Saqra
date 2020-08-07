package trazabilidadWeb.utility;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import java.util.Objects;

public class MongoDBUtils2 {

// Se usa para obtener el token para el login
    public String handleMongoDBConnection2(String uri, String sValorConsulta, String sCollection, String sKey1, String sKey2) {
        MongoClientURI uri_seguridad;
        uri_seguridad = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(uri_seguridad);
        MongoDatabase db = mongoClient.getDatabase(Objects.requireNonNull(uri_seguridad.getDatabase()));
        //MongoCursor<Document> cursor = db.getCollection(sCollection).find().iterator();
        String key1;
        Boolean token = false;
        String value=null;

//        MongoCollection<Document> collection = db.getCollection("collToken");
        MongoCollection<Document> collection = db.getCollection(sCollection);
        try {
//            FindIterable<Document> findIterable = collection.find(eq("customer.document_number", sValorConsulta));
            FindIterable<Document> findIterable = collection.find(eq(sKey1, sValorConsulta));
            System.out.println("ENCONTRO:"+findIterable);
            // BasicDBObject result = new BasicDBObject();
            MongoCursor<Document> cursor2 = findIterable.iterator();
            try {
                while(cursor2.hasNext()) {
                 //   value=cursor2.next().get("front_speech").toString();
                    value=cursor2.next().get(sKey2).toString();
                   // System.out.println("cursor.next() getTextoDB:"+value);
                }
            } finally {
                cursor2.close();
            }

        } catch (NullPointerException e){
            System.out.println("Message: NullPointerException");
        }
        finally {
        //    cursor.close();
        }

return value;
    }

    // Valida contra el texto(excel - texto que se guarda en la BD)

    public Boolean validarTextoSelectBD(String uri, String sValorConsulta, String sCollection, String sKey1, String sKey2, String textoAValidar){
        String textoSelect=null;
        textoSelect = handleMongoDBConnection2(uri, sValorConsulta, sCollection, sKey1, sKey2);
        System.out.println("textoAValidar111:"+textoAValidar);
        if (textoSelect.compareTo(textoAValidar)==0){
            System.out.println("verdadero");
            return true;
        }else {
            System.out.println("falso");
            return false;

        }

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
