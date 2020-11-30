package br.com.foursys.locadora.backingbean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.VendedorController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Valida;

public class VendedorBacking {
	private int codigo;
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private String sexo;
	private int idade;
	private String salario;

	private Vendedor vendedor = new Vendedor();
	private Vendedor vendedorSelecionado = new Vendedor();
	private List<Vendedor> listaVendedor;

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

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

	public List<Vendedor> getListaVendedor() {
		return listaVendedor;
	}

	public void setListaVendedor(List<Vendedor> listaVendedor) {
		this.listaVendedor = listaVendedor;
	}

	public String cadastraVendedor() {
		return "";
	}

	public String consultaVendedor() {
		listarVendedor();
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	public String salvar() {
		if (validarDados()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(nome);
			vendedor.setAreaVenda(areaVenda);
			vendedor.setCidade(cidade);
			vendedor.setEstado(estado);
			vendedor.setSexo(sexo);
			vendedor.setIdade(idade);
			vendedor.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));

			VendedorController vendedorController = new VendedorController();
			try {
				vendedorController.salvar(vendedor);
				limparDados();
				JSFUtil.addInfoMessage("Vendedor salvo com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao salvar o vendedor.");
			}

		}
		return "";
	}

	public void limparDados() {
		nome = null;
		areaVenda = null;
		cidade = null;
		estado = null;
		sexo = null;
		idade = 0;
		salario = null;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (Valida.validaNome(nome)) {
			JSFUtil.addInfoMessage("O nome informado contém caracteres inválidos.");
			return false;
		}
		if (areaVenda.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a área de venda, campo obrigatório!");
			return false;
		}
		if (cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a cidade, campo obrigatório!");
			return false;
		}
		if (estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório!");
			return false;
		}
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
		}
		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
		}
		if (salario.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o salário, campo obrigatório!");
			return false;
		}
		return true;
	}

	public String pesquisar() {
		this.scrollerPage = 1;

		try {
			this.listaVendedor = new VendedorController().buscarNome(nome);

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores.");
		}
		return "";
	}

	public String excluir() {
		VendedorController vendedorController = new VendedorController();
		vendedorController.excluir(vendedorSelecionado);
		pesquisar();
		JSFUtil.addInfoMessage("Vendedor excluído com sucesso!");
		return "";
	}

	public String alterarVendedor() {
		codigo = vendedorSelecionado.getCodigo();
		nome = vendedorSelecionado.getNome();
		areaVenda = vendedorSelecionado.getAreaVenda();
		cidade = vendedorSelecionado.getCidade();
		estado = vendedorSelecionado.getEstado();
		sexo = vendedorSelecionado.getSexo() + "";
		idade = vendedorSelecionado.getIdade();
		salario = vendedorSelecionado.getSalario() + "".replace(".", ",");
		return "alterar";
	}

	public String alterar() {
		if (validarDados()) {
			vendedorSelecionado.setCodigo(codigo);
			vendedorSelecionado.setNome(nome);
			vendedorSelecionado.setAreaVenda(areaVenda);
			vendedorSelecionado.setCidade(cidade);
			vendedorSelecionado.setEstado(estado);
			vendedorSelecionado.setSexo(sexo);
			vendedorSelecionado.setIdade(idade);
			vendedorSelecionado.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));

			VendedorController vendedorController = new VendedorController();
			vendedorController.salvar(vendedorSelecionado);
			limparDados();
			JSFUtil.addInfoMessage("Vendedor alterado com sucesso!");
		}
		return "";
	}

	public String formataMoeda(Double valor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(valor);
	}

	
	public String listarVendedor() {
		this.scrollerPage = 1;

		try {
			this.listaVendedor = new VendedorController().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores.");
		}
		return "";
	}

	
}
