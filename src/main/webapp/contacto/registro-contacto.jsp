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
	<h1><wad:property property="BIENVENIDO"></wad:property></h1>
	<div class="row">
		<div class="col-md-4">
			<form action="${pageContext.request.contextPath}/RegistroContactoCtrl" method="post">
				<div>
					<div><wad:property property="registrarPersona.nombre"></wad:property></div>
					<div>
						<input type="text" name="persona.nombre" />
						<ul>
							<c:if test="${fieldErrors ne null}">
								<c:forEach
									items="${fn:getErrors(fieldErrors,'persona.nombre')}"
									var="error">
									<li class="text-danger"><c:out value="${error}" /></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div>
					<div><wad:property property="registrarPersona.primerApellido"></wad:property></div>
					<div>
						<input type="text" name="persona.primerApellido" />
						<ul>
							<c:if test="${fieldErrors ne null}">
								<c:forEach
									items="${fn:getErrors(fieldErrors,'persona.primerApellido')}"
									var="error">
									<li class="text-danger"><c:out value="${error}" /></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div>
					<div><wad:property property="registrarPersona.segundoApellido"></wad:property></div>
					<div>
						<input type="text" name="persona.segundoApellido" />
						<ul>
							<c:if test="${fieldErrors ne null}">
								<c:forEach
									items="${fn:getErrors(fieldErrors,'persona.segundoApellido')}"
									var="error">
									<li class="text-danger"><c:out value="${error}" /></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div>
					<div><wad:property property="registrarPersona.curp"></wad:property></div>
					<div>
						<input type="text" name="persona.curp" />
						<ul>
							<c:if test="${fieldErrors ne null}">
								<c:forEach items="${fn:getErrors(fieldErrors,'persona.curp')}"
									var="error">
									<li class="text-danger"><c:out value="${error}" /></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div>
					<div><wad:property property="registrarPersona.nacimiento"></wad:property></div>
					<div>
						<input type="text" name="persona.nacimiento" />
						<ul>
							<c:if test="${fieldErrors ne null}">
								<c:forEach
									items="${fn:getErrors(fieldErrors,'persona.nacimiento')}"
									var="error">
									<li class="text-danger"><c:out value="${error}" /></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
					<hr />
				</div>
				<h5><wad:property property="registrarContacto.titulo"></wad:property></h5>
				<div id="info-contacto">
					<div>
						<div><wad:property property="registrarContacto.contacto"></wad:property></div>
						<div>
							<input type="text" name="contacto.contacto" />
							<ul>
								<c:if test="${fieldErrors ne null}">
									<c:forEach items="${fn:getErrors(fieldErrors,'contacto.contacto')}"
										var="error">
										<li class="text-danger"><c:out value="${error}" /></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<div>
						<div><wad:property property="registrarContacto.tipoContacto"></wad:property></div>
						<div>
							<select name="contacto.tipoContacto" id="">
								<option value="1"><wad:property property="registrarContacto.telefono"></wad:property></option>
								<option value="2"><wad:property property="registrarContacto.correo"></wad:property></option>
								<option value="3"><wad:property property="registrarContacto.movil"></wad:property></option>
								<option value="4"><wad:property property="registrarContacto.facebook"></wad:property></option>
								<option value="5"><wad:property property="registrarContacto.twitter"></wad:property></option>
							</select>
							<ul>
								<c:if test="${fieldErrors ne null}">
									<c:forEach items="${fn:getErrors(fieldErrors,'contacto.tipoContacto')}"
										var="error">
										<li class="text-danger"><c:out value="${error}" /></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<hr />
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-link" id="agregar-info-contacto"><wad:property property="registrarContacto.agregarContacto"></wad:property></button>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary"><wad:property property="GUARDAR"></wad:property></button>
				</div>
			</form>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/info_contacto.js"><!----></script>
</body>
	</html>
</jsp:root>