package br.com.foursys.locadora.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.LocacaoDAO;
import br.com.foursys.locadora.vo.LocacaoVO;

public class LocacaoController {

	public void salvar(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.salvar(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.excluir(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Locacao> buscarTodos(){
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Locacao> buscarNome(String nome){
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	public ArrayList<LocacaoVO> retornaLocacoes() {
        ArrayList<LocacaoVO> listaVO = new ArrayList<LocacaoVO>();
        try {
            ArrayList<Locacao> locacoes = new LocacaoDAO().buscarTodos();
            for (Locacao locacao : locacoes) {
                LocacaoVO vo = new LocacaoVO();
                vo.setCliente(locacao.getNomeCliente());
                vo.setFilme(locacao.getNomeFilme());
                vo.setData(formataData(locacao.getDataLocacao()));
                listaVO.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVO;
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

}
