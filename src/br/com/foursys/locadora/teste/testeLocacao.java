package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.JSFUtil;

public class testeLocacao {
	
	
	public void salvar() {
		java.util.Date atual = new java.util.Date();
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
		Locacao locacao = new Locacao();
		locacao.setNomeCliente("Teste");
		locacao.setNomeFilme("LALALA");
		locacao.setValorFilme(Double.parseDouble("10.5"));
		locacao.setDataLocacao(formater.format(atual));

		LocacaoController locacaoController = new LocacaoController();
		try {
			locacaoController.salvar(locacao);
			JSFUtil.addInfoMessage("Locação salva com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao salvar a locação.");
		}
	}

	public static void main(String[] args) {
		new testeLocacao().salvar();

	}

}
