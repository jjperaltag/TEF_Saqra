package trazabilidadWeb.utility;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.Objects;

public class MongoDBUtilsOLD {


    public String handleMongoDBConnection( String uri, String sValorConsulta) throws UnknownHostException {
        String mongoDatabase = "compose";
        String sms=null;
        // uri = "mongodb://admin:GWFWWHYZSDWDBGFO@portal-ssl1470-53.bmix-dal-yp-dfee1e1d-df78-4540-87c1-6ca1575a0fd8.445811714.composedb.com:25326,portal-ssl952-54.bmix-dal-yp-dfee1e1d-df78-4540-87c1-6ca1575a0fd8.445811714.composedb.com:25326/compose?authSource=admin&ssl=true"
        MongoClientURI uri_seguridad;
        uri_seguridad = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(uri_seguridad);
        MongoDatabase db = mongoClient.getDatabase(Objects.requireNonNull(uri_seguridad.getDatabase()));
        System.out.println("BD_Conexion_Exito: "+db.getName());
        MongoCursor<Document> cursor = db.getCollection("collToken").find().iterator();
        String celular;
        Boolean token = false;
        MongoCollection<Document> collection = db.getCollection("collToken");
        try {
            while (cursor.hasNext()&& !token) {
                Document document = cursor.next();
                celular =   document.getString("phone_number");
                sms = document.getString("token");

                if (Objects.equals(sValorConsulta, celular)){
                    token=true;
                    sms = document.getString("token");
                }

            }
        } finally {
            cursor.close();
        }
        return sms;

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
