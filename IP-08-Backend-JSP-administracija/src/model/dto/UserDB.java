package model.dto;

import java.util.ArrayList;

public class UserDB {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public UserDB() {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		users.add(admin);
		User user = new User();
		user.setUsername("user");
		user.setPassword("user");
		users.add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
