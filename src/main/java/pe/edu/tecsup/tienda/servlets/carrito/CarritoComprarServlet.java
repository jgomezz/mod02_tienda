package pe.edu.tecsup.tienda.servlets.carrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarritoComprarServlet
 */
@WebServlet("/CarritoComprarServlet")
public class CarritoComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CarritoComprarServlet.class);
    
	private ProductoService productoService;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoComprarServlet() {
        super();
        this.productoService = new ProductoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Post CarritoComprarServlet");
		
		String id = request.getParameter("id");
		
		Producto nuevoProducto;
		
		try {
			nuevoProducto = productoService.obtener(Integer.parseInt(id));
		
			log.info(nuevoProducto);
			
			HttpSession session = request.getSession();
			
			List<Producto> carritoCompra = (List<Producto>)session.getAttribute("carritoCompra");
			
			if( carritoCompra == null)
				carritoCompra = new ArrayList<Producto>();

			carritoCompra.add(nuevoProducto);
		
			session.setAttribute("carritoCompra", carritoCompra);
			
			session.setAttribute("success", "Producto añadido al carrito");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/CarritoListarServlet");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
