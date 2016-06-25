/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Usuario {
	
    private String usuario;
    
    private String contrasena;
    
    private Boolean habilitado; 
    
    private String email; 
    
    
    private Set<RolUsuarios> rolUsuario = new HashSet<RolUsuarios>(0);

    
    public Usuario(){
    	
    }
    public Usuario(String usuario, String contrasena, Boolean habilitado, String email) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.habilitado = habilitado;
		this.email = email;
	}

	public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasena=" + contrasena + ", habilitado=" + habilitado + ", email="
				+ email + "]";
	}
	public Set<RolUsuarios> getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(Set<RolUsuarios> rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	
    
    
    
    
}
