package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.dao.VendedorDAO;

public class TesteVendedor {

	public void salvar() {
		Vendedor vendedor = new Vendedor();
		
		vendedor.setNome("Doidinho");
		vendedor.setAreaVenda("Balconista");
		vendedor.setCidade("Santana");
		vendedor.setEstado("SP");
		vendedor.setSexo("M");
		vendedor.setIdade(16);
		vendedor.setSalario(1.000);
		
		VendedorDAO dao = new VendedorDAO();
		dao.salvar(vendedor);
		System.out.println("Vendedor salvo com sucesso!");
	}	
	
	public static void main(String[] args) {
		new TesteVendedor().salvar();
	}
}
