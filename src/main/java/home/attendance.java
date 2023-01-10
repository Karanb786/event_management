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
 * Servlet implementation class attendance
 */
@WebServlet("/attendance")
public class attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attendance() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public int peopleCount;
	/**
	 * 
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
			PrintWriter pw = response.getWriter();

			HttpSession session=request.getSession(false);
			String eventName =(String)session.getAttribute("eventname");
			peopleCount = Integer.parseInt((String)session.getAttribute("peopleCount"));
			String attend = request.getParameter("Q1");
			pw.println("<link rel= \"stylesheet\" href = \"style.css\">");
			if(peopleCount==0) {
				response.setContentType("text/html");
				pw.println("<h1>Sorry! The event is full!</h1>️");
			}else {
			if(attend.equals("yes")){
			response.setContentType("text/html");
			peopleCount-=1;
			pw.println("<h1>Thanks for attending the event: </h1>"+eventName+"<br>");
			pw.println("Reamining invites :"+peopleCount+"<br>");
			pw.println("<form>");
			pw.println("<input  type=\"reset\" value=\"Reset\" formaction=\"form.jsp\" name=\"resetbutton\">");
			pw.println("</form>");
			

		}else {
			response.setContentType("text/html");
			pw.println("<h1>Ok, see you in other event</h1><br>");
			pw.println("<form>");
			pw.println("<input  type=\"reset\" value=\"Reset\" formaction=\"form.jsp\" name=\"resetbutton\">");
			pw.println("</form>");
			
		}
			}


	}

}
