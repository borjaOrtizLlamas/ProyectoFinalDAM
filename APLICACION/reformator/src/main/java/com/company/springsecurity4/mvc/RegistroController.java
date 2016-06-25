package com.company.springsecurity4.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import java.io.File;
import java.sql.Blob;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.hibernate.Hibernate;

import com.company.model.Anuncio;
import com.company.model.Usuario;
import com.company.model.UsuarioFormulario;
import com.company.service.Carpetas;
import com.company.service.RegistroYEdicionServicio;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroYEdicionServicio registroYEdicionServicio;
	
	@Autowired
	Carpetas carpetas;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (auth instanceof AnonymousAuthenticationToken) {
			   model.put("usuario", new UsuarioFormulario());
			return "registro";
		} else
			return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registro(@ModelAttribute("usuario") UsuarioFormulario usuario, BindingResult result,
			Map<String, Object> model) {
		model.put("usuario", new UsuarioFormulario());
		if (usuario.getContrasena().equals(usuario.getContrasena2())	&& usuario.getEmail().equals(usuario.getEmail2())) {
			try {
				
				registroYEdicionServicio.registro(new Usuario(usuario.getUsuario(), usuario.getContrasena(), true, usuario.getEmail()));
				return "redirect:/registro/anuncio";
			} catch (Exception e) {
				if (e.getMessage().contains("could not execute statement"))
					model.put("error", "Usuario repetido, cambie de usuario");
				else
					model.put("error", "correo repetido, cambie de correo");
				
				System.out.println("aqui esta el error " + e.getMessage());
				return "registro";
			}
		} else {
			model.put("error", "Introduzca bien los datos,los campos de correo o contraseña no coinciden");
			return "registro";
		}
	}

	@RequestMapping(value = "/anuncio", method = RequestMethod.GET)
	public String anuncio(Map<String, Object> model) {
		Anuncio a = registroYEdicionServicio.devolverAnuncio(nombreUsuarioLogeado());

		if (a == null) {
			System.out.println("pasamos por /registro/anuncio");
			a = new Anuncio();
			a.setUsuario(nombreUsuarioLogeado());

			List<String> profesionales = new ArrayList<String>();
			profesionales.add("Fontaneros");
			profesionales.add("Electricistas");
			profesionales.add("albañiles");
			profesionales.add("Pintores");
			profesionales.add("Informáticos");
			profesionales.add("Limpieza");
			profesionales.add("Mudanza");
			model.put("profesionales", profesionales);
			model.put("anuncio", a);
						
			return "registroAnuncio";
		} else
			return "redirect:/";
	}

	@RequestMapping(value = "/anuncio", method = RequestMethod.POST)
	public String anuncioPOST(HttpServletRequest request,@ModelAttribute("anuncio") Anuncio anuncio,@RequestParam("file") MultipartFile file) {
		anuncio.setUsuarioClase(registroYEdicionServicio.devolverUsuario(nombreUsuarioLogeado()));
		if (anuncio.getUsuario().equals(nombreUsuarioLogeado())) {
			try {
				if(file.isEmpty()){
					anuncio.setImagen(null);
				} else {
					anuncio.setImagen(carpetas.subirFoto(file, anuncio.getUsuario(),request));
				}
				registroYEdicionServicio.insertarAnuncio(anuncio);
				return "redirect:/";
			} catch (Exception e) {
				if (e.getMessage().contains("[PRIMARY]"))
					System.out.println("fallo primaria ");
				else if (e.getMessage().contains("SQL state [01000]"))
					System.out.println("error => " + e.getMessage());
				
				System.out.println("errorcico de la mano de dios"+ e.getMessage());
				return "redirect:/registro/anuncio?error";
			}
		} else {
			return "redirect:/";
		}
	}

	public RegistroYEdicionServicio getRegistroYEdicionServicio() {
		return registroYEdicionServicio;
	}

	public void setRegistroYEdicionServicio(RegistroYEdicionServicio registroYEdicionServicio) {
		this.registroYEdicionServicio = registroYEdicionServicio;
	}

	private String nombreUsuarioLogeado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		return userDetail.getUsername();
	}
	
	

}
