package controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarreraDao;
import dao.EstudianteDao;
import entities.Carrera;
import entities.Estudiante;
import entities.User;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
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
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String last_name = request.getParameter("last_name");
		String password = request.getParameter("password");
		CarreraDao cdao = new CarreraDao();
		Carrera carrera = cdao.find(code.substring(0, 2));
		
		if (carrera != null) {
			Estudiante student = new Estudiante(code, last_name, password, new Date(), "M", name, carrera);
			EstudianteDao edao = new EstudianteDao();
			Estudiante e = edao.find(code);
			if (e == null) {
				edao.insert(student);
				response.getWriter().append("Registered correctly, you can log in now");
				request.getRequestDispatcher("SignIn.jsp").forward(request, response);
			} else {
				response.getWriter().append("Code alredy existes");
				request.getRequestDispatcher("").forward(request, response);
			}
		} else {
			response.getWriter().append("Codigo de la carrera no existe");
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
