	<%@ include file="../includes/Taglibs.jsp"%>

<!doctype html>
<html>
	<%@ include file="../includes/includesHead.jsp"%>

<body>
	
	<%@ include file="../includes/cabecera.jsp"%>
	<div id="#top"></div>
	
	<section id="home">
	  <div class="banner-container"> 
	  <div id="carousel" class="carousel slide carousel-fade" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carousel" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel" data-slide-to="1"></li>
	    <li data-target="#carousel" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="active item"><img src="resources/images/banner-bg.jpg" alt="banner" /></div>
	    <div class="item"><img src="resources/images/banner-bg2.jpg" alt="banner" /></div>
	    <div class="item"><img src="resources/images/banner-bg3.jpg" alt="banner" /></div>
	  </div>
	  <a class="carousel-control left" href="#carousel" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#carousel" data-slide="next">&rsaquo;</a>
	  </div>	
	  </div>  
	  
	  <div class="container hero-text2">
		<h3>ENCUENTRA LA REFORMA IDEAL ENTRE NUESTROS MILES DE ANUNCIANTES!</h3>
	  </div>
	</section>
	
	<section id="services" class="page-section colord">
	  <div class="container">
	    <div class="row">
	      <div class="col-xs-12 col-sm-6 col-md-3 text-center"> <i class="circle"><img src="resources/images/1.png" alt="" /></i>
	        <h3>Paso 1</h3>
	        <p>Si eres autónomo en el sector de la construcción y las reformas y deseas darte a conocer lo primero que debes hacer es registrarte!</p>
	      </div>
	      <div class="col-xs-12 col-sm-6 col-md-3 text-center"><i class="circle"> <img src="resources/images/2.png" alt="" /></i>
	        <h3>Paso 2</h3>
	        <p>Rellena tus datos, cuanto mas información des acerca de tu servicio mas posibilidades de encontrar clientes!.</p>
	      </div>
	      <div class="col-xs-12 col-sm-6 col-md-3 text-center"><i class="circle"> <img src="resources/images/3.png" alt="" /></i>
	        <h3>Paso 3</h3>
	        <p>Miles de clientes podrán consultar tu anuncio y contactarán contigo.</p>
	      </div>
	      <div class="col-xs-12 col-sm-6 col-md-3 text-center"><i class="circle"> <img src="resources/images/4.png" alt="" /></i>
	        <h3>Paso 4</h3>
	        <p>A ganar dinero!</p>
	      </div>	       
	    </div>
	  </div>	  
	</section>
	

	<%@ include file="../includes/includesJs.jsp"%>
	
</body>
</html>