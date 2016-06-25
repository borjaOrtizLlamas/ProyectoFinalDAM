function validacionCorreo(){
	var valor1 = $("#email").val();
	var valor2 = $("#email2").val();
	if(valor1 != valor2){
		$("#validacionCorreo").val("<font color=\"red\">los correos no son iguales");
	}else{
		$("#validacionCorreo").val("");
	}
	
	
}

function validacionContrasena(){
	var valor1 = $("#contrasena").val();
	var valor2 = $("#contrasena2").val();
	if(valor1 != valor2){
		$("#validacionContrasena").val("valor incorrecto");
	}else {
		$("#validacionContrasena").val("");
	}
	
	
}

function validarUsuario(){
	
	var usuario = document.getElementById("usuario2").value;	
	var errorUsuario = document.getElementById("errorUsuario");
	var msjError = " * Nombre de usuario obligatorio.";
	
	if (usuario == ""){		
		errorUsuario.innerHTML = msjError;
		return false;
	}else{
		errorUsuario.innerHTML =""
		return true;
	}	
}

function validarCorreo(){
	
	var correo = document.getElementById("correoE").value;	
	var errorCorreo = document.getElementById("errorCorreo");
	var msjError = " * Correo electr&oacute;nico obligatorio.";
	
	if (correo == ""){		
		errorCorreo.innerHTML = msjError;
		return false;
	}else{
		errorCorreo.innerHTML =""
		return true;
	}	
}

function validarCorreo2(){
	
	var correo = document.getElementById("correoE").value;
	var correo2 = document.getElementById("correoE2").value;	
	var errorCorreo2 = document.getElementById("errorCorreo2");
	var msjError = " * Los correos deben coincidir.";

	if (correo != correo2){		
		errorCorreo2.innerHTML = msjError;
		return false;
	}else{
		errorCorreo2.innerHTML =""
		return true;
	}	
}

function validarPass(){
	
	var pass = document.getElementById("pass").value;	
	var errorPass = document.getElementById("errorPass");
	var msjError = " * Contrase&ntilde;a obligatoria.";
	
	if (pass == ""){		
		errorPass.innerHTML = msjError;
		return false;
	}else{
		errorPass.innerHTML =""
		return true;
	}	
}

function validarPass2(){
	
	var pass = document.getElementById("pass").value;
	var pass2 = document.getElementById("pass2").value;	
	var errorPass2 = document.getElementById("errorPass2");
	var msjError = " * Las Contrase&ntilde;as deben coincidir.";
	
	if (pass != pass2){		
		errorPass2.innerHTML = msjError;
		return false;
	}else{
		errorPass2.innerHTML =""
		return true;
	}
}

function validarPrecio(){
	
	var precio = document.getElementById("precio").value;	
	var errorPrecio = document.getElementById("errorPrecio");
	var msjError = " * El precio no puede ser menor que 0.";
	
	if (precio < 0){		
		errorPrecio.innerHTML = msjError;
		return false;
	}else{
		errorPrecio.innerHTML =""
		return true;
	}
}

function validarCorreoEditar(){
	
	var correo = document.getElementById("correoE").value;	
	var errorCorreo = document.getElementById("errorCorreo");
	var msjError = " * Correo electr&oacute;nico obligatorio.";
	
	if (correo == ""){		
		errorCorreo.innerHTML = msjError;
		document.getElementById('btnEditar').disabled=true;
		return false;		
	}else{
		errorCorreo.innerHTML =""
	}
}

function validarCorreo2Editar(){
	
	var correo = document.getElementById("correoE").value;
	var correo2 = document.getElementById("correoE2").value;	
	var errorCorreo2 = document.getElementById("errorCorreo2");
	var msjError = " * Los correos deben coincidir.";
	
	if (correo != correo2){		
		errorCorreo2.innerHTML = msjError;
		document.getElementById('btnEditar').disabled=true;
		return false;
	}else if(correo.length == 0 || correo2.length == 0){
		errorCorreo2.innerHTML = msjError;
		document.getElementById('btnEditar').disabled=true;
		return false;
	}else{
		errorCorreo2.innerHTML =""
		document.getElementById('btnEditar').disabled=false;
		return true;
	}	
}

function validarPassEditar(){
	
	var pass = document.getElementById("pass").value;	
	var errorPass = document.getElementById("errorPass");
	var msjError = " * Contrase&ntilde;a obligatoria.";
	
	if (pass == ""){		
		errorPass.innerHTML = msjError;	
		document.getElementById('btnEditar').disabled=true;
		return false;
	}else{
		errorPass.innerHTML =""
		return true;
	}	
}

function validarPass2Editar(){
	
	var pass = document.getElementById("pass").value;
	var pass2 = document.getElementById("pass2").value;	
	var errorPass2 = document.getElementById("errorPass2");
	var msjError = " * Las Contrase&ntilde;as deben coincidir.";
	
	if (pass != pass2){		
		errorPass2.innerHTML = msjError;
		document.getElementById('btnEditar').disabled=true;
		return false;
	}else if(pass.length == 0 || pass.length == 0){
		errorPass2.innerHTML = msjError;
		document.getElementById('btnEditar').disabled=true;
		return false;
	}else{
		errorPass2.innerHTML =""
		document.getElementById('btnEditar').disabled=false;
		return true;
	}	
}