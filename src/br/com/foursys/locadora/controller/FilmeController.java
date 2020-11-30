package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.vo.FilmeVO;

public class FilmeController {

	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.excluir(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Filme> buscarTodos(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarNome(String nome){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarDisponivel(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		try {
			listaRetorno = dao.buscarDisponivel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarAlugado(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		try {
			listaRetorno = dao.buscarAlugado();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	public ArrayList<FilmeVO> retornaFilmes(){
		ArrayList<FilmeVO> listaRetorno = new ArrayList<FilmeVO>();
		try {
			ArrayList<Filme> listaFilmes = new FilmeDAO().buscarTodos();
			for (Filme cliente : listaFilmes) {
				FilmeVO vo = new FilmeVO();
				vo.setCodigo(cliente.getCodigo()+"");
				vo.setNome(cliente.getNome());
				vo.setGenero(cliente.getGenero());
				
				listaRetorno.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return listaRetorno;
		
	}

}
