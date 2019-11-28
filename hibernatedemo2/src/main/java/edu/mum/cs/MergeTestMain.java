package edu.mum.cs;

import edu.mum.cs.domain.Book;
import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MergeTestMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    private void persist() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Tina", "Xing");
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    private void merge() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = em.find(Person.class, 1L);
        em.detach(p1);

        Person p2 = em.find(Person.class, 1L);

        p1.setFirstName("Miss");

        p1 = em.merge(p1);

        p1.setFirstName("Josh");


        em.getTransaction().commit();
        em.close();
    }


    private void merge2() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("Tina", "Xing");
        p1 = em.merge(p1);


        Book b1 = new Book("111-222-3333", "Hibernate...");
        b1 = em.merge(b1);


        em.getTransaction().commit();
        em.close();
    }

    private void mergeVSpersist() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book b1 = new Book("111", "Hibernate");
        em.persist(b1);

        Book b2 = new Book("111", "Spring");
        em.persist(b2);

//        Book b1 = new Book("111", "Hibernate");
//        em.merge(b1);
//
//        Book b2 = new Book("111", "Spring");
//        em.merge(b2);



        em.getTransaction().commit();
        em.close();

    }


    public static void main(String[] args) {
        MergeTestMain main = new MergeTestMain();
//        main.persist();
//        main.merge();

        main.mergeVSpersist();

    }
}
