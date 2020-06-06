package com.lprashant.ludo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LudoGameServlet extends HttpServlet {
	Game game;

	public LudoGameServlet() {
		game = new Game(new Dice());

		// Run game in background...
		new Thread(new Runnable() {
			@Override
			public void run() {
				game.start();
			}
		}).start();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String gameState = game.getJsonState();

		PrintWriter out = resp.getWriter();

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(gameState);
		out.flush();

	}

}
