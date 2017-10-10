/*
 * UserServlet je klasa koja vrsi sve funkcionalnosti vezane za korisnike
 * - servlet posjeduje dvije osnovne funkcije doPost i doGet
 * - doPost je funkcija koja se aktivira kada se podaci iz HTML stranice proslijede putem POST-a
 * - doGet je funkcija koja se aktivira kada se podaci iz HTML stranice proslijede putem GET-a
 */
package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.UserDB;
import model.dto.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/UserServlet" , "/login", "/obrisiKorisnika", "/kreirajKorisnika" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* Sta radi prvi IF?
		 * - provjerava da li zahtjev sadrzi /kreirajKorisnika
		 */
		if(request.getRequestURI().contains("/kreirajKorisnika")) {
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			
			UserDB userDB = (UserDB) request.getServletContext().getAttribute("userDB");
			if (userDB == null) {
				userDB = new UserDB();
			}
			
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			
			userDB.getUsers().add(newUser);
			
			request.getServletContext().setAttribute("userDB", userDB);
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		/* Sta radi ovaj IF?
		 * - provjerava da li zahtjev sadrzi login
		 */
		if (request.getRequestURI().contains("/login")) {
			
			// request.getParameter koristi se za preuzimanje parametara iz HTML forme, tj. iz request-a
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			System.out.println("Login: " + username + " : " + password);
			
			
			/* Provjera da li postoji objekat userDB i ako ne postoji kreiranje istog */
			UserDB userDB = (UserDB) request.getServletContext().getAttribute("userDB");
			if (userDB == null) {
				userDB = new UserDB();
			}
			
			// Smjestanje trenutnog userDB objekta u request
			request.getServletContext().setAttribute("userDB", userDB);
			
			// kreiranje objekta dispatcher tipa RequestDispatcher
			RequestDispatcher dispatcher = null;
			
			/* For petlja koja prolazi kroz ArrayList 
			 * for (objekat u jednini : ArrayList, tj. objekat u mnozini)
			 * */
			for (User user : userDB.getUsers()) {
				if (username.equals(user.getUsername()) && password.equalsIgnoreCase(user.getPassword())) {
					if (username.equalsIgnoreCase("admin")) {
						// pripremi dispatcher na takav nacin da pokazuje na admin.jsp
						dispatcher = request.getRequestDispatcher("admin.jsp");
					}
					else {
						// pripremi dispatcher na takav nacin da pokazuje na user.jsp
						dispatcher = request.getRequestDispatcher("user.jsp");
					}
					break;
				}
				// u slucaju da nije logovan
				// pripremi dispatcher na takav nacin da pokazuje na greska.jsp
				dispatcher = request.getRequestDispatcher("greska.jsp");
			}
			// aktiviranje dispatcher
			dispatcher.forward(request, response);
		}
	}
	
	
}
