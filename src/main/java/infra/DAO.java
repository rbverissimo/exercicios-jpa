package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	 
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	//o EMF é estático porque ele vai ser usado em todos os DAOs
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch(Exception e) {
			//TODO construir um log
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	
	public DAO<E> fecharT(){	
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this; 
	}
	
	public DAO<E> incluirAtomic(E entidade){
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	// limit-offset: qted-deslocamento (para paginação)
	public List<E> obterTodos(int qntde, int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qntde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	} 
	
	// um método de obter com uma convenção
	public List<E> obterTodos(){
		return this.obterTodos(10, 0); 
	}
	
	public void fechar() {
		em.close();
	}
}
