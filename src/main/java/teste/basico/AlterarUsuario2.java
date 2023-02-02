package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		Usuario usuario = em.find(Usuario.class, 5L);
		System.out.println(usuario.getEmail());
		
		// Update no usuário
		usuario.setNome("Roberval Alterado");
		
		// em.merge(usuario); 
		/* Mesmo sem o merge, após fazer uma consulta no id 5
		 * o JPA mantém o resultado da consulta em um estado de gerenciamento
		 * Se houver qualquer alteração no objeto o Data Mapper alterará também 
		 * o banco de dados
		 */
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
