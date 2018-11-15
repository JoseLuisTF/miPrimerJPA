package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Carrera;



public class prueba {


		public static void main(String[] args) {
			Carrera c = new Carrera();
			c.setCodigo("122");
			c.setNombre("Contaduria Publica");
			c.setSemestres(10);
			c.setCreditos(152);
			
			EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("miPrimerJPA");
			EntityManager em = emf.createEntityManager();
			try {
				
				
				em.getTransaction().begin();
				em.persist(c);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
			}
		}

}