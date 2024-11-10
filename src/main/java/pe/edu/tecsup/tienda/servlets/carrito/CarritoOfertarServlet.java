package pe.edu.tecsup.tienda.servlets.carrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.servlets.ProductoRegistrarServlet;

/**
 * Servlet implementation class CarritoOfertarServlet
 */
@WebServlet("/CarritoOfertarServlet")
public class CarritoOfertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CarritoOfertarServlet.class);

	private ProductoService productoService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoOfertarServlet() {
		super();
		this.productoService = new ProductoService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("Get CarritoOfertarServlet");
	
		List<Producto> productos = new ArrayList<Producto>();
		
		try {
			productos = productoService.listar();
		} catch (Exception e) {
			
			log.error(e.getStackTrace());
			throw new ServletException(e.getMessage(), e);
		
		}
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/jsp/carrito/ofertar.jsp")
			   .forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
