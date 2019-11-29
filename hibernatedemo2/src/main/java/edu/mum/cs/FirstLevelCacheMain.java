package edu.mum.cs;

import edu.mum.cs.domain.Book;
import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

    private void retrieval(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Person p = new Person("Miss", "Xing");
        Book book = new Book("111", "Hibernate");
        System.out.println("1..........");
        em.persist(book);
        System.out.println("2..........");

        Book book2 = em.find(Book.class, "111");
        System.out.println("3.......... " + book2.getTitle());

        em.getTransaction().commit();
        System.out.println("4..........");
        em.close();

    }

    private void update(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Person p = new Person("Miss", "Xing");
        Book book = new Book("111", "Hibernate");
        System.out.println("1..........");
//        em.persist(p);
        em.persist(book);
        System.out.println("2..........");

//        p.setFirstName("Tina");
        book.setTitle("Spring");
        System.out.println("3..........");

//        p.setLastName("YYYYYY");
        System.out.println("4..........");

        em.getTransaction().commit();
        System.out.println("5..........");
        em.close();

    }


    private void remove(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = new Person("Miss", "Xing");
        System.out.println("1..........");
        em.persist(p);
        System.out.println("2..........");
        p.setFirstName("Tina");
        System.out.println("3..........");
        em.remove(p);
        System.out.println("4..........");
        boolean existing = em.contains(p);
        System.out.println("5....."+ existing);

        em.getTransaction().commit();
        System.out.println("6..........");
        em.close();
    }


    public void pushChangesToDB(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("111", "Hibernate");
        System.out.println("1..........");
        em.persist(book);
        System.out.println("2..........");

        book.setTitle("Spring");
        System.out.println("3..........");

//        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
//        query.getResultList();

        em.flush();
        System.out.println("4..........");

        em.getTransaction().commit();
        System.out.println("6..........");
    }


    public static void main(String[] args) {
        FirstLevelCacheMain main = new FirstLevelCacheMain();
//        main.persist();
//        main.retrieval();
//        main.update();
//        main.remove();
        main.pushChangesToDB();
        emf.close();
    }
}
