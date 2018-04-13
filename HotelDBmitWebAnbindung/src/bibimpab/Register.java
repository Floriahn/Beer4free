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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
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
			String nachname = request.getParameter("surname");
			String name = request.getParameter("name");
			String dat = request.getParameter("date");
			String plz = request.getParameter("plz");
			String land = request.getParameter("land");
			String hausnmr = request.getParameter("hnr");
			String number = request.getParameter("nmr");
			
			
			//Login checken / Daten verarbeiten
			try {
				DBManager manager = DBManager.getInstance();
				id= manager.readGidbyNNN(nachname, name);
				if(id==0){
					Gast g = new Gast(nachname, dat, plz, land, hausnmr, number, name);
					manager.insertGast(g);
					id = manager.readGidbyNNN(nachname, name);
					manager.insertLogin(id, mail, passwort);
				}else{
					manager.insertLogin(id, mail, passwort);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.print("sdaf");
			//Zum View weitwerleiten
			
				RequestDispatcher view = request.getRequestDispatcher("LoginMask.html");						
				view.forward(request, response);

	}

}
