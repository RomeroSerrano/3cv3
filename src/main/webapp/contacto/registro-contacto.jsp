<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="/WEB-INF/functions" xmlns:wad="/WEB-INF/tags" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head></head>
<body>
    <c:set var="usuario" value="${sessionScope.authenticated_user}" />
	<h1>Bienvenido</h1>
	<div class="row">
		<div class="col-md-4">
			<form action="${pageContext.request.contextPath}/RegistroContactoCtrl" method="post">
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
					<div>Fecha Nacimiento</div>
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
					<hr />
				</div>
				<h5>Informacion contacto</h5>
				<div id="info-contacto">
					<div>
						<div>Contacto</div>
						<div>
							<input type="text" name="contacto.contacto" />
							<ul>
								<c:if test="${fieldErrors ne null}">
									<c:forEach items="${fn:getErrors(fieldErrors,'contacto.contacto')}"
										var="error">
										<li><c:out value="${error}" /></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<div>
						<div>Tipo de contacto</div>
						<div>
							<select name="contacto.tipoContacto" id="">
								<option value="1">Telefono</option>
								<option value="2">Correo</option>
								<option value="3">Movil</option>
								<option value="4">Facebook</option>
								<option value="5">Twitter</option>
							</select>
							<ul>
								<c:if test="${fieldErrors ne null}">
									<c:forEach items="${fn:getErrors(fieldErrors,'contacto.tipoContacto')}"
										var="error">
										<li><c:out value="${error}" /></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<hr />
				</div>
				<div>
					<button type="button" id="agregar-info-contacto">Agregar informacion de contacto</button>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<span>Contactos</span>
				</div>
			</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/info_contacto.js"><!----></script>
</body>
	</html>
</jsp:root>