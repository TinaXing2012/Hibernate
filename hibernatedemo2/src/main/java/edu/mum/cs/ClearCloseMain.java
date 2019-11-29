package edu.mum.cs;

import edu.mum.cs.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClearCloseMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    private void clear(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("222", "Hibernate");
        System.out.println("1..........");
        em.persist(book);
        System.out.println("2..........");
        System.out.println("3....." + em.contains(book));

        em.flush();
        System.out.println("4..........");
        em.clear(); //detach all objects in cache
        System.out.println("5......" + em.contains(book));

        em.getTransaction().commit();
        System.out.println("6..........");
    }

    private void close(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("333", "Hibernate");
        System.out.println("1..........");
        em.persist(book);
        System.out.println("2..........");
        em.getTransaction().commit();
        System.out.println("3..........");
        em.close();
        System.out.println("4..........");
        em.contains(book);
        System.out.println("5..........");
    }


    public static void main(String[] args) {
        ClearCloseMain main = new ClearCloseMain();
//        main.clear();
        main.close();
        emf.close();
    }
}
