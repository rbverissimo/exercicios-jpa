package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		//Consultando o usuário
		Usuario usuario = em.find(Usuario.class, 5L);
		System.out.println(usuario.getEmail());
		// Update no usuário
		usuario.setNome("Roberval");
		usuario.setEmail("roberval@lanche.com.br");
		
		//Método responsável pelo update: merge
		em.merge(usuario); 
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
