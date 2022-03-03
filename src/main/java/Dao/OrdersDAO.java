package Dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Context.DBContext;
import model.*;
// Inser information of Order to tada source, that includeing list of
//products in cart(c) and information at buyer in Orders o
public class OrdersDAO {
	Connection conn;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
public int id() throws ServletException, IOException, SQLException {
		
		String sql = "select count(*) from orders ";
		
		conn = new DBContext().getConnection();
		stmt = conn.prepareStatement(sql);
		rs=stmt.executeQuery();
		int count =0;
		
		while(rs.next()){
			count=rs.getInt(1);
		}
		int x= count+1;
		return x;
	}
	public void insertOrder(Orders o,Cart c) throws Exception{
		String sql = "insert into orders values(?,?,?,?,?,?)";
		int x=id();
		conn = new DBContext().getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,o.getUserMail() );
		stmt.setInt(2,x);
		stmt.setInt(3,2);
		stmt.setDate(4,new java.sql.Date(System.currentTimeMillis()));
		stmt.setString(5,String.valueOf(c.getAmount()));
		stmt.setString(6,o.getAddress());

		stmt.executeUpdate();
		
	}
		 


	
	public static void main(String[] args) throws ServletException, IOException, SQLException {
		OrdersDAO x=new OrdersDAO();
		System.out.println(x.id());
	}
}
