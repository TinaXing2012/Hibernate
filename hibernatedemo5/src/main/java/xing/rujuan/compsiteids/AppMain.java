package xing.rujuan.compsiteids;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class AppMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Name name = new Name("Tina", "Xing");
        Person p = new Person(name, LocalDate.of(2019, 01, 01));


        Address address = new Address("1000 N 4th", "52556");
        p.addAddress(address);
        Address address2 = new Address("1001 N 4th", "12556");
        p.addAddress(address2);

        em.persist(p);

//        Name name2 = new Name("Tina", "Xing");
//        Person p2 = new Person(name2, LocalDate.of(2018, 01, 01));
//        em.persist(p2);

        em.getTransaction().commit();
        em.close();

    }

}
