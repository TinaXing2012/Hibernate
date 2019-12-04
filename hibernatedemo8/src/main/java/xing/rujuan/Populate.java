package xing.rujuan;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        for (int x = 0; x < 100000; x++) {
            Owner owner = new Owner("Frank" + x);
            List<Pet> petlist = new ArrayList<Pet>();
            for (int y = 0; y < 10; y++) {
                Pet pet = new Pet("Baby" + x + "-" + y);
                petlist.add(pet);
            }
            owner.setPets(petlist);
            em.persist(owner);
        }

        em.getTransaction().commit();
        em.close();
    }

}
