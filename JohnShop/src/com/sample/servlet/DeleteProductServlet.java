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
 * Servlet implementation class deleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();
		props.load(in);

		DbConnector dbConnection = new DbConnector(props.getProperty("dbUrl"), props.getProperty("dbUsername"),
				props.getProperty("dbPassword"));

		
		int pid = Integer.parseInt(  request.getParameter("pid") );
		
	
		try {
			ProductService.deleteProduct(dbConnection, pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("showsProduct");
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
