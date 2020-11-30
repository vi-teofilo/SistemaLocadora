package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.vo.ClienteVO;

public class ClienteController {

	public void salvar(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.excluir(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> buscarTodos(){
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Cliente> buscarNome(String nome){
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	public ArrayList<ClienteVO> retornaClientes(){
		ArrayList<ClienteVO> listaRetorno = new ArrayList<ClienteVO>();
		try {
			ArrayList<Cliente> listaClientes = new ClienteDAO().buscarTodos();
			for (Cliente cliente : listaClientes) {
				ClienteVO vo = new ClienteVO();
				vo.setNome(cliente.getNome());
				vo.setTelefone(cliente.getTelefone());
				vo.setDataNascimento(cliente.getDataNascimento());
				vo.setCidade(cliente.getCidade());
				listaRetorno.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return listaRetorno;
		
	}

}
