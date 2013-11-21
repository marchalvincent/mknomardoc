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
//		String memberIdString = request.getParameter("memberId");
//		String memberIdString = request.getParameter("memberId");
//		String memberIdString = request.getParameter("memberId");
//		String memberIdString = request.getParameter("memberId");
		// TODO
	}

}
