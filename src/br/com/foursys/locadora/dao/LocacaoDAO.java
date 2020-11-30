package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.util.HibernateUtil;

public class LocacaoDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<Locacao> buscarTodos() throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.addOrder(Order.asc("dataLocacao"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();

		return listaRetorno;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Locacao> buscarNome(String nome) throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.add(Restrictions.ilike("nomeFilme", nome + "%"));
		criteria.addOrder(Order.asc("dataLocacao"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();

		return listaRetorno;
	}

	public Locacao buscarPorCodigo(int codigo) throws Exception {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Locacao filme = (Locacao) sessao.get(Locacao.class, codigo);
		return filme;
	}
}
