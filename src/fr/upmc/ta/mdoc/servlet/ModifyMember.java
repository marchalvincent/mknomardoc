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
 * Servlet implementation class ModifyMember
 */
@WebServlet("/ModifyMember")
public class ModifyMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMember() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersContainer members = DAOMember.instance.getAllMember();
		request.getSession().setAttribute("members", members);
		request.getRequestDispatcher("./ModifyMember.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberIdString = request.getParameter("memberId");
		String login = request.getParameter("login");
		String ageString = request.getParameter("age");
		String oldPassword = request.getParameter("oldPassword");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		StringBuilder sb = new StringBuilder();
		try {
			int memberId = Integer.parseInt(memberIdString);
			
			int age = 0;
			try {
				age = Integer.parseInt(ageString);
			} catch (NumberFormatException e) {
				// already tested in JS
			}
			
			// MAJ of informations
			boolean boolInfos = DAOMember.instance.updateMember(memberId, login, age);
			if (boolInfos)
				sb.append("You have sucessful modify the member information.<br />");
			else
				sb.append("Impossible to modify the member informations.<br />");
			
			// MAJ of password 
			if (password1.equals(password2)) {
				boolean boolPass = DAOMember.instance.updateMemberPassword(memberId, oldPassword, password1);
				if (boolPass)
					sb.append("You have sucessful modify the member password.");
				else
					sb.append("Impossible to modify the member password.");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message", new String("Impossible to modify the member."));
		}
		
		request.setAttribute("message", new String(sb.toString()));
		request.getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
	}

}
