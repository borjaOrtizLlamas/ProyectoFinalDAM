package com.company.model;

public class UsuarioFormulario {
    private String usuario;
    private String contrasena; 
    private String contrasena2; 
    private String email; 
    private String email2;
    
	public UsuarioFormulario() {
	}

    
    
    
	public UsuarioFormulario(String usuario, String contrasena, String contrasena2, String email, String email2) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.contrasena2 = contrasena2;
		this.email = email;
		this.email2 = email2;
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
	public String getContrasena2() {
		return contrasena2;
	}
	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	} 

    

}
