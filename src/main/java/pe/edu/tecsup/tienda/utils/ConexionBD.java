package pe.edu.tecsup.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Clase de conexion a base de datos
 */
public class ConexionBD {

	final static String URL = "jdbc:mysql://localhost/almacen?useSSL=false"; // 3306
	final static String USERNAME = "root";
	final static String PASSWORD = "";

	/**
	 *  Obtiene una conexion a base de datos
	 * @return
	 * @throws SQLException
	 */
	public static Connection obtenerConexion() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
