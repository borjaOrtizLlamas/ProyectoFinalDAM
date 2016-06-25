 <%@ include file="../includes/Taglibs.jsp" %>	

<!doctype html>

<html>
 <%@ include file="../includes/includesHead.jsp" %>	

<body>
 <%@ include file="../includes/cabecera.jsp" %>	
<div id="#top"></div>
<section id="home">
  <div class="container">  
  	<div class="row">    
    </div>    
  </div>   
  <div class="container hero-text2">  	
  </div>
</section>

<section id="anuncio" class="page-section colord">
  <div class="container">
  
	<div class="row">
		
  	<div class="col-md-12 text-left"> <i class="circle"></i>
		</br>
		<h3>${anuncio.nombreEmpresa}</h3> 
		</br>
		</br>
    </div>
    
    <div class=" col-xs-12 col-sm-6 text-left" > <i class="circle"></i>
	
 	<div style="background-color:#ece8e8; padding:20px;">

		<h2>${anuncio.titulo}</h2> <!--  -->
		<br>
		<div style="word-wrap: break-word"><p style="color:black;"> ${anuncio.texto}</p></div>		

	</div> 

	<br>
	
	<div style="background-color:#ece8e8; padding:20px;">
		<b>Provincia:</b> ${anuncio.comunidadAutonoma}<br> 
		<b>Precio/Hora:</b>${anuncio.precio} <br> <!--  -->
		<b>Teléfono de Contacto 1:</b> ${anuncio.numeroTelefono} <br>  
		<b>Teléfono de Contacto 2:</b>${anuncio.numeroTelefono2}<br>  <!-- -->
	</div>
		
    </div> 
	
	<div class="col-xs-12 col-sm-6 text-center"> <i class="circle"></i>		
		<c:choose>
		    <c:when test="${empty var1}">
				<img id="imgDesaparecer" src="<c:url value="${anuncio.imagen}" />"  class="img-rounded"/></br></br> <!--  -->
		    </c:when>
		    <c:otherwise>
				<img id="imgDesaparecer" src="${anuncio.imagen}" class="img-rounded"/></br></br> 
		    </c:otherwise>
		</c:choose>
		
		
		
    </div> 
	
    </div>
  </div>
  
</section>

<%@ include file="../includes/includesJs.jsp"%>

</body>
</html>