package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import Context.DBContext;
import model.*;

public class User {
	Connection conn;
	PreparedStatement stmt = null;
	ResultSet rs = null;

// create accout
	
	public void insert(String mail, String pass, String username, String address, String phone)
			throws SQLException, ServletException, IOException {
		String sql = "insert into account values(?,?,2,?,?,?)";

		conn = new DBContext().getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, mail);
		stmt.setString(2, pass);
		stmt.setString(3, username);
		stmt.setString(4, address);
		stmt.setString(5, phone);

		stmt.executeUpdate();
		stmt.close();
	}

	// account
	public Account getAccount(String character) throws SQLException, ServletException, IOException

	{
		String sql = "select * from account where user_mail=?";
		conn = new DBContext().getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, character);

		rs = stmt.executeQuery();
		while (rs.next()) {
			Account x = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getString(6));

			return x;
		}

		return null;

	}

	public boolean exist(String email) throws SQLException, ServletException, IOException

	{
		String sql = "select count(*) as count from account where user_mail=?";
		conn = new DBContext().getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);

		rs = stmt.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
			rs.close();
		}

		if (count == 0) {
			System.out.println(count);
			return false;
		} else {
			System.out.println(count);
			return true;
		}

	}

	public static void main(String[] args) throws Exception {
		User u = new User();
		u.insert("thanhvt604@gmail.com","123", "thanh", "123", "1234567");
	
	}
}
