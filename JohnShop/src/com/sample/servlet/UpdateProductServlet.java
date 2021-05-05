package com.sample.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.service.DbConnector;
import com.sample.service.ProductService;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();
		props.load(in);

		DbConnector dbConnection = new DbConnector(props.getProperty("dbUrl"), props.getProperty("dbUsername"),
				props.getProperty("dbPassword"));

		String name;
		try {
			name = ProductService.getProductName(dbConnection, pid);

			response.getWriter().print("<html><body>");

			response.getWriter().print("<form method=\"post\" action=\"updateProduct\">\n" +

					"		Product Name: <input type=\"text\" name=\"productName\" value='" + name + "'>");

			response.getWriter().print("<input type='hidden' name='pid' value='"+pid+"'>");
			
			response.getWriter().print("<button type=\"submit\"> Save </button></form>");

			response.getWriter().print("</body></html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();
		props.load(in);

		DbConnector dbConnection = new DbConnector(props.getProperty("dbUrl"), props.getProperty("dbUsername"),
				props.getProperty("dbPassword"));

		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("productName");
		
		try {
			ProductService.updateProduct(dbConnection, pid, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("showsProduct");
		
		

	}

}
