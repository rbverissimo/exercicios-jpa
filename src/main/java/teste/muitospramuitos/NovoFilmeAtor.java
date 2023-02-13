package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		
		Filme f1 = new Filme("Os parças", 8.7);
		Filme f2 = new Filme ("Quem não tem as manha", 7.3);
		
		Ator a1 = new Ator("Mangual deMangues");
		Ator a2 = new Ator("Maria Santa");
		
		f1.adicionarAtor(a1);
		f1.adicionarAtor(a2);
		f2.adicionarAtor(a1);		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomic(f1);
		dao.incluirAtomic(f2);
		
		
	}

}
