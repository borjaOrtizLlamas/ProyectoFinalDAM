package com.company.service;

import com.company.model.Anuncio;
import com.company.model.Usuario;

public interface RegistroYEdicionServicio {

	public void registro(Usuario usuario); 
	public Usuario devolverUsuario(String usuario); 
	public Anuncio devolverAnuncio(String usuario); 
	public void editarUsuario(Usuario usuario); 
	public void editarAnuncio(Anuncio anuncio);
	public void insertarAnuncio(Anuncio anuncio);
	public void borrarAnuncio(Anuncio anuncio);
	
}
