package xing.rujuan;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");


    private static void populateCustomer() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");
//        Address address1 = new Address("Fairfield", "Iowa");
//        Address address2 = new Address("Washington", "Iowa");
//        Address address3 = new Address("Outtuwa", "Iowa");
//        cust1.setAddress(address1);
//        cust2.setAddress(address2);
//        cust3.setAddress(address3);

        cust1.addBook(new Book("Hibernate 1"));
        cust1.addBook(new Book("Hibernate 2"));
        cust1.addBook(new Book("Hibernate 3"));

        cust2.addBook(new Book("Hibernate 4"));
//        cust2.addBook(new Book("Hibernate 5"));
//        cust3.addBook(new Book("Hibernate 6"));
//        cust3.addBook(new Book("Hibernate 7"));

        cust1.addMovie(new Movie("Shrek"));
        cust1.addMovie(new Movie("WALL-E"));
        cust1.addMovie(new Movie("Howls Moving Castle"));

        cust3.addMovie(new Movie("Forgetting Sarah Marshall"));

        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);

        em.getTransaction().commit();
        em.close();
    }

    private static void lazyorEager() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("1.............");
        TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);

        System.out.println("2.............");
        List<Customer> customers = query.getResultList();
        System.out.println("3.............");

        for(Customer c : customers){
            System.out.println("4.............");
//            System.out.println(c.getAddress());
            System.out.println(c.getBooks().size());
            System.out.println("5.............");
            System.out.println("");
        }

        System.out.println("6.............");
        em.getTransaction().commit();
        em.close();
    }

    private static void cartesianProduct_BAD(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("from Customer c left join c.books left join c.movies", Object[].class);
        query.getResultList();
        em.getTransaction().commit();
        emf.close();
    }

    public static void main(String[] args) {
        populateCustomer();
//        lazyorEager();

    }


}
