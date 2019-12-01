package xing.rujuan.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account checking = new Checking(100.00, 20.00);
        em.persist(checking);

        Account savings = new Savings(2000.00, 200.00);
        em.persist(savings);

        em.getTransaction().commit();
        em.close();

    }

}
