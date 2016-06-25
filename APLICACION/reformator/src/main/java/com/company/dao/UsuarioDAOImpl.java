package com.company.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.Anuncio;
import com.company.model.RolUsuarios;
import com.company.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	SessionFactory sessionFactory;

	public void registroUsuario(Usuario usuario) {
		Set<RolUsuarios> rol = new HashSet<RolUsuarios>(0);
		RolUsuarios r = new RolUsuarios(); 
		r.setRole("ROL_USUARIO");
		r.setUsuario(usuario);
		rol.add(r); 
		usuario.setRolUsuario(rol);
		sessionFactory.getCurrentSession().save(usuario);
	}

	public void editarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	public Usuario devolverUsuario(String usuario) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = sessionFactory.getCurrentSession().createQuery("from Usuario where usuario=?").setParameter(0, usuario).list();
	
		if (usuarios.size() > 0) return usuarios.get(0);
		else return null; 
	}

	public List<Usuario> todosLosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = sessionFactory.getCurrentSession().createQuery("from Usuario").list();

		if (usuarios.size() > 0) return usuarios;
		else return null; 
	}

	public void borrarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().delete(usuario);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
}
