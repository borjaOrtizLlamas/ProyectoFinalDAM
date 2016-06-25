
<%@ include file="../includes/Taglibs.jsp"%>

<!doctype html>

<html>
<%@ include file="../includes/includesHead.jsp"%>

<body>

	<%@ include file="../includes/cabecera.jsp"%>
	<div id="#top"></div>
	<section id="home">
		<div class="container">
			<div class="row"></div>
		</div>
		<div class="container hero-text2"></div>
	</section>

	<section id="editar" class="page-section colord"
		style="margin-top: 20px;">
		<div class="container">

			<div style="margin-top: 15px;"></div>

			<div class="row">
				<div class="col-md-6 text-left">
					<i class="circle"></i>
					<h3>Editar Perfil</h3>
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>

					<form:form method="post" commandName="usuario" action="usuario">
						<form:input path="usuario" readonly="true" type="hidden" />
						<hr>
						<form:label path="email">Correo Electr�nico</form:label>
						<form:input path="email" class="form-control" id="correoE" onblur="validarCorreoEditar()" />

						<form:label path="email2">Repita su Correo Electr�nico</form:label>
						<form:input path="email2" class="form-control" id="correoE2" onblur="validarCorreo2Editar()" />

						<form:label path="contrasena">Contrase�a</form:label>
						<form:input type="password" path="contrasena" class="form-control" id="pass" onblur="validarPassEditar()"/>

						<form:label path="contrasena2">Repita la Contrase�a</form:label>
						<form:input type="password" path="contrasena2"
							class="form-control" id="pass2" onblur="validarPass2Editar()"/>
						<div style="margin-top: 15px;"></div>

						<input type="submit" id="btnEditar" disabled value=Modificar class="btn btn-primary" />
						<hr>
						
						<br>						
						<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorCorreo"></div>
						<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorCorreo2"></div>
						<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPass"></div>
						<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPass2"></div>  

					</form:form>
					<div style="margin-top: 25px;"></div>

					<img id="imgDesaparecer"
						src="<c:url value="/resources/images/female-construction.jpg" />"
						class="img-thumbnail" />

				</div>


				<div class="col-md-6 text-left">
					<i class="circle"></i>
					<h3>Editar Anuncio:</h3>
					<c:if test="${not empty anuncio}">
						<c:if test="${not empty error1}">
							<div class="error">${error1}</div>
						</c:if>

						<form:form method="post" commandName="anuncio"
							action="anuncio?${_csrf.parameterName}=${_csrf.token}"
							enctype="multipart/form-data">

							<form:input path="usuario" readonly="true" type="hidden" />
							<hr>
							<form:label path="nombreEmpresa">Nombre de la Empresa</form:label>
							<form:input path="nombreEmpresa" class="form-control" />

							<form:label path="numeroTelefono">Tel�fono de Contacto 1</form:label>
							<form:input path="numeroTelefono" class="form-control" />

							<form:label path="numeroTelefono2">Tel�fono de Contacto 2</form:label>
							<form:input path="numeroTelefono2" class="form-control" />

							<form:label path="precio">Precio/Hora</form:label>
							<form:input path="precio" class="form-control" id="precio" onblur="validarPrecio()" />

							<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPrecio"></div>
							<br>
							
							<form:label path="titulo">T�tulo del Anuncio</form:label>
							<form:input path="titulo" class="form-control" />

							<form:label path="texto">Texto Descriptivo del Anuncio</form:label>
							<form:textarea path="texto" class="form-control" />

							<form:label path="comunidadAutonoma">Provincia:  ${anuncio.comunidadAutonoma}</form:label>
							<form:select path="comunidadAutonoma" class="form-control">
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
								<option value='Santa Cruz de Tenerife'>Santa Cruz de
									Tenerife</option>
								<option value='Teruel'>Teruel</option>
								<option value='Toledo'>Toledo</option>
								<option value='Valencia/Val�ncia'>Valencia/Val�ncia</option>
								<option value='Valladolid'>Valladolid</option>
								<option value='Vizcaya'>Vizcaya</option>
								<option value='Zamora'>Zamora</option>
								<option value='Zaragoza'>Zaragoza</option>
							</form:select>




							<form:label path="tipoProfesional">Tipo profesional: ${anuncio.tipoProfesional}</form:label>
							<form:select path="tipoProfesional" class="form-control">
								<option value="Fontaneros">Fontaneros</option>
								<option value="Electricistas">Electricistas</option>
								<option value="alba�iles">alba�iles</option>
								<option value="Pintores">Pintores</option>
								<option value="Inform�ticos">Inform�ticos</option>
								<option value="Limpieza">Limpieza</option>
								<option value="Mudanza">Mudanza</option>
							</form:select>
							<label path="file">Subir Im�gen</label>
							<input type="file" name="file" />
							<div style="margin-top: 15px;"></div>
							<input type="submit" value=Modificar class="btn btn-primary" />
							<br>
							<hr>

		<a class="btn btn-primary"  href="/reformator/descarga/${idanuncio}">Generar				anuncio en formato docx</a>

						</form:form>						
						
					</c:if>

				</div>

			</div>

		</div>
		</div>

	</section>


	<%@ include file="../includes/includesJs.jsp"%>


</body>
</html>