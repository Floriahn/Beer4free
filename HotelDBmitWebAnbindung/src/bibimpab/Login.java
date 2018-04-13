package bibimpab;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gast g;
	int id;
	boolean log =false;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession(true);

		
		//Parameter lesen
		String mail = request.getParameter("mail");
		String passwort = request.getParameter("pwd");
		
		//Login checken / Daten verarbeiten
		try {
			DBManager manager = DBManager.getInstance();
			log=manager.checkPass(passwort, mail);
			if(log){
				id = manager.readGidbyMail(mail);
				session.setAttribute("id", id);		
				g = manager.readGastbyID(id);
				session.setAttribute("name", g.getNachname());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.print("sdaf");
		//Zum View weitwerleiten
		if(log){
			RequestDispatcher view = request.getRequestDispatcher("Welcome.jsp");
			view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("LoginMask.html");						
			view.forward(request, response);
		}
	}
}