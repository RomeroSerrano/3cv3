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
</head>
<body>
	<c:set var="usuario" value="${usuario}" />
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
	<c:if test="${message ne null}">
		<div class="${messageClass}" role="alert">
			<c:out value="${message.text}" />
		</div>
	</c:if>
	<h1><wad:property property="BIENVENIDO"></wad:property></h1>
	<h3><c:out value="${usuario}"/></h3>
	<div class="row">
		<div class="col-md-12">
			<a href="${pageContext.request.contextPath}/RegistroContactoCtrl" class="btn btn-primary">Agregar contacto</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<th><wad:property property="registrarPersona.nombre"></wad:property></th>
						<th><wad:property property="registrarPersona.primerApellido"></wad:property></th>
						<th><wad:property property="registrarPersona.segundoApellido"></wad:property></th>
						<th><wad:property property="registrarPersona.curp"></wad:property></th>
						<th><wad:property property="registrarPersona.nacimiento"></wad:property></th>
						<th><wad:property property="registrarPersona.contactos"></wad:property></th>
					</thead>
					<tbody>
						<c:forEach var="contacto" items="${contactos}">
							<tr>
								<td><c:out value="${contacto.personaContacto.nombre}"></c:out></td>
								<td><c:out value="${contacto.personaContacto.primerApellido}"></c:out></td>
								<td><c:out value="${contacto.personaContacto.segundoApellido}"></c:out></td>
								<td><c:out value="${contacto.personaContacto.curp}"></c:out></td>
								<td><c:out value="${contacto.personaContacto.nacimiento}"></c:out></td>
								<td>
									<ul>
										<c:forEach var="pContacto" items="${contacto.personaContacto.contactos}">
											<li><c:out value="${pContacto.contacto}"></c:out> (<c:out value="${pContacto.tipo.nombre}"></c:out>)</li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>