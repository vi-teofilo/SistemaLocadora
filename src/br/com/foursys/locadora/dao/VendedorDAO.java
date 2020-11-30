package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.util.HibernateUtil;

public class VendedorDAO extends GenericDAO{

	 @SuppressWarnings("unchecked")
	    public ArrayList<Vendedor> buscarTodos() throws Exception {

	        ArrayList<Vendedor> listaRetorno = new ArrayList<Vendedor>();
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	        Criteria criteria = sessao.createCriteria(Vendedor.class);
	        criteria.addOrder(Order.asc("codigo"));
	        listaRetorno = (ArrayList<Vendedor>) criteria.list();

	        return listaRetorno;
	    }

	    @SuppressWarnings("unchecked")
		public ArrayList<Vendedor> buscarNome(String nome) throws Exception {

	        ArrayList<Vendedor> listaRetorno = new ArrayList<Vendedor>();
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	        Criteria criteria = sessao.createCriteria(Vendedor.class);
	        criteria.add(Restrictions.ilike("nome", nome + "%"));
	        criteria.addOrder(Order.asc("nome"));
	        listaRetorno = (ArrayList<Vendedor>) criteria.list();

	        return listaRetorno;
	    }

	    public Vendedor buscarPorCodigo(int codigo) throws Exception {
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	        Vendedor filme = (Vendedor) sessao.get(Vendedor.class, codigo);
	        return filme;
	    }
}
