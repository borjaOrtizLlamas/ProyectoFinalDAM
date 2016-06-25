	<%@ include file="../includes/Taglibs.jsp"%>

<!doctype html>

<html>
	<%@ include file="../includes/includesHead.jsp"%>

<body>

	<%@ include file="../includes/cabecera.jsp"%>
<div id="#top"></div>
<section id="home">
  <div class="container">  
  	<div class="row">    
    </div>    
  </div>   
  <div class="container hero-text2">  	
  </div>
</section>

<section id="registro" class="page-section colord">
  <div class="container">  
	<div class="row">
  	<div class="col-md-3 text-left"> <i class="circle"></i>    
    </br>
    <h3>Registro:</h3>
    
 		    <c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>     
    	
        <form:form method="post" commandName="usuario" action="registro?${_csrf.parameterName}=${_csrf.token}">
            <hr>
        	<form:label path="usuario">Nombre usuario:</form:label>
			<form:input path="usuario" class="form-control" id="usuario2" onblur="validarUsuario()"/>	


        	<form:label path="email">Correo electrónico:</form:label> 
			<form:input path="email"  class="form-control" id="correoE" onblur="validarCorreo()"/>           
            
            
        	<form:label path="email2">Repita el correo electrónico:</form:label>
			<form:input path="email2" class="form-control" id="correoE2" onblur="validarCorreo2()"/>            
            
            
        	<form:label path="contrasena">Contraseña:</form:label>
			<form:input type="password" path="contrasena" class="form-control" id="pass" onblur="validarPass()"/>          
            
            
        	<form:label path="contrasena2">Repita la contraseña:</form:label>
			<form:input type="password" path="contrasena2"  class="form-control"  id="pass2" onblur="validarPass2()"/> 			 
			
            <div style="margin-top:15px;"></div>
         	<input type="submit" value="Registrarse" class="btn btn-primary" />
            <hr> 
              
         	<br>
			<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorUsuario"></div>
			<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorCorreo"></div>
			<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorCorreo2"></div>
			<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPass"></div>
			<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPass2"></div>            
    	</form:form>       
        
    </div>
    
    <div class="col-md-9 text-center"> <i class="circle"></i>
    	</br>
        </br>
        </br>
        </br>
    	<img id="imgDesaparecer" src="resources/images/chica_escribiendo.PNG" class="img-rounded"/>
    </div>
        
        </div>
      
    </div>
  </div>
  
</section>

<%@ include file="../includes/includesJs.jsp"%>
</body>
</html>