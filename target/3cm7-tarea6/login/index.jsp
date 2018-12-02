<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:wad="/WEB-INF/tags"
	version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<c:set var="message" value="${requestScope['global-message']}" />
	<c:choose>
		<c:when test="${message.type eq 'MESSAGE_ALERT'}">
			<c:set var="messageClass" value="alert alert-primary" />
		</c:when>
		<c:when test="${message.type eq 'MESSAGE_SUCCESS'}">
			<c:set var="messageClass" value="alert alert-success" />
		</c:when>
		<c:when test="${message.type eq 'MESSAGE_DANGER'}">
			<c:set var="messageClass" value="alert alert-danger" />
		</c:when>
		<c:when test="${message.type eq 'MESSAGE_WARNING'}">
			<c:set var="messageClass" value="alert alert-warning" />
		</c:when>
	</c:choose>
	<form action="LoginCtrl" method="post">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">Login</div>
				<div class="card-body">
					<c:if test="${message ne null}">
						<div class="${messageClass}" role="alert">
							<c:out value="${message.text}" />
						</div>
					</c:if>
					<form>
						<div class="form-group">
							<div class="form-label-group">
								<wad:input name="username" id="txUserName"
									cssClass="form-control" errorClass="is-invalid"
									showErrors="true" />
								<!-- <input type="email" name="username" class="form-control"
									placeholder="Username" autofocus="autofocus" />-->
								<label for="txUsername">Usuario</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<wad:input name="password" id="txPassword"
									cssClass="form-control" errorClass="is-invalid"
									showErrors="true" />
								<!-- <input type="password" name="password" class="form-control"
									placeholder="Password" />-->
								<label for="txPassword">Contraseña</label>
							</div>
						</div>
						<div class="form-group">
							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me" />
									Remember Password
								</label>
							</div>
						</div>
						<input type="submit" value="Ingresar"
							class="btn btn-primary btn-block" />
					</form>
					<div class="text-center">
						<a class="d-block small mt-3"
							href="${pageContext.request.contextPath}/RegistroCtrl">Registrarse</a>
						<a class="d-block small" href="forgot-password.html">¿Olvidó
							su contraseña?</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
	</html>
</jsp:root>
