package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class eventList
 */
@WebServlet("/eventList")
public class eventList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "  <head>\n"
				+ "    <meta charset=\"UTF-8\" />\n"
				+ "    <title>Event List</title>\n"
				+ "     <h1>Confirm your event!</h1>"
				+ "		<lable for=submit>Confirm event</lable>\n"
				+ "<input type=\"submit\" value=\"Confirm\" id = \"submit\"  onclick=\"seeEvents()\" action=\"userEvents.jsp\"></input>\n"
				+ " "
				+ "    <link rel=\"stylesheet\" href=\"drawer.css\" />\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "    <div id=\"app\"></div>\n"
				+ "    <script src=\"drawerValidator.js\"></script>\n"
				+ "  </body>\n"
				+ "</html>\n"
				+ "");

		


		
	
		

		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
