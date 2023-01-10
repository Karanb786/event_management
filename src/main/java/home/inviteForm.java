package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/inviteForm")
/**
 * Servlet implementation class inviteForm
 */
public class inviteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inviteForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// declare variables
		PrintWriter pw = response.getWriter();
		String eventName = request.getParameter("eventname");
		String servletDate = request.getParameter("date");
		String servletTime = request.getParameter("time");
		String location = request.getParameter("location");
		String description = request.getParameter("desc");

		// set content type
		response.setContentType("text/html");
		
		//session
		HttpSession session=request.getSession();
		session.setAttribute("eventname",eventName);

		pw.println("<html>");
		pw.println("<head><title>Invitation Form Servlet</title></head>");
		pw.println("<link rel= \"stylesheet\" href = \"invitationStyle.css\">");
		pw.println("<body>");
		pw.println("<h1> Event Details </h1>");
		pw.println("<p id=\"one\">Please confirm the event details</p>");
		pw.println("<form =\"inviteForm\"  onSubmit=\"displayCount\" method=\"post\" action = \"displayCount\" ");

		pw.println("<div>");
		pw.println("<label><b>Event Name: </b></label>" + eventName + "<br>");
		pw.println("</div>");

		pw.println("<div>");
		pw.println("<label><b>Event Date: </b></label>" + servletDate + "<br>");
		pw.println("</div>");

		pw.println("<div>");
		pw.println("<label><b>Event Time: </b></label>" + servletTime + "<br>");
		pw.println("</div>");

		pw.println("<div>");
		pw.println("<label><b>Event Location: </b></label>" + location + "<br>");
		pw.println("</div>");

		pw.println("<div>");
		pw.println("<label><b>Event Description: </b></label>" + description + "<br>");
		pw.println("</div>");

		pw.println("<p id=\"two\">Confirm your presence by clicking on one of the\n"
				+ "		   			below buttons.</p>");
		pw.println("<input type=\"submit\" name = \"yes\" style='margin-right: 16px' value=\"Yes, Attend\">");
		pw.println("<input type=\"submit\" name = \"no\"  style='margin-right: 16px' value=\"Sorry, No!\">");
		pw.println("<input  type=\"submit\" value=\"Reset\" formaction=\"EventFormPage.jsp\" name=\"resetbutton\">");
		
		
		
		// close stream
		pw.println("</form></body></html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);

	}
}
