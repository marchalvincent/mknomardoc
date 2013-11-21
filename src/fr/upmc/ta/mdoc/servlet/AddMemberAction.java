package fr.upmc.ta.mdoc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.ta.mdoc.dao.DAOMember;

/**
 * Servlet implementation class AddMembmer
 */
@WebServlet("/AddMemberAction")
public class AddMemberAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./404").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String ageString = request.getParameter("age");
		int age;
		try {
			age = Integer.parseInt(ageString);
		} catch (NumberFormatException e) {
			age = 0;
		}
		
		boolean success = DAOMember.instance.createMember(login, password, age);
		if (success) {
			request.setAttribute("message", new String("You have succesful create the member."));
		}
		else {
			request.setAttribute("message", "An error occurs during the creation.");
		}

		request.getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
		
	}

}
