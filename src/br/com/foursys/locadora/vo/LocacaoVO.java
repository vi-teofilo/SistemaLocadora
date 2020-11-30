package br.com.foursys.locadora.vo;
// classe responsavel por visualizar o que vamos ter no relatorio 
public class LocacaoVO {
	
	private String cliente;
	private String filme;
	private String data;
	
	
	public LocacaoVO() {
		
	}


	public LocacaoVO(String cliente, String filme, String data) {
		
		this.cliente = cliente;
		this.filme = filme;
		this.data = data;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getFilme() {
		return filme;
	}


	public void setFilme(String filme) {
		this.filme = filme;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	
}
