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


    public static void main(String[] args) throws ParseException {
        createQuery();

        emf.close();
    }

}
