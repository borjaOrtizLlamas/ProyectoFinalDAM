package com.company.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.company.model.Anuncio;

@Repository

public interface AnuncioDAO {

	@Transactional(readOnly = false)
	public void insertarAnuncio(Anuncio anuncio);

	@Transactional(readOnly = false)
	public void editarAnuncio(Anuncio anuncio);

	@Transactional(readOnly = true)
	public List<Anuncio> devolverAnuncios();

	@Transactional(readOnly = true)
	public Anuncio devolverAnuncio(String usuario);

	@Transactional(readOnly = true)
	public List<Anuncio> anuncios();

	@Transactional(readOnly = true)
	public List<Anuncio> anuncios(String profesional);

	@Transactional(readOnly = true)
	public List<Anuncio> anunciosComunidad(String comunidadAutonoma);

	@Transactional(readOnly = true)
	public List<Anuncio> anuncios(String comunidadAutonoma, String profesional);
	
	@Transactional(readOnly = false)
	public void borrarAnuncio(Anuncio anuncio);

	
}
