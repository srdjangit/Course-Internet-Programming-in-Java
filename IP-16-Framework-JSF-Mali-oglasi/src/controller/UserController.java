package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;

@ManagedBean(eager = true)
@SessionScoped
public class UserController {

	private User currentUser = new User();
	private User loggedUser = new User();
	private User newUser = new User();
	private ArrayList<User> users = new ArrayList<User>();
	private RoleController roleController = new RoleController();
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ip16malioglasi?characterEncoding=utf8";
	private String username = "root";
	private String password = "root";
	private Connection connection = null;
	private PreparedStatement ps = null;
	private String SELECT_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";
	private String SELECT_USERS = "SELECT * FROM user";
	private String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
	private String UPDATE_USER_BY_ID = "UPDATE user SET username = ?, password = ?, roleId = ?, email = ? WHERE id = ?";
	private String INSERT_USER = "INSERT INTO user (username, password, roleId, email) VALUES (?,?,?,?)";
	private String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";
	
	public UserController() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
	}
	
	public User getNewUser() {
		return newUser;
	}
	
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public ArrayList<User> getUsers() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(SELECT_USERS);
		users = new ArrayList<User>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User temp = new User();
			temp.setId(rs.getInt("id"));
			temp.setUsername(rs.getString("username"));
			temp.setPassword(rs.getString("password"));
			temp.setRole(roleController.getRoleById(rs.getInt("roleId")));
			temp.setEmail(rs.getString("email"));
			users.add(temp);
		}
		connection.close();
		return users;
	}
	
	public String login() throws SQLException {
		String retVal = "login.xhtml";
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(SELECT_LOGIN);
		ps.setString(1, currentUser.getUsername());
		ps.setString(2, currentUser.getPassword());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			loggedUser.setId(rs.getInt("id"));
			loggedUser.setUsername(rs.getString("username"));
			loggedUser.setPassword(rs.getString("password"));
			loggedUser.setRole(roleController.getRoleById(rs.getInt("roleId")));
			loggedUser.setEmail(rs.getString("email"));
			
			if (loggedUser.getRole().getName().equalsIgnoreCase("admin")) {
				retVal = "app-admin/index.xhtml";
			}
			else if (loggedUser.getRole().getName().equalsIgnoreCase("moderator")) {
				retVal = "app-moderator/index.xhtml";
			}
			else {
				retVal = "app-user/index.xhtml";
			}
		}
		System.out.println("Stanje korisnika: " + retVal);
		connection.close();
		return retVal;
	}
	
	public String logout() {
		loggedUser = new User();
		currentUser = new User();
		return "../index.xhtml";
	}
	
	public String selectUserById(int id, String action) throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(SELECT_USER_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		currentUser = new User();
		while (rs.next()) {
			currentUser.setId(rs.getInt("id"));
			currentUser.setUsername(rs.getString("username"));
			currentUser.setPassword(rs.getString("password"));
			currentUser.setEmail(rs.getString("email"));
			currentUser.setRole(roleController.getRoleById(rs.getInt("roleId")));
		}
		return action;
	}
	
	public String updateUserById() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(UPDATE_USER_BY_ID);
		ps.setString(1, currentUser.getUsername());
		ps.setString(2, currentUser.getPassword());
		ps.setInt(3, currentUser.getRole().getId());
		ps.setString(4, currentUser.getEmail());
		ps.setInt(5, currentUser.getId());
		System.out.println(ps);
		ps.execute();
		connection.close();
		return "index.xhtml";
		
	}
	
	public String createUser() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(INSERT_USER);
		ps.setString(1, newUser.getUsername());
		ps.setString(2, newUser.getPassword());
		ps.setInt(3, newUser.getRole().getId());
		ps.setString(4, newUser.getEmail());
		ps.execute();
		newUser = new User();
		connection.close();
		return "index.xhtml";
	}
	
	public String deleteUser() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(DELETE_USER_BY_ID);
		ps.setInt(1, currentUser.getId());
		ps.execute();
		connection.close();
		return "index.xhtml";
	}
}
