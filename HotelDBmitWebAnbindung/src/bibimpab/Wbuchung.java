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
 * Servlet implementation class Wbuchung
 */
@WebServlet("/Wbuchung")
public class Wbuchung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Gast g;
	Zimmer z;
	Buchung b;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wbuchung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		
		//Parameter lesen
		String von = request.getParameter("von");
		String bis = request.getParameter("bis");
		int anz = Integer.parseInt(request.getParameter("anz"));
		
		//Login checken / Daten verarbeiten
		try {
			DBManager manager = DBManager.getInstance();
			g = manager.readGastbyID((int)session.getAttribute("id"));
			z = manager.readZimmerbyBetten(anz).get(0);
			b = new Buchung(g, z, von, bis, anz, false);
			manager.insertBuchung(b);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.print("sdaf");
		//Zum View weitwerleiten
		
			RequestDispatcher view = request.getRequestDispatcher("Welcome.jsp");
			view.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
