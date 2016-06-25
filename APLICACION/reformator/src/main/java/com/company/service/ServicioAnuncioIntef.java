package com.company.service;

import java.util.List;

import com.company.model.Anuncio;

public interface ServicioAnuncioIntef {
	public List<Anuncio> anuncios(); 
	public List<Anuncio> anuncios(String profesional); 
	public List<Anuncio> anunciosComunidad(String comunidadAutonoma); 
	public List<Anuncio> anuncios(String comunidadAutonoma,String profesional); 
	public Anuncio anuncio(String a); 
}
