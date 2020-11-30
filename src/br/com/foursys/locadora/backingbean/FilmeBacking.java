package br.com.foursys.locadora.backingbean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.util.JSFUtil;

public class FilmeBacking {
	private int codigo;
	private String nome;
	private String genero;
	private String valor;
	private String disponivel;
	private String promocao;
	private String valorPromocao;

	private Filme filme = new Filme();
	private Filme filmeSelecionado = new Filme();
	private List<SelectItem> itensFilmes;
	static List<Filme> listaFilme = new ArrayList<Filme>();

	private int scrollerPage;

	

	public int getScrollerPage() {
		return scrollerPage;
	}
	

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public void setListaFilme(List<Filme> listaFilme) {
		FilmeBacking.listaFilme = listaFilme;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String cadastraFilme() {
		return "";
	}

	public String consultaFilme() {
		listarFilme();
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	public List<Filme> getListaFilme() {
		return listaFilme;
	}

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}
	

	public List<SelectItem> getItensFilmes() {
		return itensFilmes;
	}

	public void setItensFilmes(List<SelectItem> itensFilmes) {
		this.itensFilmes = itensFilmes;
	}

	public String salvar() {
		if (validarDados()) {
			Filme filme = new Filme();
			filme.setNome(nome);
			filme.setGenero(genero);
			filme.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filme.setDisponivel(disponivel);
			filme.setPromocao(promocao);
			filme.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));
			FilmeController filmeController = new FilmeController();
			try {
				filmeController.salvar(filme);
				limparDados();
				JSFUtil.addInfoMessage("Filme salvo com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao salvar o filme.");
			}

		}
		return "";
	}

	public void limparDados() {
		nome = null;
		genero = null;
		valor = null;
		disponivel = null;
		promocao = null;
		valorPromocao = null;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (genero.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o gênero, campo obrigatório!");
			return false;
		}
		if (valor.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o valor, campo obrigatório!");
			return false;
		}
		if (disponivel.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe se está disponível, campo obrigatório!");
			return false;
		}
		if (promocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe se está em promoção, campo obrigatório!");
			return false;
		}
		if (valorPromocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o valor da promocao, campo obrigatório!");
			return false;
		}
		return true;
	}

	public String pesquisar() {
		this.scrollerPage = 1;

		try {
			this.listaFilme = new FilmeController().buscarNome(nome);

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os filmes.");
		}
		return "";
	}
	
	
	
	public void tratarFilmes() {
		itensFilmes = new ArrayList<SelectItem>();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarDisponivel(); 
		for (Filme filme : listaFilmes) {
				listaFilme.add(filme);
				itensFilmes.add(new SelectItem(i+"",filme.getNome()));
				i++;
		}
	}
	
	public void tratarFilmesAlugado() {
		itensFilmes = new ArrayList<SelectItem>();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarAlugado(); 
		for (Filme filme : listaFilmes) {
			listaFilme.add(filme);
			itensFilmes.add(new SelectItem(i+"",filme.getNome()));
			i++;
		}
	}
	
	public List<SelectItem> carregarFilmesCombo() {
		tratarFilmes(); 
		return itensFilmes;
	}
	
	public List<SelectItem> carregarFilmesAlugadosCombo() {
		tratarFilmesAlugado(); 
		return itensFilmes;
	}

	public String formataMoeda(Double valor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(valor);
	}

	public String excluir() {
		FilmeController filmeController = new FilmeController();
		filmeController.excluir(filmeSelecionado);
		pesquisar();
		JSFUtil.addInfoMessage("Filme excluído com sucesso!");
		return "";
	}

	public String alterarFilme() {
		codigo = filmeSelecionado.getCodigo();
		nome = filmeSelecionado.getNome();
		genero = filmeSelecionado.getGenero();
		valor = filmeSelecionado.getValor() + "".replace(".", ",");
		disponivel = filmeSelecionado.getDisponivel();
		promocao = filmeSelecionado.getPromocao();
		valorPromocao = filmeSelecionado.getValorPromocao() + "".replace(".", ",");
		return "alterar";
	}

	public String alterar() {
		if (validarDados()) {
			filmeSelecionado.setCodigo(codigo);
			filmeSelecionado.setNome(nome);
			filmeSelecionado.setGenero(genero);
			filmeSelecionado.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filmeSelecionado.setDisponivel(disponivel);
			filmeSelecionado.setPromocao(promocao);
			filmeSelecionado.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));

			FilmeController filmeController = new FilmeController();
			filmeController.salvar(filmeSelecionado);
			limparDados();
			JSFUtil.addInfoMessage("Filme alterado com sucesso!");
		}
		return "";
	}
	
	

	public String listarFilme() {
		this.scrollerPage = 1;

		try {
			this.listaFilme = new FilmeController().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os clientes.");
		}
		return "";
	}
	

	
}
