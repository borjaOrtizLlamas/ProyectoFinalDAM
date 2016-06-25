	<%@ include file="../includes/Taglibs.jsp"%>
<!doctype html>
<html>
	<%@ include file="../includes/includesHead.jsp"%>

<body onload='document.loginForm.username.focus();'>
	<%@ include file="../includes/cabecera.jsp"%>

	<div id="#top"></div>
	<section id="home">
		<div class="container">
			<div class="row"></div>
		</div>
		<div class="container hero-text2"></div>
	</section>

	<section id="buscar" class="page-section colord">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left">
					<i class="circle"></i> </br>
					<div>
						<h3>Busca tu reforma!:</h3>

						<br>

						<form method="GET" action="">

							<hr>
							<div class="row">
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-6">
									Quiero ... <select name="profesional" class="form-control">
										<option value='0'>(Seleccionar)</option>
										<option value="Fontaneros">Fontaneros</option>
										<option value="Electricistas">Electricistas</option>
										<option value="alba�iles">alba�iles</option>
										<option value="Pintores">Pintores</option>
										<option value="Inform�ticos">Inform�ticos</option>
										<option value="Limpieza">Limpieza</option>
										<option value="Mudanza">Mudanza</option>
									</select>
								</div>
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-6">
									en... <select name="comunidadAutonoma" class="form-control">
										<option value='0'>(Seleccionar)</option>
										<option value='�lava'>�lava</option>
										<option value='Albacete'>Albacete</option>
										<option value='Alicante/Alacant'>Alicante/Alacant</option>
										<option value='Almer�a'>Almer�a</option>
										<option value='Asturias'>Asturias</option>
										<option value='�vila'>�vila</option>
										<option value='Badajoz'>Badajoz</option>
										<option value='Barcelona'>Barcelona</option>
										<option value='Burgos'>Burgos</option>
										<option value='C�ceres'>C�ceres</option>
										<option value='C�diz'>C�diz</option>
										<option value='Cantabria'>Cantabria</option>
										<option value='Castell�n/Castell�'>Castell�n/Castell�</option>
										<option value='Ceuta'>Ceuta</option>
										<option value='Ciudad Real'>Ciudad Real</option>
										<option value='C�rdoba'>C�rdoba</option>
										<option value='Cuenca'>Cuenca</option>
										<option value='Girona'>Girona</option>
										<option value='Las Palmas'>Las Palmas</option>
										<option value='Granada'>Granada</option>
										<option value='Guadalajara'>Guadalajara</option>
										<option value='Guip�zcoa'>Guip�zcoa</option>
										<option value='Huelva'>Huelva</option>
										<option value='Huesca'>Huesca</option>
										<option value='Illes Balears'>Illes Balears</option>
										<option value='Ja�n'>Ja�n</option>
										<option value='A Coru�a'>A Coru�a</option>
										<option value='La Rioja'>La Rioja</option>
										<option value='Le�n'>Le�n</option>
										<option value='Lleida'>Lleida</option>
										<option value='Lugo'>Lugo</option>
										<option value='Madrid'>Madrid</option>
										<option value='M�laga'>M�laga</option>
										<option value='Melilla'>Melilla</option>
										<option value='Murcia'>Murcia</option>
										<option value='Navarra'>Navarra</option>
										<option value='Ourense'>Ourense</option>
										<option value='Palencia'>Palencia</option>
										<option value='Pontevedra'>Pontevedra</option>
										<option value='Salamanca'>Salamanca</option>
										<option value='Segovia'>Segovia</option>
										<option value='Sevilla'>Sevilla</option>
										<option value='Soria'>Soria</option>
										<option value='Tarragona'>Tarragona</option>
										<option value='Santa Cruz de Tenerife'>Santa Cruz de Tenerife</option>
										<option value='Teruel'>Teruel</option>
										<option value='Toledo'>Toledo</option>
										<option value='Valencia/Val�ncia'>Valencia/Val�ncia</option>
										<option value='Valladolid'>Valladolid</option>
										<option value='Vizcaya'>Vizcaya</option>
										<option value='Zamora'>Zamora</option>
										<option value='Zaragoza'>Zaragoza</option>
									</select>

								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
									<div style="margin-top: 15px;"></div>

									<input type="submit" value="Buscar!" class="btn btn-primary" />
								</div>
							</div>
							<hr>
						</form>
						
						<div class="table-responsive">
						<table class="table table-striped">						
							<tr>
								<th>Categor�a</th><th>Nombre de la Empresa</th><th>Precio/Hora</th><th>Provincia</th><th>Ver Anuncio</th>
							</tr>
							<c:forEach items="${anuncios}" var="anuncio">
								<tr>
									<td>${anuncio.tipoProfesional}</td><td>${anuncio.nombreEmpresa}</td><td>${anuncio.precio}</td><td>${anuncio.comunidadAutonoma}</td><td><a href="../anuncio/${anuncio.usuario}">Ver</a></td>
								</tr>
							<br>
							</c:forEach>						
						</table>


						</br> </br> <img id="imgDesaparecer"
							src="<c:url value="/resources/images/collage.PNG" />"
							class="img-thumbnail" /> </br> </br>

					</div>
				</div>

			</div>
		</div>

	</section>

	<%@ include file="../includes/includesJs.jsp"%>

</body>
</html>