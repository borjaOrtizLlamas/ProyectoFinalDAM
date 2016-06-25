package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.Anuncio;

public class AnuncioDAOImpl implements AnuncioDAO {

	SessionFactory sessionFactory;
	
	public void insertarAnuncio(Anuncio anuncio) {
		sessionFactory.getCurrentSession().save(anuncio);
	}

	public void editarAnuncio(Anuncio anuncio) {
		sessionFactory.getCurrentSession().update(anuncio);
	}

	public List<Anuncio> devolverAnuncios() {
		return sessionFactory.getCurrentSession().createQuery("from Anuncio").list();
	}
	
	public void borrarAnuncio(Anuncio anuncio) {
		sessionFactory.getCurrentSession().delete(anuncio);
		
	}

	public Anuncio devolverAnuncio(String usuario) {
		List<Anuncio> anuncio = new ArrayList<Anuncio>();
		anuncio = sessionFactory.getCurrentSession().createQuery("from Anuncio where usuario=?").setParameter(0, usuario).list();
		if (anuncio.size() > 0)	return anuncio.get(0);
		else return null;
	}

	
	public List<Anuncio> anuncios() {
		return sessionFactory.getCurrentSession().createQuery("from Anuncio").list();
	}

	public List<Anuncio> anuncios(String profesional) {
		return sessionFactory.getCurrentSession().createQuery("from Anuncio where tipoProfesional=?").setParameter(0, profesional).list();
	}

	
	public List<Anuncio> anunciosComunidad(String comunidadAutonoma) {
		return sessionFactory.getCurrentSession().createQuery("from Anuncio where comunidadAutonoma=?").setParameter(0, comunidadAutonoma).list();
	}
	

	

	
	public List<Anuncio> anuncios(String comunidadAutonoma, String profesional) {
		return sessionFactory.getCurrentSession().createQuery("from Anuncio where comunidadAutonoma=? and tipoProfesional=?").setParameter(0, comunidadAutonoma).setParameter(1, profesional).list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
