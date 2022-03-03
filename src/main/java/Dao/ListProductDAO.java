package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Context.DBContext;
import model.*;
public class ListProductDAO {
	Connection conn;
	PreparedStatement stmt =null;
	ResultSet rs=null;
	
	
	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public List<Product> search (String characters)throws Exception{
		List <Product> list =new ArrayList<>();
		String sql= "select * from products where product_name like ?";
		conn=new DBContext().getConnection();
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,"%"+characters+"%");
			rs =stmt.executeQuery();
			while(rs.next())
			{
				list.add(new  Product(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getFloat(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7)));
			}
		return list;
	}
		
		
	
	
	
	public Product getProduct(int characters) throws Exception
	
	{
		String sql= "select * from products where product_id= ?";
		conn=new DBContext().getConnection();
		stmt=conn.prepareStatement(sql);
		stmt.setInt(1,characters);
			rs =stmt.executeQuery();
			while(rs.next())
			{
				Product x=new Product(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getFloat(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7));
				return x;
			}
		
		
		return null;
		
	}
	public List<Product> allProduct(int num)throws Exception {
		List <Product> list =new ArrayList<>();
		String sql= "select * from products\n"
				+ "limit ?,6";
		conn=new DBContext().getConnection();
		stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1, num);	
			rs =stmt.executeQuery();
			while(rs.next())
			{
				list.add(new  Product(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getFloat(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7)));
			}
		return list;
	}

public static void main(String[] args) throws Exception {
	ListProductDAO dao=new ListProductDAO();
	
	Product z=dao.getProduct(1);
	System.out.println(z);

	
}
	
}


