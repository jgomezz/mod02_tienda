<%@page import="pe.edu.tecsup.tienda.entities.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page import="pe.edu.tecsup.tienda.entities.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/includes/head.jsp"%>
</head>
<body>

	<%@include file="/WEB-INF/jsp/includes/navbar.jsp"%>
	
	<% 
		String sCP = request.getContextPath();
	%>
	
	<div class="container-fluid pt-3">

		<div class="display-4 mb-3">Mantenimiento de Productos</div>

		<form action="<%=sCP%>/ProductoRegistrarServlet" method="post"  enctype="multipart/form-data">

			<div class="card">
			
				<div class="card-header">
					Registro de Producto
				</div>
			
				<div class="card-body">
				
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<input type="text" name="nombre" id="nombre" class="form-control"
						maxlength="100" required>
					</div>

					<div class="form-group">
						<label for="categorias_id">Categoría</label>
						<select name="categorias_id" id="categorias_id" class="form-control" required>
							<option value="" selected disabled>Seleccione un valor</option>
							<c:forEach items="${categorias}" var="categoria">
								<option value='<c:out value="${categoria.id}"/>'><c:out value="${categoria.nombre}"/></option>
							</c:forEach>
						</select>
					</div>
					
					
					<div class="form-group">
						<label for="precio">Precio</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">S/</div>
							</div>
							<input type="number" name="precio" id="precio" class="form-control" min="0"
							step="0.01">
						</div>
					</div>


					<div class="form-group">
						<label for="stock">Stock</label>
						<input type="number" name="stock" id="stock" class="form-control" min="0">
					</div>
									
					<div class="form-group">
						<label for="imagen">Imagen</label>
						<div class="custom-file">
							<input type="file" id="imagen" name="imagen" class="custom-file-input"/>
							<label class="custom-file-label" for="foto">Seleccionar archivo</label>
						</div>
					</div>

					<div class="form-group">
						<label for="descripcion">Descripción</label>
						<textarea name="descripcion" id="descripcion" class="form-control ckeditor" rows="5"></textarea>
					</div>

				</div>
			
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">Guardar</button>					
					<a href="<%=sCP%>/ProductoListarServlet" 
					   class="btn btn-secondary">Cancelar</a>
				</div>
			
			</div>

		</form>

	</div>
	
	
</body>
</html>