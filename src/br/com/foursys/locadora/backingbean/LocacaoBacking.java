package br.com.foursys.locadora.backingbean;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.JSFUtil;

public class LocacaoBacking {

	private int codigo;
	private String nomeCliente;
	private String nomeFilme;
	private String valorFilme;

	private Locacao locacao = new Locacao();
	private Locacao locacaoSelecionado = new Locacao();
	private List<Locacao> listaLocacao;
	private Filme filme;
	private int i;
	private List<Filme> listaFilmes;

	private int scrollerPage;
	
	
	public int getScrollerPage() {
		return scrollerPage;
	}
	

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Locacao getLocacaoSelecionado() {
		return locacaoSelecionado;
	}

	public void setLocacaoSelecionado(Locacao locacaoSelecionado) {
		this.locacaoSelecionado = locacaoSelecionado;
	}

	public List<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public void setListaLocacao(List<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getValorFilme() {
		return valorFilme;
	}

	public void setValorFilme(String valorFilme) {
		this.valorFilme = valorFilme;
	}

	public String efetuarLocacao() {

		return "";
	}

	public String consultaLocacao() {
		listarLocacao();
		return "";
	}
	
	public String devolveLocacao() {
		listarLocacao();
		return "";
	}

	public String salvar() {
		if (validarDados()) {
			java.util.Date atual = new java.util.Date();
			java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
			Locacao locacao = new Locacao();
			locacao.setNomeCliente(nomeCliente);
			locacao.setNomeFilme(nomeFilme);
			locacao.setValorFilme(Double.parseDouble(valorFilme.replace(",", ".")));
			locacao.setDataLocacao(formater.format(atual));
			filme.setDisponivel("NAO");
			LocacaoController locacaoController = new LocacaoController();
			FilmeController filmeController = new FilmeController();
			try {
				locacaoController.salvar(locacao);
				filmeController.salvar(filme);
				limparDados();
				i++;
				JSFUtil.addInfoMessage("Locação salva com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao salvar a locação.");
			}
		}
		return "salvar";
	}

	public boolean validarDados() {
		if (nomeCliente.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome do cliente, campo obrigatório!");
			return false;
		}
		if (nomeFilme.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome do filme, campo obrigatório!");
			return false;
		}
		if (valorFilme.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o valor do filme, campo obrigatório!");
			return false;
		}
		return true;
	}


	public String formataMoeda(Double valor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(valor);
	}

	public String formataData(String data) {
		try {
			Date dataTimestamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").parse(data);
			String dataDate = new SimpleDateFormat("dd/MM/yyyy").format(dataTimestamp);
			return dataDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String cancelar() {
		limparDados();
		return "cancelar";
	}

	public String sair() {
		limparDados();
		return "sair";
	}

	public String pesquisar() {
		this.scrollerPage = 1;

		try {
			this.listaLocacao = new LocacaoController().buscarNome(nomeCliente);

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Locaçoes.");
		}
		return "";
	}


	public void limparDados() {
		nomeCliente = null;
		nomeFilme = null;
		valorFilme = null;
		listaFilmes = new ArrayList<Filme>();

	}

	

	public String listarLocacao() {
		this.scrollerPage = 1;

		try {
			this.listaLocacao = new LocacaoController().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Locações.");
		}
		return "";
	}
	

	
	public String devolverFilme() {
        if (validarDevolucao()) {
            filme.setDisponivel("SIM");
            FilmeController fc = new FilmeController();
            fc.salvar(filme);
        }
        return "devolver";
    }

 

    public boolean validarDevolucao() {
        if (nomeFilme.trim().equals("")) {
            JSFUtil.addInfoMessage("Informe o nome do filme, campo obrigatório!");
            return false;
        }
        return true;
    }

	public String popularCliente(ValueChangeEvent e) {
		nomeCliente = e.getNewValue().toString();
		return "";
	}

	public String popularFilme(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();
		i = 1;
		String auxIndice = e.getNewValue().toString();
		listaFilmes = filmeController.buscarDisponivel();
		filme = listaFilmes.get(Integer.parseInt(auxIndice) - i);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("SIM")) {
			this.valorFilme = filme.getValorPromocao() + "";
		} else {
			this.valorFilme = filme.getValor() + "";
		}
		return "";
	}
	
	public String popularFilmeAlugado(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();
		i = 1;
		String auxIndice = e.getNewValue().toString();
		listaFilmes = filmeController.buscarAlugado();
		filme = listaFilmes.get(Integer.parseInt(auxIndice) - i);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("SIM")) {
			this.valorFilme = filme.getValorPromocao() + "";
		} else {
			this.valorFilme = filme.getValor() + "";
		}
		return "";
	}
}
