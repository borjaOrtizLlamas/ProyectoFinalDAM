/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;
import org.hibernate.annotations.GenericGenerator;  
import org.hibernate.annotations.Parameter;  

public class Anuncio {

    private String usuario;
    
    private Usuario usuarioClase;
    
    private String nombreEmpresa;
    
    private int numeroTelefono;
    
    private int numeroTelefono2;
    
    private Double precio;
    
    private String titulo;
    
    private String texto;
    
    private String comunidadAutonoma;
    
    private String imagen;
    
    private String tipoProfesional;
 
    
    public Anuncio() {
	}

    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioClase() {
        return usuarioClase;
    }

    public void setUsuarioClase(Usuario usuarioClase) {
        this.usuarioClase = usuarioClase;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getNumeroTelefono2() {
        return numeroTelefono2;
    }

    public void setNumeroTelefono2(int numeroTelefono2) {
        this.numeroTelefono2 = numeroTelefono2;
    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public String getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(String tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}




}
