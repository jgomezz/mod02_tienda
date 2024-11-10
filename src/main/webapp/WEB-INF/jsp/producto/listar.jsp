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

		<div class="card">

			<div class="card-header">Lista de Productos</div>

			<div class="card-body">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>ID</th>
							<th>NOMBRE</th>
							<th>CATEGOR&Iacute;A</th>
							<th>PRECIO</th>
							<th>IMAGEN</th>
							<th width="300" align="center">ACCIONES</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${productos}" var="producto">
						
						<tr>
							<td><c:out value="${producto.id}"/></td>
							<td><c:out value="${producto.nombre}"/></td>
							<td><c:out value="${producto.categoria.nombre}"/></td>
							<td><c:out value="${producto.precio}"/></td>
							<td>
							
							<c:if test="${producto.imagen_nombre != null}">
							
								<img src="<%=sCP%>/files/<c:out value="${producto.imagen_nombre}"/>" 
									 alt="" 
									 height="30"/>
								
							</c:if>	
							
							</td>
							<td class="text-right">
								<a href="<%=sCP%>/ProductoMostrarServlet?id=<c:out value="${producto.id}"/>"
								class="btn btn-info btn-sm">
									<i class="fa fa-eye"></i>
									Mostrar</a>
								<a href="<%=sCP%>/ProductoEditarServlet?id=<c:out value="${producto.id}"/>"
								class="btn btn-warning btn-sm">
									<i class="fa fa-edit"></i>
									Editar</a>
								<a href="<%=sCP%>/ProductoEliminarServlet?id=<c:out value="${producto.id}"/>"
								class="btn btn-danger btn-sm">
									<i class="fa fa-trash"></i> 
									Eliminar</a>
							</td>

						</tr>
						
						</c:forEach>
						
					</tbody>
				</table>
			</div>

			<div class="card-footer">
				<a href="<%=sCP%>/ProductoRegistrarServlet"
					class="btn btn-success"><i class="fa fa-plus"></i> Nuevo</a>
			</div>
		</div>
	</div>

</body>
</html>