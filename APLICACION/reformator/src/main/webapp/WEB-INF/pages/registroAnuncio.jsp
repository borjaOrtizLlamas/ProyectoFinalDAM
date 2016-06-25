<%@ include file="../includes/Taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<section id="buscar" class="page-section colord"
		style="margin-top: 40px;">
	<div class="container">
			<h3>Editar Perfil</h3>
			<hr>
			<form:form method="POST" commandName="anuncio"
				action="anuncio?${_csrf.parameterName}=${_csrf.token}"
				enctype="multipart/form-data">
				<form:input path="usuario" readonly="true" type="hidden" />
				<form:label path="nombreEmpresa"> Empresa</form:label>
				<form:input path="nombreEmpresa" class="form-control" />
				<form:label path="numeroTelefono">telfono  1</form:label>
				<form:input path="numeroTelefono" class="form-control" />
				<form:label path="numeroTelefono2">telefono 2</form:label>
				<form:input path="numeroTelefono2" class="form-control" />
				<form:label path="precio">precio hora</form:label>
				<form:input path="precio" class="form-control" id="precio" onblur="validarPrecio()" />
				<div style="background-color: #d4c7c7; color:red; font-weight: bold" id="errorPrecio"></div>
				<br>
				<form:label path="titulo">titulo</form:label>
				<form:input path="titulo" class="form-control" />
				<form:label path="texto">texto del anuncio</form:label>
				<form:textarea path="texto" class="form-control" />
				<form:label path="tipoProfesional">tipo profesional </form:label>
				<form:select path="tipoProfesional" class="form-control"
					items="${profesionales}" />
				<form:label path="comunidadAutonoma">comunidadAutonoma</form:label>
				<form:select path="comunidadAutonoma" class="form-control">
					<option value='0'>(Seleccionar)</option>
					<option value='Álava'>Álava</option>
					<option value='Albacete'>Albacete</option>
					<option value='Alicante/Alacant'>Alicante/Alacant</option>
					<option value='Almería'>Almería</option>
					<option value='Asturias'>Asturias</option>
					<option value='Ávila'>Ávila</option>
					<option value='Badajoz'>Badajoz</option>
					<option value='Barcelona'>Barcelona</option>
					<option value='Burgos'>Burgos</option>
					<option value='Cáceres'>Cáceres</option>
					<option value='Cádiz'>Cádiz</option>
					<option value='Cantabria'>Cantabria</option>
					<option value='Castellón/Castelló'>Castellón/Castelló</option>
					<option value='Ceuta'>Ceuta</option>
					<option value='Ciudad Real'>Ciudad Real</option>
					<option value='Córdoba'>Córdoba</option>
					<option value='Cuenca'>Cuenca</option>
					<option value='Girona'>Girona</option>
					<option value='Las Palmas'>Las Palmas</option>
					<option value='Granada'>Granada</option>
					<option value='Guadalajara'>Guadalajara</option>
					<option value='Guipúzcoa'>Guipúzcoa</option>
					<option value='Huelva'>Huelva</option>
					<option value='Huesca'>Huesca</option>
					<option value='Illes Balears'>Illes Balears</option>
					<option value='Jaén'>Jaén</option>
					<option value='A Coruña'>A Coruña</option>
					<option value='La Rioja'>La Rioja</option>
					<option value='León'>León</option>
					<option value='Lleida'>Lleida</option>
					<option value='Lugo'>Lugo</option>
					<option value='Madrid'>Madrid</option>
					<option value='Málaga'>Málaga</option>
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
					<option value='Valencia/Valéncia'>Valencia/Valéncia</option>
					<option value='Valladolid'>Valladolid</option>
					<option value='Vizcaya'>Vizcaya</option>
					<option value='Zamora'>Zamora</option>
					<option value='Zaragoza'>Zaragoza</option>
				</form:select>
				<br>
				<input type="file" name="file" class="center-block" />
				<input type="submit" value="insertar anuncio"
					class="btn btn-primary " />
	</div>
	</form:form>
	</div>
	</div>
	</section>

	<%@ include file="../includes/includesJs.jsp"%>

</body>
</html>



