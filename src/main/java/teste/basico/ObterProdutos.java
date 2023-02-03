package teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {
	
	
	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.obterTodos();
		
		for(Produto p: produtos) {
			System.out.println(p.toString());
		}
		
		double precoTotal = produtos.stream()
								.map(p -> p.getPreco())
								.reduce(0.0, (t, p) -> t + p)
								.doubleValue();
		System.out.println("O valor total de produtos é R$ " + precoTotal);
		
		dao.fechar();
		
	}

}
