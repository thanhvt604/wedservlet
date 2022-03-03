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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
			request.getSession(true).invalidate();	
			PrintWriter out=response.getWriter();
			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from a login form
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			String checkbox=request.getParameter("check");
			Account acc = new Account();
			acc.setUser(user);
			acc.setPassword(password);
			
			HttpSession session = request.getSession(true);
			
			
			
				if (!password.matches(regex) || !user.matches(regexMail)) {
					session.setAttribute("error", "invalid syntax");
					response.sendRedirect("login.jsp");
					return;
				}
				
				// read information of account in sql
				
				String uid = new User().getAccount(user).getUser();
				String pwd = new User().getAccount(user).getPassword();
				// check account
				if (user != null && acc.getPassword().equals(pwd) && acc.getUser().equalsIgnoreCase(uid)) {
					Account login=new User().getAccount(user);
					session.setAttribute("error", " ");					
					session.setAttribute("user", login);
					response.sendRedirect("index");

				} else {

					 session.setAttribute("error", "wrong name user or password !");
					response.sendRedirect("login.jsp");

				}
				
			
			
			

		} catch (NullPointerException e) {

			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}

	}

}
