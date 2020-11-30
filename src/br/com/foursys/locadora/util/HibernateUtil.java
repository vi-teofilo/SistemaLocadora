/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author pbido
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    
	public static SessionFactory buildSessionFactory() {
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
