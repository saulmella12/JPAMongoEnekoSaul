package controller;

import lombok.Getter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Getter
public class Controller {
    private static Controller controller;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    private EntityTransaction transaction;

    private Controller() {
    }

    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }

    public void open() {
        if(entityManagerFactory == null || !entityManagerFactory.isOpen())
            entityManagerFactory = Persistence.createEntityManagerFactory("practica");
        if(manager == null || !manager.isOpen())
            manager = entityManagerFactory.createEntityManager();

        transaction = manager.getTransaction();
    }

    public void close() {
        manager.close();
        entityManagerFactory.close();
    }
}

