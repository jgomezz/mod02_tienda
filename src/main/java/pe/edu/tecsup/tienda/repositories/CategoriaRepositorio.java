package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.utils.ConexionBD;

/**
 *  Clase para obtener informacion de categorias
 */
public class CategoriaRepositorio  {

	
	/**
	 *  Metodo que obtiene todas las categorias
	 * @return
	 */
	public List<Categoria>  obtenerCategorias() {
		
		
		List<Categoria> categorias = new ArrayList<Categoria>();

		try {
			// Conectarme a la BD
			Connection con = ConexionBD.obtenerConexion();

			// Realizar una consulta
			String sql = 
					"""
						SELECT id, nombre, orden 
						FROM categorias  
						ORDER BY orden
					""";	
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			
			// Procesar la respuesta
			while (rs.next()) {
				
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("id"));
				cat.setNombre(rs.getString("nombre"));
				cat.setOrden(rs.getInt("orden"));
				
				categorias.add(cat);
								
			}
			
			rs.close(); 
			
			stmt.close();
			
			// Cerrar conexion a la BD
			con.close();
			
			//System.out.println(categorias);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;

	}

}
