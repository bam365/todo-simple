import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.Optional;

public class Database {
    public static Optional<Database> Connect(String dbName) {
        try {
            MongoClient cli = new MongoClient();
            return Optional.of(new Database(cli.getDatabase(dbName)));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Database(MongoDatabase db) {
        m_db = db;
    }

    private MongoDatabase m_db;
}
