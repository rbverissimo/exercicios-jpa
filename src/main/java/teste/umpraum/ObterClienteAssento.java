package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {
	
	public static void main(String[] args) {
		
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		
		Cliente cliente = daoCliente.obterPorID(1L);
		String consultaAssento = cliente.getAssento().getNome();
		System.out.println(consultaAssento);
		consultaAssento = cliente.getAssento().getCliente().getNome();
		System.out.println(consultaAssento);
		
		daoCliente.fechar();
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.obterPorID(5L);
		String consultaCliente = assento.getCliente().getNome();
		System.out.println(consultaCliente);
		
		daoAssento.fechar();
		
	}

}
