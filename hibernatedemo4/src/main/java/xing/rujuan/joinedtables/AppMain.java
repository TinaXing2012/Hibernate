package xing.rujuan.joinedtables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account checking = new Checking(300.00, 10.00);
        em.persist(checking);

        Account savings = new Savings(5000.00, 800.00);
        em.persist(savings);

        em.getTransaction().commit();
        em.close();

    }

}
