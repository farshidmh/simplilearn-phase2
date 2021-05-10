package com.sample;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String uName = request.getParameter("user");
		String password = request.getParameter("pass");
		String fullName= request.getParameter("fullName");
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction t = session.beginTransaction();
		
		User userToUpdated = session.load(User.class, uid);
		
		userToUpdated.setUsername(uName);
		userToUpdated.setPassword(password);
		userToUpdated.setFullName(fullName);
		
		
		
		session.save(userToUpdated);
		
		t.commit();
		session.close();
		
		
		response.sendRedirect("userList.jsp");
	
		
		
		
		
	}

}
