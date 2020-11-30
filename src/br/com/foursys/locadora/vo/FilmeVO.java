package br.com.foursys.locadora.vo;

public class FilmeVO {

	private String codigo;
	private String nome;
	private String genero;
	
	
	public FilmeVO() {
		
	}
	public FilmeVO(String codigo, String nome, String genero) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	
	
	
	
	
}
