package fr.upmc.ta.mdoc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.ta.mdoc.dao.DAOMember;
import fr.upmc.ta.mdoc.object.MembersContainer;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersContainer members = DAOMember.instance.getAllMember();
		request.getSession().setAttribute("members", members);
		request.getRequestDispatcher("./DeleteMember.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberIdString = request.getParameter("memberId");
		
		try {
			int memberId = Integer.parseInt(memberIdString);
			boolean bool = DAOMember.instance.deleteMember(memberId);
			if (bool)
				request.setAttribute("message", new String("You have successful delete the member."));
			else
				request.setAttribute("message", new String("Impossible to delete the member."));
		} catch (NumberFormatException e) {
			request.setAttribute("message", new String("Impossible to delete the member."));
		}
		request.getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
	}

}
