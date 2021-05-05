
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class StartHibernateServlet
 */
@WebServlet("/StartHibernateServlet")
public class StartHibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartHibernateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionFactory factory = HibernateUtil.sessionFactory();

		Session hSession = factory.openSession();

		
		  Transaction transaction = hSession.beginTransaction();
		  
		  Employee ep1 = new Employee(3, "Jane", "Doe");
		  
		  hSession.save(ep1);
		  
		  transaction.commit();
		 

		
		List<Employee> employeesList = hSession.createQuery("from Employee where employeeId = 1 ").list();
		
		response.getWriter().print("<html><body>");
		
		
		
		for(Employee tmp : employeesList ) {
			
			response.getWriter().print("ID:"+ tmp.getEmployeeId()+" | "+ tmp.getFirstName()+" "+tmp.getLastName()+"<br>" );
			
			
		}
		
		response.getWriter().print("</body></html>");
		
		
		
		response.getWriter().print("Hibernate is Working");

		hSession.close();

		response.getWriter().print("Hibernate is Done!");

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
