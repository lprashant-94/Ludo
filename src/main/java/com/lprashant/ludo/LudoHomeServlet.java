package com.lprashant.ludo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LudoHomeServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nextHTML = "/ludo.html";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextHTML);
		dispatcher.forward(req, resp);
	}
}