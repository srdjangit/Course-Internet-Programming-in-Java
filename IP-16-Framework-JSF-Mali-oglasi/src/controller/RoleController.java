package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Role;

@ManagedBean(eager = true)
@SessionScoped
public class RoleController {

	private ArrayList<Role> roles = new ArrayList<Role>();
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ip16malioglasi?characterEncoding=utf8";
	private String username = "root";
	private String password = "root";
	private Connection connection = null;
	private PreparedStatement ps = null;
	private String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";
	private String SELECT_ROLES = "SELECT * FROM role";
	
	public RoleController() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
	}
	
	public ArrayList<Role> getRoles() throws SQLException {
		
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(SELECT_ROLES);
		ResultSet rs = ps.executeQuery();
		roles = new ArrayList<Role>();
		while(rs.next()) {
			Role temp = new Role();
			temp.setId(Integer.parseInt(rs.getString("id")));
			temp.setName(rs.getString("name"));
			temp.setDescription(rs.getString("description"));
			roles.add(temp);
		}
		connection.close();
		return roles;
	}
	
	public Role getRoleById(int id) throws SQLException {
		
		connection = DriverManager.getConnection(url,username,password);
		Role roleById = new Role();
		ps = connection.prepareStatement(SELECT_ROLE_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			roleById.setId(Integer.parseInt(rs.getString("id")));
			roleById.setName(rs.getString("name"));
			roleById.setDescription(rs.getString("description"));
		}
		connection.close();
		return roleById;
	}
}
