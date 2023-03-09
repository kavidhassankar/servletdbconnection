package com.servlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dto.User;


public class DbUtil {

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj","mysql_demo_tnj", "Ebrain@20");
		return con;
	}

	public static void saveUser(User member) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String insertQuery = "INSERT INTO tb_kavidhass_employee_address VALUES (?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(insertQuery);
		if (member.getId() != null) {
			pst.setInt(1, member.getId().intValue());
		} else {
			pst.setNull(1, java.sql.Types.INTEGER);
		}
		pst.setString(2, member.getName());
		pst.setString(3, member.getEmail());
		pst.setString(4, member.getPhone());
		pst.executeUpdate();
		pst.close();
		con.close();
	}
	public static void deleteUser(User member) throws SQLException, ClassNotFoundException {
		Connection con =getConnection();
		String insertQuery = "delete from tb_kavidhass_employee_address where id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, member.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public static void updateUser(User member) throws SQLException, ClassNotFoundException {
		
		Connection con =getConnection();
		String insertQuery = "update tb_kavidhass_employee_address set name = ?,email = ?,phone = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setString(1, member.getName());
		ps.setString(2, member.getEmail());
		ps.setString(3, member.getPhone());
		ps.setInt(4, member.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public static List<User> getAll(Integer id) throws SQLException, ClassNotFoundException {
	    List<User> members = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement("SELECT id, name, email, phone FROM tb_kavidhass_employee_address WHERE id = ?")) {
	        ps.setInt(1, id);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                members.add(user);
	            }
	        }
	    }

	    return members;
	}
	}

	

