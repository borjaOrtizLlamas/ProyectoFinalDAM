/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import java.net.PasswordAuthentication;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.company.dao.UsuarioDAO;
import com.company.model.RolUsuarios;
import com.company.model.Usuario;

public class ServicioUsuarios implements UserDetailsService {
	
    private UsuarioDAO userDao; 
    
    private String contraseña; 
    
	public UserDetails loadUserByUsername(final String username)    
			throws UsernameNotFoundException {
		Usuario user = userDao.devolverUsuario(username);
		if(user == null) throw new UsernameNotFoundException("usuario no encontrado"); 
		if(!contraseña.equals(user.getContrasena())) throw new AuthenticationCredentialsNotFoundException("contraseña mal puesta") ; 
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRolUsuario());
		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(Usuario user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsuario(), user.getContrasena() , true, true, true, true, authorities); 
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<RolUsuarios> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		for(RolUsuarios b : roles){
			setAuths.add(new SimpleGrantedAuthority(b.getRole()));
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	public UsuarioDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UsuarioDAO userDao) {
		this.userDao = userDao;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


}