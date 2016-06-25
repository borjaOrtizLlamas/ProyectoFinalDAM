package com.company.service;

import com.company.dao.AnuncioDAO;
import com.company.dao.UsuarioDAO;
import com.company.model.Anuncio;
import com.company.model.Usuario;

public class RegistroYEdicionServicioImpl implements RegistroYEdicionServicio{

	private UsuarioDAO usuarioDAO; 
	private AnuncioDAO anuncioDAO; 
	
	
	public void registro(Usuario usuario) {
		usuarioDAO.registroUsuario(usuario);
	}
	
	public void borrarAnuncio(Anuncio anuncio) {
		anuncioDAO.borrarAnuncio(anuncio); 
	}

	public Anuncio devolverAnuncio(String usuario) {
		return anuncioDAO.devolverAnuncio(usuario);
	}
	public void insertarAnuncio(Anuncio anuncio) {
		anuncioDAO.insertarAnuncio(anuncio);
	}
	
	public void editarAnuncio(Anuncio anuncio) {
		 anuncioDAO.editarAnuncio(anuncio);
	}

	
	public Usuario devolverUsuario(String usuario) {
		return usuarioDAO.devolverUsuario(usuario); 
	}
	
	public void editarUsuario(Usuario usuario){
		usuarioDAO.editarUsuario(usuario);
	}
	
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public AnuncioDAO getAnuncioDAO() {
		return anuncioDAO;
	}

	public void setAnuncioDAO(AnuncioDAO anuncioDAO) {
		this.anuncioDAO = anuncioDAO;
	}






	


	
}
