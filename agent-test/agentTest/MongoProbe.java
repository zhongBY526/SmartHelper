import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoProbe {
    public static void main(String[] args) {
        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("smarthelper");
            System.out.println("== collections ==");
            for (String col : db.listCollectionNames()) {
                System.out.println("  " + col + " count=" + db.getCollection(col).countDocuments());
            }
            MongoCollection<Document> coll = db.getCollection("mongodb");
            for (Document d : coll.find()) {
                System.out.println("---- memoryId=" + d.getString("memoryId") + " ----");
                String content = d.getString("content");
                System.out.println(content);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
