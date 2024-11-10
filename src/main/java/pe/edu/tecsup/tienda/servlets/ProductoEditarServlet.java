package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class ProductoEditarServlet
 */
@WebServlet("/ProductoEditarServlet")
public class ProductoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ProductoEditarServlet.class);

	private ProductoService productoService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEditarServlet() {
        super();
        this.productoService = new ProductoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("TODO  ProductoEditarServlet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
