package xing.rujuan.onetoone.joincolumn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer c = new Customer("Miss", "Xing");
        Address address = new Address("1000 N 4th", "52556");
        c.setAddress(address);
        address.setCustomer(c);

        em.persist(c);

        em.remove(c);

        em.getTransaction().commit();
        em.close();

    }

}
