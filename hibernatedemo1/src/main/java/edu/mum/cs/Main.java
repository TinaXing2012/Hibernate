package edu.mum.cs;

import edu.mum.cs.domain.Person;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Person p = new Person("Miss", "Xing", "test@gmail.com", new Date(), LocalDate.of(2019, 01, 01));
        em.persist(p);

        em.createQuery("from people");
        em.createNativeQuery("select * from mycustomizedperson");
        transaction.commit();
        em.close();
    }
}
