package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Valida;

public class ClienteBacking_old {
	private int codigo;
	private String nome;
	private String logradouro;
	private int numeroLogradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String cpf;
	private String rg;
	private String sexo;
	private String dataNascimento;
	private int idade;

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado = new Cliente();
	private List<SelectItem> itensClientes;
	static List<Cliente> listaCliente;
	private int scrollerPage, qtdLinhas, paginaTotal;

	private List<Cliente> listaClienteTotal;

	public int getCodigo() {
		return codigo;
	}

	public List<SelectItem> getItensClientes() {
		return itensClientes;
	}

	public void setItensClientes(List<SelectItem> itensClientes) {
		this.itensClientes = itensClientes;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String cadastraCliente() {
		return "";
	}

	public String consultaCliente() {
		listarCliente();
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	

	public String salvar() {
		if (validarDados()) {
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setLogradouro(logradouro);
			cliente.setNumeroLogradouro(numeroLogradouro);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setCep(cep);
			cliente.setTelefone(telefone);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setSexo(sexo);
			cliente.setDataNascimento(dataNascimento);
			cliente.setIdade(idade);

			ClienteController clienteController = new ClienteController();
			try {
				clienteController.salvar(cliente);
				limparDados();
				JSFUtil.addInfoMessage("Cliente salvo com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao salvar o cliente.");
			}
		}
		return "";
	}

	public void limparDados() {
		nome = null;
		logradouro = null;
		numeroLogradouro = 0;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		cpf = null;
		rg = null;
		sexo = null;
		dataNascimento = null;
		idade = 0;
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
		if (logradouro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigatório!");
			return false;
		}
		if (numeroLogradouro == 0) {
			JSFUtil.addInfoMessage("Informe o número, campo obrigatório!");
			return false;
		}
		if (bairro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o bairro, campo obrigatório!");
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
		if (cep.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o CEP, campo obrigatório!");
			return false;
		}
		if (telefone.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o telefone, campo obrigatório!");
			return false;
		}
		if (cpf.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cpf, campo obrigatório!");
			return false;
		}
		if (!Valida.validaCpf(cpf)) {
			JSFUtil.addInfoMessage("O CPF inserido é inválido.");
			return false;
		}
		if (rg.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o rg, campo obrigatório!");
			return false;
		}
		if (Valida.validarRg(rg)) {
			JSFUtil.addInfoMessage("O RG informado é inválido.");
			return false;
		}
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
		}
		if (dataNascimento.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a data de nascimento, campo obrigatório!");
			return false;
		}
		if (!Valida.validarData(dataNascimento)) {
			JSFUtil.addInfoMessage("A data de nascimento informada é inválida.");
			return false;
		}
		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
		}
		return true;
	}

	public String pesquisar() {
		listaCliente = new ArrayList<Cliente>();
		ClienteController clienteController = new ClienteController();
		try {
			listaCliente = clienteController.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	public void tratarClientes() {
		itensClientes = new ArrayList<SelectItem>();
		List<Cliente> listaClientes = new ClienteController().buscarTodos(); 
		itensClientes.add(new SelectItem("0", "Selecione um cliente..."));
		for (Cliente cliente : listaClientes) {
			itensClientes.add(new SelectItem(cliente.getNome(), cliente.getNome()));
		}
	}
	
	public List<SelectItem> carregarClientesCombo(){
		tratarClientes();
		return itensClientes;
	}

	public String excluir() {
		ClienteController clienteController = new ClienteController();
		clienteController.excluir(clienteSelecionado);
		pesquisar();
		JSFUtil.addInfoMessage("Cliente excluído com sucesso!");
		return "";
	}

	public String alterarCliente() {
		codigo = clienteSelecionado.getCodigo();
		nome = clienteSelecionado.getNome();
		logradouro = clienteSelecionado.getLogradouro();
		numeroLogradouro = clienteSelecionado.getNumeroLogradouro();
		bairro = clienteSelecionado.getBairro();
		cidade = clienteSelecionado.getCidade();
		estado = clienteSelecionado.getEstado();
		cep = clienteSelecionado.getCep();
		telefone = clienteSelecionado.getTelefone();
		cpf = clienteSelecionado.getCpf();
		rg = clienteSelecionado.getRg();
		sexo = clienteSelecionado.getSexo() + "";
		dataNascimento = clienteSelecionado.getDataNascimento();
		idade = clienteSelecionado.getIdade();
		return "alterar";
	}

	public String alterar() {
		if (validarDados()) {
			clienteSelecionado.setCodigo(codigo);
			clienteSelecionado.setNome(nome);
			clienteSelecionado.setLogradouro(logradouro);
			clienteSelecionado.setNumeroLogradouro(numeroLogradouro);
			clienteSelecionado.setBairro(bairro);
			clienteSelecionado.setCidade(cidade);
			clienteSelecionado.setEstado(estado);
			clienteSelecionado.setCep(cep);
			clienteSelecionado.setTelefone(telefone);
			clienteSelecionado.setCpf(cpf);
			clienteSelecionado.setRg(rg);
			clienteSelecionado.setSexo(sexo);
			clienteSelecionado.setDataNascimento(dataNascimento);
			clienteSelecionado.setIdade(idade);

			ClienteController clienteController = new ClienteController();
			clienteController.salvar(clienteSelecionado);
			limparDados();
			JSFUtil.addInfoMessage("Cliente alterado com sucesso!");
		}
		return "";
	}
	
	public String retornar() {
		if (this.scrollerPage > 1) {
			this.scrollerPage--;
			montarLista();
			return "atualizar";
		}else {
			JSFUtil.addInfoMessage("Não existem mais paginas para retornar.");
			return"";
		}
	}

	public String avancar() {
		if (this.scrollerPage < this.paginaTotal) {
			this.scrollerPage++;
			montarLista();
			return "atualizar";
		}else {
			JSFUtil.addInfoMessage("Não existem mais paginas para avançar.");
			return"";
		}
	}

	public String listarCliente() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		try {
			this.listaClienteTotal = new ClienteController().buscarTodos();
			if (this.listaClienteTotal.size() % 10 == 0) {
				this.paginaTotal = (this.listaClienteTotal.size() / 10);
			} else {
				this.paginaTotal = ((this.listaClienteTotal.size() / 10) + 1);
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os clientes.");
		}
		return "";
	}

	public void montarLista() {
		listaCliente = new ArrayList<Cliente>();
		int contador = 0, contCliente = 0;
		for (Cliente cliente : this.listaClienteTotal) {
			contCliente++;
			if (contador == this.qtdLinhas)
				break;
			if ((contCliente <= (this.qtdLinhas * this.scrollerPage))
					&& (contCliente > (this.qtdLinhas * (this.scrollerPage - 1)))) {
				listaCliente.add(cliente);
				contador++;
			}
		}
	}
}
