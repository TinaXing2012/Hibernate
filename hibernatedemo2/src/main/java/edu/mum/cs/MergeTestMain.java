package edu.mum.cs;

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

    private void merge(){
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




    public static void main(String[] args) {
        MergeTestMain main = new MergeTestMain();
        main.persist();
        main.merge();

    }
}
