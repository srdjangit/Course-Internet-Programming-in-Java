/*
 * Klasa UserDB skladisti sve objekte tipa User
 */
package model.dto;

import java.util.ArrayList;

public class UserDB {
	
	/* Atribut tipa ArrayList */
	private ArrayList<User> users = new ArrayList<User>();
	
	/*
	 * Ova klasa posjeduje i konstruktor, UserDB()
	 */
	public UserDB() {
		/* Sta se dogadja unutar konstruktora?
		 * - kreiraju se dva objekta admin i user
		 * - podesavaju se atributi kreiranih objekata
		 * - Objekat users (tj. ArrayList) dopunjava se ovim objektima
		 */
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
