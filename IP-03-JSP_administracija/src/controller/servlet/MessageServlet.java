package controller.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Message;
import model.dto.MessageDB;

@WebServlet({"/MessageServlet","/kreirajVijest"})
public class MessageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nova vijest!");
		if (request.getRequestURI().contains("/kreirajVijest")) {
			String title = request.getParameter("title").toString();
			String content = request.getParameter("content").toString();
			
			MessageDB messageDB = (MessageDB) request.getServletContext().getAttribute("messageDB");
			if (messageDB == null) {
				messageDB = new MessageDB();
			}
			
			Message novaVijest = new Message();
			novaVijest.setDate(new Date());
			novaVijest.setTitle(title);
			novaVijest.setContent(content);
			
			messageDB.getMessages().add(novaVijest);
			
			request.getServletContext().setAttribute("messageDB", messageDB);
			
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("user.jsp");
			dispatcher.forward(request, response);
		}
	}

}
