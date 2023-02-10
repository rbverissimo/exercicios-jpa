package teste.muitospramuitos;

import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {
		
		Tio tio1 = new Tio("Rogério");
		Tio tio2 = new Tio("Jamal");
		
		Sobrinho s1 = new Sobrinho("Jonas");
		Sobrinho s2 = new Sobrinho("Samanta");
		
		//Ambos relacionados em suas listas; 
		tio1.getSobrinhos().add(s1);
		tio1.getSobrinhos().add(s2);
		s1.getTios().add(tio1);
		s2.getTios().add(tio1);
		
		
		tio2.getSobrinhos().add(s1);
		tio2.getSobrinhos().add(s2);
		s1.getTios().add(tio2);
		s2.getTios().add(tio2);
		
	}
}
