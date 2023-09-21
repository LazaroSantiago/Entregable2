package Helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHelper {
    private static EntityManagerFactory emf;
    private static EntityManager entityManager;
    private static ConnectionHelper instance;

    private ConnectionHelper() {

    }

    public static ConnectionHelper startConnection() {
        if (instance == null) {
            emf = Persistence.createEntityManagerFactory("Test");
            entityManager = emf.createEntityManager();
        }
        return instance;
    }

    public static EntityManager refresh() {
        if (instance==null)
            startConnection();

        return entityManager;
    }
    public void closeConnection(){
        entityManager.close();
        emf.close();
    }
}
