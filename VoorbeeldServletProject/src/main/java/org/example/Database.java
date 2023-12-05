package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	static Connection c = null;
	
	public Database() {
		super();
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Chinook.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public ArrayList<Artist> readAllArtistFromDatabase(String name) {
        ArrayList<Artist> artists = new ArrayList<>();
        try {
        	Statement stmt = null;

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Artist where name like '%"+ name +"%'");

            while (rs.next()) {
                artists.add(new Artist(rs.getString("Name"), rs.getInt("ArtistId")));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Alle artists opgehaald");
        return artists;
    }

    
    public static int getMaxIdFromDatabase() {
        int maxId = -1;
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ArtistId) FROM Artist;");

            maxId = rs.getInt("MAX(ArtistId)");

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("New artist id provided");
        return maxId;
    }

    

}


