package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		
		Produto produto = new Produto("Notebook", 2987.78);
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		dao.incluirAtomic(produto).fechar();
		
		System.out.println("ID do produto: " + produto.getId());
		
		
		
	}

}
