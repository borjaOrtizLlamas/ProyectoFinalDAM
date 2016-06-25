package com.company.springsecurity4.mvc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.model.Anuncio;
import com.company.service.GeneracionAnuncioDOCX;
import com.company.service.ServicioAnuncioIntef;

@Controller
public class PaginaPrincipal {
	/**
	 * 
	 * falta el index con busqueda anuncio posible fallo en la busqueda con los
	 * dos elementos
	 */
	@Autowired
	ServicioAnuncioIntef servicioAnuncio;
	@Autowired
	GeneracionAnuncioDOCX generador; 
	
	@RequestMapping(value = "buscar/", method = RequestMethod.GET)
	public ModelAndView defaultPage(@RequestParam(value = "profesional", required = false) String profesional,
			@RequestParam(value = "comunidadAutonoma", required = false) String comunidadAutonoma) throws IOException {
		ModelAndView model = new ModelAndView();
		List<Anuncio> anuncios;
		if (profesional != null && comunidadAutonoma != null) {
			if (!(profesional.equals("0")) && !(comunidadAutonoma.equals("0"))) {
				anuncios = servicioAnuncio.anuncios(comunidadAutonoma, profesional);
			} else if (!(profesional.equals("0"))) {
				anuncios = servicioAnuncio.anuncios(profesional);
			} else if (!(comunidadAutonoma.equals("0"))) {
				anuncios = servicioAnuncio.anunciosComunidad(comunidadAutonoma);
			} else {
				anuncios = servicioAnuncio.anuncios();
			}
		} else {
			anuncios = servicioAnuncio.anuncios();
		}
		model.addObject("anuncios", anuncios);
		model.setViewName("buscar");
		return model;

	}

	@RequestMapping(value = "/anuncio/{id}", method = RequestMethod.GET)
	public ModelAndView anuncioPrincipal(@PathVariable("id") String contactoId) {
		ModelAndView model = new ModelAndView();
		Anuncio anuncio = servicioAnuncio.anuncio(contactoId); 
		model.addObject("anuncio",anuncio );
		model.setViewName("anuncioPagina");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			if (error != null) {
				model.put("error", "usuario invalido!");
			}
			if (logout != null) {
				model.put("msg", "Te has deslogueado satisfactoriamente");
			}
			return "login";
		} else
			return "redirect:/";
	}
	
	
	
	@RequestMapping(value = "/nosotros", method = RequestMethod.GET)
	public ModelAndView nosotros() {
		ModelAndView model = new ModelAndView();
		model.setViewName("nosotros");
		return model;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		return model;
	}

	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView noExiste() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("404");
		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = "/descarga/{id}", method = RequestMethod.GET)
	public void getFile(@PathVariable("id") String id,	HttpServletResponse response) throws Exception {
		File file = new File(generador.replaceTextFound(servicioAnuncio.anuncio(id)));

		if (!file.exists()) {
			String errorMessage = "error, zip no creado";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection
				.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition",
				String.format("inline; filename=\"" + file.getName() + "\""));

		response.setHeader("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(
				file));

		FileCopyUtils.copy(inputStream, response.getOutputStream());
		file.delete();
	}

	
	
}