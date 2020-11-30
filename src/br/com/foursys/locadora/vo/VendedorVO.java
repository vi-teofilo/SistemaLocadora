package br.com.foursys.locadora.vo;

public class VendedorVO {

	private String nome;
	private String areaVenda;
	private String salario;
	
	public VendedorVO() {
		
	}
	
	public VendedorVO(String nome, String areaVenda, String salario) {
		
		this.nome = nome;
		this.areaVenda = areaVenda;
		this.salario = salario;
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
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	
}
