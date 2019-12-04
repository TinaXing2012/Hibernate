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

        for (Customer c : customers) {
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

    private static void cartesianProduct_BAD() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery("from Customer c left join c.books left join c.movies", Object[].class);
        query.getResultList();
        em.getTransaction().commit();
        emf.close();
    }


    private static void nPlusOneProblem() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SalesRep sr1 = new SalesRep("John Willis");
        SalesRep sr2 = new SalesRep("Mary Long");

        sr1.addCustomer(new Customer("Frank", "Brown"));
        sr1.addCustomer(new Customer("Jane", "Terrien"));
        sr2.addCustomer(new Customer("John", "Doe"));
        sr2.addCustomer(new Customer("Carol", "Reno"));

        em.persist(sr1);
        em.persist(sr2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<SalesRep> query = em.createQuery("from SalesRep", SalesRep.class);

        System.out.println("1..........");
        List<SalesRep> list = query.getResultList();
        System.out.println("2..........");
        for (SalesRep salesRep : list) {
            System.out.println("3..........");
            System.out.println(salesRep.getCustomers());
            System.out.println("4..........");
        }
        System.out.println("5..........");
        em.getTransaction().commit();
        em.close();

    }

    private static void entityGraph() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");

        cust1.setAddress(new Address("Fairfield", "Iowa"));
        cust2.setAddress(new Address("Chicago", "Illinois"));
        cust3.setAddress(new Address("Washington", "Iowa"));

        cust1.addBook(
                new Book("Harry Potter and the Deathly Hallows",
                        new Author("J.K. Rowlings")));
        cust1.addBook(
                new Book("Unseen Academicals (Discworld)",
                        new Author("Terry Pratchett")));
        cust1.addBook(
                new Book("The Color of Magic (Discworld)",
                        new Author("Terry Pratchett")));
        cust2.addBook(
                new Book("Twilight (The Twilight Saga, Book1)",
                        new Author("Stephenie Meyer")));

        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);

        em.getTransaction().commit();
        em.close();
        System.out.println();
        System.out.println();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
        EntityGraph<Customer> entityGraph = em.createEntityGraph(Customer.class);
        entityGraph.addAttributeNodes("address");
        entityGraph.addSubgraph("books").addAttributeNodes("author");

//        query.setHint("javax.persistence.fetchgraph", entityGraph);

        System.out.println("1..................");
        List<Customer> customers = query.getResultList();
        System.out.println("2..................");
        for(Customer c : customers){
            System.out.println("3..................");
            System.out.println(c.getAddress().getCity());
            System.out.println("4..................");
            List<Book> books = c.getBooks();
            System.out.println("5..................");
            for(Book book : books){
                System.out.println();
                System.out.println("6..................");
                System.out.println(book.getAuthor().getName());
                System.out.println("7..................");
                System.out.println();
            }
        }
        System.out.println("8..................");


        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void main(String[] args) {
//        populateCustomer();
//        lazyorEager();
//        nPlusOneProblem();
        entityGraph();
    }


}
