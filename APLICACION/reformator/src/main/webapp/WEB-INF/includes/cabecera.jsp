 <%@ include file="../includes/Taglibs.jsp" %>	

<header class="header">
	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="navbar-header">
				<button type="button" id="nav-toggle" class="navbar-toggle"
					data-toggle="collapse" data-target="#main-nav">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#"
					class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i><img
							src="<c:url value="/resources/images/logo_reformator2.PNG" />" /></i></b></a>
			</div>
			<div id="main-nav" class="collapse navbar-collapse">
				<ul class="nav navbar-nav" id="mainNav">
					<li >
						<a href="/reformator/" class="scroll-link">Inicio</a>
					</li>
					<li>
						<a href="/reformator/buscar/" class="scroll-link">Busca tu reforma!</a>
					</li>
					<li>
						<a href="/reformator/nosotros" class="scroll-link">Nosotros</a>
					</li>
					<sec:authorize access="isAnonymous()">
						<li>
							<a href="/reformator/registro" class="scroll-link">Registrarse</a>
						</li>
						<li>
							<a href="/reformator/login" class="scroll-link">Iniciar sesión</a>
						</li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li>
							<a href="/reformator/edicion/" class="scroll-link">Editar Perfil/Anuncio</a>
						</li>
						<li>
							<a onclick=" formSubmit()"  class="scroll-link">Salir</a>
							<script type="text/javascript">
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
							</script>
							<form action="/reformator/j_spring_security_logout" method="post" id="logoutForm">
								<input		type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
						</li>
					</sec:authorize>
					
				</ul>
			</div>
		</nav>
	</div>
</header>
