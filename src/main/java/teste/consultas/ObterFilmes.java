package teste.consultas;

import java.util.List;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class ObterFilmes {
	
	public static void main(String[] args) {
		
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar(
				"obterFilmesComNotaMaiorQue", "nota", 8.5);
		
		for(Filme f: filmes) {
			System.out.println(f.getNome() + "=> " + f.getNota());
			
			for(Ator ator: f.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
		
	}

}
