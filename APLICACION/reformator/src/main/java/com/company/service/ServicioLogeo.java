package com.company.service;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class ServicioLogeo extends AbstractUserDetailsAuthenticationProvider  {

	public ServicioLogeo() {
	}
	
	private ServicioUsuarios myUserDetailsService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

	}

	
	@Override
	protected UserDetails retrieveUser(String username,	UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
			myUserDetailsService.setContraseña(authentication.getCredentials().toString());
			return  myUserDetailsService.loadUserByUsername(username);
	}
		
	
	
	


	public ServicioUsuarios getMyUserDetailsService() {
		return myUserDetailsService;
	}


	public void setMyUserDetailsService(ServicioUsuarios myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}




	

}
