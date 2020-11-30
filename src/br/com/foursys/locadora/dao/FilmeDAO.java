package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.util.HibernateUtil;

public class FilmeDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Filme> buscarTodos() throws Exception {

        ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Filme.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Filme>) criteria.list();

        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
	public ArrayList<Filme> buscarNome(String nome) throws Exception {

        ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Filme.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Filme>) criteria.list();

        return listaRetorno;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Filme> buscarDisponivel() throws Exception {
    	
    	ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
    	Session sessao = HibernateUtil.getSessionFactory().openSession();
    	Criteria criteria = sessao.createCriteria(Filme.class);
    	criteria.add(Restrictions.ilike("disponivel", "SIM"));
    	criteria.addOrder(Order.asc("nome"));
    	listaRetorno = (ArrayList<Filme>) criteria.list();
    	
    	return listaRetorno;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Filme> buscarAlugado() throws Exception {
    	
    	ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
    	Session sessao = HibernateUtil.getSessionFactory().openSession();
    	Criteria criteria = sessao.createCriteria(Filme.class);
    	criteria.add(Restrictions.ilike("disponivel", "NAO"));
    	criteria.addOrder(Order.asc("nome"));
    	listaRetorno = (ArrayList<Filme>) criteria.list();
    	
    	return listaRetorno;
    }

    public Filme buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Filme filme = (Filme) sessao.get(Filme.class, codigo);
        return filme;
    }

}
