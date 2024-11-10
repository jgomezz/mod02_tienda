<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		List<Producto> productos = (List<Producto>) request.getAttribute("productos");
	
		String sCP = request.getContextPath();
		
		// out.println(sCP);
		// http://localhost:8080/mod02_tienda/ProductoListarServlet
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
						<% for(Producto producto : productos) { %>
						<tr>
							<td><%=producto.getId() %></td>
							<td><%=producto.getNombre() %></td>
							<td><%=producto.getCategoria().getNombre() %></td>
							<td><%=producto.getPrecio() %></td>
							<td><img src="" alt=""></td>
							<td class="text-right">
								<a href="<%=sCP%>/ProductoMostrarServlet?id=<%=producto.getId()%>"
								class="btn btn-info btn-sm">
									<i class="fa fa-eye"></i>
									Mostrar</a>
								<a href="<%=sCP%>/ProductoEditarServlet?id=<%=producto.getId()%>"
								class="btn btn-warning btn-sm">
									<i class="fa fa-edit"></i>
									Editar</a>
								<a href="<%=sCP%>/ProductoEliminarServlet?id=<%=producto.getId()%>"
								class="btn btn-danger btn-sm">
									<i class="fa fa-trash"></i> 
									Eliminar</a>
							</td>

						</tr>
						<% } %>
					</tbody>
				</table>
			</div>

			<div class="card-footer">
				<a href="<%=request.getContextPath()%>/ProductoRegistrarServlet"
					class="btn btn-success"><i class="fa fa-plus"></i> Nuevo</a>
			</div>
		</div>
	</div>

</body>
</html>