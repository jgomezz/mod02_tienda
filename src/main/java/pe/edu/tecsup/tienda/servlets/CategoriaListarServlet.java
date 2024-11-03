package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.services.CategoriaService;

/**
 * Servlet implementation class CategoriaListarServlet
 */
@WebServlet("/CategoriaListarServlet")
public class CategoriaListarServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CategoriaListarServlet.class);

	private CategoriaService categoriaService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaListarServlet() {
        super();
        categoriaService = new CategoriaService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log.info("Call doGet() ");
		
		try {
			
			List<Categoria> categorias = categoriaService.listar();
			
			categorias.stream().forEach(x -> log.info(x));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
