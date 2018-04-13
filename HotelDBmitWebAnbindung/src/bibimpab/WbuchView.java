package bibimpab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class WbuchView
 */
@WebServlet("/WbuchView")
public class WbuchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbuchView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    response.setContentType("text/html;charset=UTF-8");
			PrintWriter out  = response.getWriter();
			System.out.println("wurde aufgerufen");
			ArrayList<Buchung> blist = new ArrayList<>();
			HttpSession session = request.getSession(true);
			List<Tabelle> list;
			try {
				list = new ArrayList<>();
				DBManager manager = DBManager.getInstance();
				blist = manager.readGidBuchung((int)session.getAttribute("id"));
				for(int i=0; i<blist.size();i++){
					Buchung b = blist.get(i);
					String field1 = b.getId();
					String field2 = b.getZid();
					String field3 = b.getGid();
					String field4 = b.getVonStr();
					String field5 = b.getBisStr();
					String field6 = b.getAnz()+"";
					String field7 = b.isBezahlt()+"";
					
					
					Tabelle tab = new Tabelle(field1, field2, field3, field4, field5, field6, field7);
					list.add(tab);
				}
			
				Gson gson = new Gson();
				String antwort = gson.toJson(list);
				out.println(antwort);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
