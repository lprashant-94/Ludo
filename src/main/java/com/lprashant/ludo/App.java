package com.lprashant.ludo;


import org.eclipse.jetty.server.Server;

public class App {
	
    public static Server createServer(int port)
    {
        Server server = new Server(port);
//        server.setHandler(new LudoGameServlet());
        return server;
    }
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		createServer(8080);
//		Game g = new Game(new Dice());
//		g.start();
	}
}
