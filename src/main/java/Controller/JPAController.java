package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAController {
    private static EntityManagerFactory emf;
    private static EntityManager entityManager;
    private static JPAController instance;

    private JPAController() {

    }

    public static JPAController startConnection() {
        if (instance == null) {
            emf = Persistence.createEntityManagerFactory("Test");
            entityManager = emf.createEntityManager();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        if (instance==null)
            startConnection();

        return entityManager;
    }

    public void insert(Object o) {
        entityManager.persist(o);
        closeConnection();
    }

    public <T> T select(Class<T> tClass, Object o) {
        T result = entityManager.find(tClass, o);
        this.closeConnection();
        return result;
    }

    public void closeConnection() {
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
