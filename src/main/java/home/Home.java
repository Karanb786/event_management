
package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");

		out.println("<TITLE>Invitation</TITLE>");
		out.println("</HEAD>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">");


		out.println("<BODY>");
		out.println("<h1>Create invitation</h1>");
		
		out.println("<form name=\"myForm\" action=\"home_handle\" method=\"post\">"+

		"Event Name:"+
		"<input type=\"text\" name = \"eventname\">"+

		"<lable for=\"date\">Date:</lable>"+
		"<input type=\"date\" name = \"date\">"+

		"<lable for=\"time\">Time:</lable>"+
		"<input type=\"time\" name = \"time\">"+

		"<lable for =\"location\">Location:</lable>"+
		"<input type=\"text\" name = \"location\" placeholder=\"Please describe location\">"+

		"<lable for=\"description\">Description of event:</lable>"+
		"<textarea rows=\"10\" cols=\"10\" name = \"description\" placeholder=\"Please describe event\"></textarea>"+
		
		"<label for=\"quantity\">How many people?:</label>"+
		"<input type=\"number\" id=\"quantity\" name=\"quantity\">"+


		"<lable for=submit></lable>"+
		"<input type=\"submit\" value=\"Submit\" onclick=\"finalfunc()\">"+
		
		


		"</form>");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
