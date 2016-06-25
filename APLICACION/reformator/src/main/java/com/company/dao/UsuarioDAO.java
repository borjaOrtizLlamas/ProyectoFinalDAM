package com.company.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.company.model.*;

@Repository
public interface UsuarioDAO {
	
	@Transactional(readOnly=false)
	public void registroUsuario(Usuario usuario);
	
	@Transactional(readOnly=false)
	public void borrarUsuario(Usuario usuario);

	@Transactional(readOnly=false)
	public void editarUsuario(Usuario usuario);

	@Transactional(readOnly=true)
	public Usuario devolverUsuario(String usuario);

	@Transactional(readOnly=true)
	public List<Usuario> todosLosUsuarios();

}
