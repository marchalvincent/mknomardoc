package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.ContactsContainer;
import domain.DAOContact;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/RemoveContact")
public class RemoveContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveContact() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ContactsContainer members = DAOContact.instance.getAllMember();
		request.getSession().setAttribute("members", members);
		request.getRequestDispatcher("./removeContact.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberIdString = request.getParameter("memberId");
		try {
			int memberId = Integer.parseInt(memberIdString);
			boolean bool = DAOContact.instance.deleteContact(memberId);
			if (bool)
				request.setAttribute("message", new String(
						"You have successful delete the member."));
			else request.setAttribute("message", new String(
					"Impossible to delete the member."));
		} catch (NumberFormatException e) {
			request.setAttribute("message", new String(
					"Impossible to delete the member."));
		}
		request.getServletContext().getRequestDispatcher("/Main.jsp")
				.forward(request, response);
	}
}
