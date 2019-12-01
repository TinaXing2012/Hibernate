package xing.rujuan.secondarytable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class AppMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student s1 = new Student("SNO.1", "Tina", "Xing", "Computer Science", LocalDate.of(2019, 11, 29));
        Student s2 = new Student("SNO.2", "Tina2", "Xing2", "Arts", LocalDate.of(2018, 10, 19));
        em.persist(s1);
        em.persist(s2);

        em.getTransaction().commit();
        em.close();

    }

}
