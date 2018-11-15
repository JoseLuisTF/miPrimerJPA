package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import dao.EstudianteDao;
import entities.Estudiante;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("code");
		String password = request.getParameter("password");

		EstudianteDao edao = new EstudianteDao();
		Estudiante estudiante = edao.find(username);

		if (estudiante != null) {
			if (password.equals(estudiante.getClave())) {
				HttpSession session = request.getSession();
				session.setAttribute("student", estudiante);
				request.getRequestDispatcher("UserView.jsp").forward(request, response);
			} else {
				response.getWriter().append("Usuario o contraseña invalidos");
				request.getRequestDispatcher("").forward(request, response);
			}
		} else {
			response.getWriter().append("Usuario o contraseña invalidos");
			request.getRequestDispatcher("").forward(request, response);
		}
		

	}

}
