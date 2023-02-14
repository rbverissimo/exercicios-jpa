package modelo.heranca;

import javax.persistence.Entity;

@Entity
public class AlunoBolsista extends Aluno {
	
	private Double valorBolsa;
	
	public AlunoBolsista() {
		// TODO Auto-generated constructor stub
	}

	public AlunoBolsista(Double valorBolsa) {
		super();
		this.valorBolsa = valorBolsa;
	}


	public Double getValorBolsa() {
		return valorBolsa;
	}


	public void setValorBolsa(Double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}
	
	

}
