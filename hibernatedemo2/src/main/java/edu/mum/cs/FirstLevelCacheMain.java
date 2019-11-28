package edu.mum.cs;

import edu.mum.cs.domain.Book;
import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FirstLevelCacheMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

//    Insert may be held in cache
    private void persist(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Person p = new Person("Miss", "Xing");
        Book book = new Book("111", "Hibernate");
        System.out.println("1..........");
        em.persist(book);
        System.out.println("2..........");

        em.getTransaction().commit();
        System.out.println("3..........");
        em.close();

    }


    public static void main(String[] args) {
        FirstLevelCacheMain main = new FirstLevelCacheMain();
        main.persist();
        emf.close();
    }
}
