package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Advertise;

@ManagedBean(eager = true)
@SessionScoped
public class AdvertiseController {
	
	private Advertise currentAdvertise = new Advertise();
	private ArrayList<Advertise> advertises = new ArrayList<Advertise>();
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ip16malioglasi?characterEncoding=utf8";
	private String username = "root";
	private String password = "root";
	private Connection connection = null;
	private PreparedStatement ps = null;
	private String INSERT_ADVERTISE = "INSERT INTO advertise (userId, title, description) VALUES (?,?,?)";
	private String SELECT_ADVERTISES =  "SELECT * FROM advertise";
	private String DELETE_ADVERTISE_BY_ID = "DELETE FROM advertise WHERE id = ?";
	
	public AdvertiseController() throws ClassNotFoundException {
		Class.forName(driver);
	}
	
	public Advertise getCurrentAdvertise() {
		return currentAdvertise;
	}

	public void setCurrentAdvertise(Advertise currentAdvertise) {
		this.currentAdvertise = currentAdvertise;
	}

	public String createAdvertise(int id) throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(INSERT_ADVERTISE);
		ps.setInt(1, id);
		ps.setString(2, currentAdvertise.getTitle());
		ps.setString(3, currentAdvertise.getDescription());
		ps.execute();
		currentAdvertise = new Advertise();
		connection.close();
		return "index.xhtml";
	}
	
	public ArrayList<Advertise> getAdvertises() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(SELECT_ADVERTISES);
		advertises = new ArrayList<Advertise>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Advertise temp = new Advertise();
			temp.setId(rs.getInt("id"));
			temp.setTitle(rs.getString("title"));
			temp.setDescription(rs.getString("description"));
			// potrebno je setovati i korisnika koji je postavio oglas
			advertises.add(temp);
		}
		connection.close();
		return advertises;
	}
	
	public String deleteAdvertise(int id) throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		ps = connection.prepareStatement(DELETE_ADVERTISE_BY_ID);
		ps.setInt(1, id);
		ps.execute();
		connection.close();
		System.out.println(ps);
		return "index.xhtml";
	}
}
