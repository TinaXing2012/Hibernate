package edu.mum.cs;

import edu.mum.cs.domain.Person;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Person p = new Person(123L, "Miss", "Xing");
        em.persist(p);
        transaction.commit();
        em.close();
    }
}
