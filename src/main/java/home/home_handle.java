package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class home_handle
 */
@WebServlet("/home_handle")
public class home_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home_handle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eventname = request.getParameter("eventname");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String peopleCount =request.getParameter("quantity");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.setAttribute("eventname",eventname);
		session.setAttribute("peopleCount", peopleCount);



		PrintWriter pw = response.getWriter();

		pw.println("<head><title>Invitation</title></head>");
		pw.println("<link rel= \"stylesheet\" href = \"style.css\">");
		pw.println("<body>");
		pw.println("<script type=\"text/javascript\" src=\"result.js\" ></script>");
		pw.println("<h1> Event Details </h1>");
		pw.println("<p id=\"one\">Please confirm the event details</p>");

		pw.println("<b>Event name: </b><span id=\"eventname-filler\"></span> ");
		pw.println("<br>");
		pw.println("<b>Event Date: </b><span id=\"eventDate-filler\"></span> ");
		pw.println("<br>");
		pw.println("<b>Event Time: </b><span id=\"eventTime-filler\"></span> ");
		pw.println("<br>");
		pw.println("<b>Event Location: </b><span id=\"eventLocation-filler\"></span> ");
		pw.println("<br>");
		pw.println("<b>Event Description: </b><span id=\"eventDescp-filler\"></span> ");
		pw.println("<br>");
		pw.println("<b>Total seat reamining: </b><span id=\"eventCount-filler\"></span> ");
		pw.println("<br>");

		pw.println("<form =\"inviteForm\"  onSubmit=\"attendance\" method=\"post\" action = \"attendance\" ");

		pw.println("<input type = \"radio\" name = \"Q1\" value=\"yes\"> Yes " +
		    	"<input type = \"radio\" name = \"Q1\" value=\"no\"> No<br>" +
		    	"<lable for=submit></lable>"+
		   		"<Center><input type=\"submit\" value=\"Submit\"></Center>");
		pw.println("<input  type=\"submit\" value=\"Reset\" formaction=\"form.jsp\" name=\"resetbutton\">");
		// close stream
		pw.println("</form></body></html>");
		pw.close();
				
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
