package com.sample.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.service.DbConnector;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();
		props.load(in);

		DbConnector dbConnection = new DbConnector(props.getProperty("dbUrl"), props.getProperty("dbUsername"),
				props.getProperty("dbPassword"));


		
		response.getWriter().print("<html><body>");
		
	
		try {
			Statement stmt = dbConnection.getConnection().createStatement();
			
			ResultSet rslt = stmt.executeQuery("select * from tbl_product");
			
			while(rslt.next() ) {
				
				
				response.getWriter().print(  rslt.getString(2)+" | "+rslt.getInt(3)+" | "+ rslt.getInt(4)+" <a href='deleteProduct?pid="+rslt.getInt(1)+"'> Delete </a> | <a href='updateProduct?pid="+rslt.getInt(1)+"' >Update</a> " );
				
				response.getWriter().print("<br>");
				
				
			}
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.getWriter().print("</body></html>");
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
