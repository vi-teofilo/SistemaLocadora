package br.com.foursys.locadora.vo;
// classe responsavel por visualizar o que vamos ter no relatorio 
public class ClienteVO {
	
	private String nome;
	private String telefone;
	private String dataNascimento;
	private String cidade;
	
	public ClienteVO() {
		
	}
	
	public ClienteVO(String nome, String telefone, String dataNascimento, String cidade) {
		
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
