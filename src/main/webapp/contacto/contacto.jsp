<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
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
    <c:set var="usuario" value="${sessionScope.authenticated_user}" />
	<h1>Bienvenido</h1>
	<h3><c:out value="${usuario}"/></h3>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<input class="form-control" type="text" placeholder="Nombre" />
            </div>
            
			<div class="form-group">
				<button class="btn btn-primary">Agregar</button>
			</div>
		</div>
	</div>
	<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<span>Contactos</span>
				</div>
			</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<th>Nombre</th>
						<th>Primero apellido</th>
						<th>Segundo apellido</th>
						<th>CURP</th>
						<th>Telefono</th>
						<th>Email</th>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>