package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Counter;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET REQUEST");
		
		// logika
		Counter counter = (Counter) request.getServletContext().getAttribute("counter");
		if(counter == null) {
			counter = new Counter();
		}
		
		if (request.getLocalAddr().contains(".")) {
			counter.setIPv4get(counter.getIPv4get()+1);
		}
		else if (request.getLocalAddr().contains(":")) {
			counter.setIPv6get(counter.getIPv6get()+1);
		}
		System.out.println("IPv4 GET counter: " + counter.getIPv4get());
		System.out.println("IPv6 GET counter: " + counter.getIPv6get());
		System.out.println("IPv4 POST counter: " + counter.getIPv4post());
		System.out.println("IPv6 POST counter: " + counter.getIPv6post());
		
		request.getServletContext().setAttribute("counter", counter);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST REQUEST");
		
		// logika
		Counter counter = (Counter) request.getServletContext().getAttribute("counter");
		if (counter == null) {
			counter = new Counter();
		}
		
		if (request.getLocalAddr().contains(".")) {
			counter.setIPv4post(counter.getIPv4post()+1);
		}
		else if (request.getLocalAddr().contains(":")) {
			counter.setIPv6post(counter.getIPv6post()+1);
		}
		System.out.println("IPv4 GET counter: " + counter.getIPv4get());
		System.out.println("IPv6 GET counter: " + counter.getIPv6get());
		System.out.println("IPv4 POST counter: " + counter.getIPv4post());
		System.out.println("IPv6 POST counter: " + counter.getIPv6post());
		
		request.getServletContext().setAttribute("counter", counter);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
