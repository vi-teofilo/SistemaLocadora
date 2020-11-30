package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;

public class TesteCliente {

	public void salvar() {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Doidinho");
		cliente.setLogradouro("Rua joao");
		cliente.setNumeroLogradouro(10);
		cliente.setBairro("Jd são luiz");
		cliente.setCidade("Santana");
		cliente.setEstado("SP");
		cliente.setCep("11.116-165");
		cliente.setTelefone("(11)4151-5654");
		cliente.setCpf("421.365.145-23");
		cliente.setRg("45.165.123");
		cliente.setSexo("M");
		cliente.setDataNascimento("02/02/2000");
		cliente.setIdade(16);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		System.out.println("Cliente salvo com sucesso!");
	}	
	
	public static void main(String[] args) {
		new TesteCliente().salvar();
	}
}
