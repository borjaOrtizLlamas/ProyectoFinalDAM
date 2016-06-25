package com.company.service;

import java.util.List;

import com.company.dao.AnuncioDAO;
import com.company.model.Anuncio;

public class ServicioAnuncio implements ServicioAnuncioIntef{

	AnuncioDAO anuncioDAO; 
	
	public List<Anuncio> anuncios() {
		return anuncioDAO.anuncios();
	}

	public List<Anuncio> anuncios(String profesional) {
		return anuncioDAO.anuncios(profesional);
	}

	public List<Anuncio> anunciosComunidad(String comunidadAutonoma) {
		return anuncioDAO.anunciosComunidad(comunidadAutonoma);
	}

	public List<Anuncio> anuncios(String comunidadAutonoma, String profesional) {
		return anuncioDAO.anuncios(comunidadAutonoma, profesional);
	}

	public Anuncio anuncio(String id) {
		return anuncioDAO.devolverAnuncio(id);
	}

	
	public AnuncioDAO getAnuncioDAO() {
		return anuncioDAO;
	}

	public void setAnuncioDAO(AnuncioDAO anuncioDAO) {
		this.anuncioDAO = anuncioDAO;
	}

	
	
}
