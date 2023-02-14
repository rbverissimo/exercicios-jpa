package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {
	
	public static void main(String[] args) {
		
		DAO<Aluno> alunoDAO = new DAO<>();
		
		Aluno aluno1 = new Aluno(100L, "João Gomes"); 
		AlunoBolsista aluno2 = new AlunoBolsista(101L, "Maria Ribeiro", 349.9);
		
		alunoDAO.incluirAtomic(aluno1);
		alunoDAO.incluirAtomic(aluno2);
		
		alunoDAO.fechar();
	}
}
