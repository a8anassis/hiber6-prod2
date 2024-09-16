package gr.aueb.cf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school2PU");
        EntityManager em = emf.createEntityManager();



        em.close();
        emf.close();
    }
}
