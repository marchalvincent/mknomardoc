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
 * Servlet implementation class ModifyMember
 */
@WebServlet("/UpdateContact")
public class UpdateMember extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMember() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ContactsContainer members = DAOContact.instance.getAllMember();
		request.getSession().setAttribute("members", members);
		request.getRequestDispatcher("./updateContact.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberIdString = request.getParameter("memberId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		StringBuilder sb = new StringBuilder();
		try {
			int memberId = Integer.parseInt(memberIdString);
			// MAJ of informations
			boolean boolInfos = DAOContact.instance.updateContact(memberId,
					firstName, lastName, email);
			if (boolInfos)
				sb.append("You have sucessful modify the member information.<br />");
			else sb.append("Impossible to modify the member informations.<br />");
		} catch (NumberFormatException e) {
			request.setAttribute("message", new String(
					"Impossible to modify the member."));
		}
		request.setAttribute("message", new String(sb.toString()));
		request.getServletContext().getRequestDispatcher("/Main.jsp")
				.forward(request, response);
	}
}
