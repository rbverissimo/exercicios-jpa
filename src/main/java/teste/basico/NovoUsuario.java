package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Ronaldo", "ronaldo@lanche.com.br");
		Usuario novoUsuario2 = new Usuario("Edivaldo", "edivaldo@lanche.com.br");
		Usuario novoUsuario3 = new Usuario("Cleiton", "cleiton@lanche.com.br");
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.persist(novoUsuario2);
		em.persist(novoUsuario3);
		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

}
