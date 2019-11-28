package edu.mum.cs;

import edu.mum.cs.domain.Book;
import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveTestMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    private void removeTransientObject(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //1. remove transient object - assigned primary key
//        Book b1 = new Book("111-222-333", "Hibernate");
//        em.remove(b1);

        //2. remove transient object - auto generated primary key
//        Person p1 = new Person("Miss", "Xing");
//        em.remove(p1);


        em.getTransaction().commit();
        em.close();
    }


    private void removeDetachedObject(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("Miss", "Xing");
        em.persist(p1);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
//        em.detach(p1);

        em.remove(p1);

        em.getTransaction().commit();
        em.close();
    }

    private void removeManagedObject(){

        persist();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Person p = em.find(Person.class, 1L);
//        Person p = em.getReference(Person.class, 1L);
//        em.remove(p);

        Book b = em.getReference(Book.class, "111-222");
        em.remove(b);

        em.getTransaction().commit();
        em.close();
    }

    private void persist(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("Miss", "Xing");
        em.persist(p1);

        Book b = new Book("111-222", "Hibernate");
        em.persist(b);

        em.getTransaction().commit();
        em.close();
    }


    public static void main(String[] args) {
        RemoveTestMain main = new RemoveTestMain();
//        main.removeTransientObject();
//        main.removeDetachedObject();
            main.removeManagedObject();

    }
}
