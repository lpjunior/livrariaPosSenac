package br.senac.rj.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DaoFactory {
	
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String HOST = "http://localhost:3311/";
	private final static String BANCO = "livrariajava";
	private final static String PARAM = "?createDatabaseIfNotExist=true";
	private final static String USER = "root";
	private final static String PASS = "root";
	
	protected static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(HOST+BANCO+PARAM, USER, PASS);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println(e.getMessage());
		}
		return null;
	}
}
