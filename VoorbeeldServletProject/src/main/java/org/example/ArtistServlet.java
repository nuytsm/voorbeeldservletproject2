package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArtistServlet extends HttpServlet {
	
	Database db = new Database();
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name = req.getParameter("name"); //"met"
        ArrayList<Artist> artist = db.readAllArtistFromDatabase(name);
        for (Artist a : artist) {
            resp.getWriter().println(a.getName());
        }
    }
}
