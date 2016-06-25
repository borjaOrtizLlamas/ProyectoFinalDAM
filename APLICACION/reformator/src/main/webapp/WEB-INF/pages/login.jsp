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

	<section id="login" class="page-section colord">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-left">
					<i class="circle"></i> </br>
					<div id="login-box">
						<h3>Iniciar sesión:</h3>

						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>

						<form name='loginForm'
							action="<c:url value='/j_spring_security_check' />" method='POST'>
							<hr>
							<label for='usuario'>Nombre de usuario:</label></br> <input
								type='text' name='username' class="form-control" /> <label
								for='contrasena'>Contraseña:</label></br> <input type='password'
								name='password' class="form-control" />
							<div style="margin-top: 15px;"></div>

							<input name="submit" type="submit" value="Iniciar sesión"
								class="btn btn-primary" />
							<hr>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

					</div>
				</div>

				<div class="col-md-9 text-center">
					<i class="circle"></i> </br> </br> <img id="imgDesaparecer"
						src="resources/images/cerrajero.jpg" class="img-thumbnail" />
				</div>
			</div>
		</div>

	</section>

	<%@ include file="../includes/includesJs.jsp"%>


</body>
</html>