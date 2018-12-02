<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="/WEB-INF/functions" xmlns:wad="/WEB-INF/tags" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Nuevo Registro</title>
</head>
<body>
	<c:set var="fieldErrors" value="${requestScope['fieldErrors']}" />
	<h1>Nuevo registro</h1>
	<form action="${pageContext.request.contextPath}/RegistroCtrl"
		method="post">
		<div class="form-group">
			<label>Nombre</label>
			<wad:input name="persona.nombre" id="txNombre" cssClass="form-control"
				errorClass="input-error" showErrors="true" />
		</div>
		<div>
			<div>Primer Apellido</div>
			<div>
				<input type="text" name="persona.primerApellido" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach
							items="${fn:getErrors(fieldErrors,'persona.primerApellido')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>Segundo Apellido</div>
			<div>
				<input type="text" name="persona.segundoApellido" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach
							items="${fn:getErrors(fieldErrors,'persona.segundoApellido')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>CURP</div>
			<div>
				<input type="text" name="persona.curp" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach items="${fn:getErrors(fieldErrors,'persona.curp')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>Fecha Naciemiento</div>
			<div>
				<input type="text" name="persona.nacimiento" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach
							items="${fn:getErrors(fieldErrors,'persona.nacimiento')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>Correo</div>
			<div>
				<input type="text" name="persona.login" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach items="${fn:getErrors(fieldErrors,'persona.login')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>Contraseña</div>
			<div>
				<input type="password" name="persona.password" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach items="${fn:getErrors(fieldErrors,'persona.password')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>Confirmar Contraseña</div>
			<div>
				<input type="password" name="persona.passwordConfirm" />
				<ul>
					<c:if test="${fieldErrors ne null}">
						<c:forEach
							items="${fn:getErrors(fieldErrors,'persona.passwordConfirm')}"
							var="error">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div>
			<div>
				<input type="submit" value="Aceptar" />
			</div>
			<div>
				<button>
					<a href="LoginCtrl">Cancelar</a>
				</button>
			</div>
		</div>

	</form>
</body>
	</html>
</jsp:root>