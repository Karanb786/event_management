package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class displayCount
 */
public class displayCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	// declare count variables
	public int yesCount = 0;
	public int noCount = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();

		// set content type
		response.setContentType("text/html");
		String yescount = request.getParameter("yes");
		String nocount = request.getParameter("no");
		
		//session attributes
		HttpSession session=request.getSession(false);
		String event_name =(String)session.getAttribute("eventname");

		if (yescount != null) {
			yesCount++;
		} else if (nocount != null) {
			noCount++;
		}

		// int yes = request.getAttribute("yescount");
		// int yes = ((Integer)request.getAttribute("yescount")).intValue();

		// HttpSession session=request.getSession(false);
		// int desc = ((Integer)session.getAttribute("yescount")).intValue();

		pw.println("<html>");
		pw.println("<head><title>Display Count Servlet</title></head>");
		pw.println("<link rel= \"stylesheet\" href = \"invitationStyle.css\">");
		pw.println("<body>");
		pw.println("<h1> People Count </h1>");
		pw.println("<p id=\"one\">Total Count of the responded people for event: ");
		pw.println("<b><u><i><font size = \"+2\" color = \"DarkRed\">" + event_name +  "</b></u></i></font>");
		
		pw.println("</p>");
		
		pw.println("<form>");

		pw.println("<div>");
		pw.println("<label><b>People Attending: </b></label>" + yesCount + "<br>");
		pw.println("</div>");

		pw.println("<div>");
		pw.println("<label><b>People not Attending </b></label>" + noCount + "<br>");
		pw.println("</div>");
		pw.println("<br>");
		
		pw.println("<input  type=\"submit\" value=\"Reset\" formaction=\"EventFormPage.jsp\" name=\"resetbutton\">");
		
		pw.println("</form></body></html>");
		pw.close();
	}

}
