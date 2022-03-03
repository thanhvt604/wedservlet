package Context;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBContext
 */
@WebServlet("/DBContext")
public class DBContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBContext() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws SQLException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public Connection getConnection() throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//Change/update information of your database connection
		final String serverName="localhost";
		final String portId="3306";
		final String dbName="shoppingdb";
		final String User="root";
		final String password="summomnight1711";
		
		Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://"+serverName+":"+portId+"/"+dbName,User,password);
		
		return conn;
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
