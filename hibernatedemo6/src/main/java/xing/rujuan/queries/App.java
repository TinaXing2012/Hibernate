package xing.rujuan.queries;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    private static void createQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//       Query query = em.createQuery("from Person");
        TypedQuery<Person> query = em.createQuery("from Person", Person.class);
        List<Person> personList = query.getResultList();
        System.out.println(personList);
        em.getTransaction().commit();
        em.close();
    }

    private static void namedQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createNamedQuery("Person.everyone", Person.class);
        List<Person> personList = query.getResultList();
        System.out.println(personList);
        em.getTransaction().commit();
        em.close();
    }

    private static void polymorphicQuery() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account checking = new CheckingAccount(100.00, 20.00);
        em.persist(checking);

        Account savings = new SavingsAccount(2000.00, 200.00);
        em.persist(savings);

        TypedQuery<Account> query = em.createQuery("from Account", Account.class);
        List<Account> accounts = query.getResultList();
        System.out.println(accounts);

        em.getTransaction().commit();
        em.close();
    }

    private static void aliasesQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person as p where p.id = 1", Person.class);
        System.out.println(query.getResultList());

        em.getTransaction().commit();
        em.close();
    }

    private static void pagination() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("frOM Person", Person.class);
        query.setFirstResult(7);
        query.setMaxResults(5);
        List<Person> people = query.getResultList();
        System.out.println(people.size());
        System.out.println(people);


        em.getTransaction().commit();
        em.close();
    }

    private static void orderBy() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//       Query query = em.createQuery("from Person");
        TypedQuery<Person> query = em.createQuery("from Person p order by p.lastName desc", Person.class);
        List<Person> personList = query.getResultList();
        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void whereClause() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p where p.lastName like '%n%'", Person.class);
        List<Person> personList = query.getResultList();
        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void queryParameters() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String firstName = "John"; // john' or delete from person
        //NOT Good
//        TypedQuery<Person> query = em.createQuery("from Person p where p.firstName = '"+firstName+"'", Person.class);

        //1. Named Parameters
//        TypedQuery<Person> query = em.createQuery("from Person p where p.firstName = :first", Person.class);
//        query.setParameter("first", firstName);

//        2. position
        TypedQuery<Person> query = em.createQuery("from Person p where p.lastName = ?1 and  p.firstName = ?0", Person.class);
        query.setParameter(0, firstName);
        query.setParameter(1, "Doe");

        List<Person> personList = query.getResultList();
        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void singleResult() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p where p.id = 123", Person.class);
//        Person p = query.getSingleResult();
//        System.out.println(p);
        query.setMaxResults(1);
        List<Person> p = query.getResultList();
        System.out.println(p.size());
//        System.out.println(p.get(0));
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) throws ParseException {
//        createQuery();
//        namedQuery();
//        polymorphicQuery();
//        aliasesQuery();
//        pagination();
//        orderBy();
//        whereClause();
//        queryParameters();
        singleResult();
        emf.close();
    }

}
