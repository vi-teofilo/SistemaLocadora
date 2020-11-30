package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;

public class TesteFilme {

	public void salvar() {
		Filme filme = new Filme();
		
		filme.setNome("A Era do Gelo");
		filme.setGenero("Infantil");
		filme.setValor(10.5);
		filme.setDisponivel("SIM");
		filme.setPromocao("NAO");
		filme.setValorPromocao(8.25);
		
		FilmeDAO dao = new FilmeDAO();
		dao.salvar(filme);
		System.out.println("Filme salvo com sucesso!");
	}	
	
	public static void main(String[] args) {
		new TesteFilme().salvar();
	}
}
