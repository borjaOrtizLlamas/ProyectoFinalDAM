package com.company.springsecurity4.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.model.Anuncio;
import com.company.model.Usuario;
import com.company.model.UsuarioFormulario;
import com.company.service.Carpetas;
import com.company.service.RegistroYEdicionServicio;
import com.company.service.ServicioAnuncio;

@Controller
@RequestMapping("/edicion/")
public class EdicionController {

	@Autowired
	private RegistroYEdicionServicio registroYEdicionServicio;
	

	@Autowired
	Carpetas carpetas;

	@RequestMapping(method = RequestMethod.GET)
	public String edicionUsuario(Map<String, Object> model) {
		if (nombreUsuarioLogeado() != null) {
			if (c(model))
				return "edicionUsuarios";
			else
				return "redirect:/registro/anuncio";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String edicionUsuarioPost(
			@ModelAttribute("usuario") UsuarioFormulario usuario,
			BindingResult result, Map<String, Object> model) {
		c(model);
		if (usuario.getContrasena().equals(usuario.getContrasena2())
				&& usuario.getEmail().equals(usuario.getEmail2())) {
			try {
				registroYEdicionServicio.editarUsuario(new Usuario(usuario
						.getUsuario(), usuario.getContrasena(), true, usuario
						.getEmail()));
				return "edicionUsuarios";
			} catch (Exception e) {
				if (e.getMessage().contains("[PRIMARY]"))
					model.put("error", "Usuario repetido, cambie de usuario");
				else
					model.put("error", "correo repetido, cambie de correo");
				return "edicionUsuarios?error";
			}
		} else {
			model.put("error", "introduzca bien los datos");
			return "edicionUsuarios?error";
		}

	}

	@RequestMapping(value = "/anuncio", method = RequestMethod.POST)
	public String edicionAnuncioPost(
			HttpServletRequest request, 
			@ModelAttribute("anuncio") Anuncio anuncio,
			@RequestParam("file") MultipartFile file) {
		anuncio.setUsuarioClase(registroYEdicionServicio.devolverUsuario(nombreUsuarioLogeado()));
		if (anuncio.getUsuario().equals(nombreUsuarioLogeado())) {
			try {
				if (file.isEmpty()) {
					anuncio.setImagen(	registroYEdicionServicio.devolverAnuncio(anuncio.getUsuario()).getImagen());
				} else {
					anuncio.setImagen(carpetas.subirFoto(file,	anuncio.getUsuario(),request));
				}
				registroYEdicionServicio.borrarAnuncio(anuncio);
				registroYEdicionServicio.insertarAnuncio(anuncio);
				return "redirect:/";
			} catch (Exception e) {
				if (e.getMessage().contains("[PRIMARY]"))
					System.out.println("fallo primaria ");
				else if (e.getMessage().contains("SQL state [01000]"))
					System.out.println("error => " + e.getMessage());
				else
					System.out.println("error => " + e.getMessage());
				return "redirect:/edicion/error?";
			}
		} else {
			return "redirect:/";
		}
	}

	private boolean c(Map<String, Object> model) {
		Usuario user = registroYEdicionServicio
				.devolverUsuario(nombreUsuarioLogeado());
		Anuncio anuncio = registroYEdicionServicio
				.devolverAnuncio(nombreUsuarioLogeado());
		UsuarioFormulario usuarioCambio = new UsuarioFormulario(
				user.getUsuario(), null, null, null, null);
		if (anuncio == null) {
			return false;
		} else {
			model.put("usuario", usuarioCambio);
			model.put("idanuncio", anuncio.getUsuario());
			model.put("anuncio", anuncio);
			return true;
		}
	}

	private String nombreUsuarioLogeado() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			return userDetail.getUsername();
		}
		return null;
	}
}
