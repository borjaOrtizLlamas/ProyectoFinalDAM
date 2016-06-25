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

<section id="nosotros" class="page-section colord">
  <div class="container">
  
	<div class="row">
		
  	<div class="col-md-12 text-left"> <i class="circle"></i>
		</br>
		<h3>Nosotros:</h3>
		</br>
		</br>
    </div>
    
    <div class=" col-xs-12 col-sm-6 text-center"> <i class="circle"></i>
		<img src="<c:url value="/resources/images/silueta_foto.gif" />" class="img-thumbnail"/></br></br>
		Nombre: José Pino Asenjo</br>
		Teléfono: 649 073 482</br>
		Email: jose.pino.asenjo@gmail.com</br>	
    </div> 
	
	<div class="col-xs-12 col-sm-6 text-center"> <i class="circle"></i>	
		<img src="<c:url value="/resources/images/silueta_foto.gif" />" class="img-thumbnail"/></br></br>
		Nombre: Borja Ortiz Llamas</br>
		Teléfono: 637 102 130</br>
		Email: borja.ortizllamas@gmail.com</br>	
    </div> 
	
    </div>
  </div>
  
</section>

		<%@ include file="../includes/includesJs.jsp"%>
	

</body>
</html>