package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.User;
import model.Account;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {

			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from a login form
			String name = request.getParameter("name");
			String user = request.getParameter("email");
			String password = request.getParameter("pass");
			String repassword = request.getParameter("repass");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");

			// email and password must match regex
			if (!password.matches(regex) || !user.matches(regexMail)) {
				request.setAttribute("error", "invalid syntax");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				return;
			}

			// check account
			if (!password.equals(repassword)) {
				request.setAttribute("error", "two password not match !");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				return;
			}
			// check exist email in database
			if (new User().exist(user)) {
				request.setAttribute("error", "email had exist in system!");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				return;
			}
			// create account and direction to login
			else {

				new User().insert(user, password, name, address, phone);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		}/* catch (NullPointerException e) {
			request.setAttribute("error", "xxxxx!");
			request.getRequestDispatcher("Register.jsp").forward(request, response);

		}*/ catch (Exception ex) {
			response.getWriter().println(ex);
		}

	}

}
