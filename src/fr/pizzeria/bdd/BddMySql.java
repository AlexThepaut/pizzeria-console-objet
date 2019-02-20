package fr.pizzeria.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BddMySql {
	
	public BddMySql(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Statement initConnection(){
		
		Properties prop = chargerProp();
		
		String urlBdd = prop.getProperty("database");
		String userBdd = prop.getProperty("dbuser");
		String mdpBdd = prop.getProperty("dbpassword");
		try {
			Connection connection = DriverManager.getConnection(urlBdd, userBdd, mdpBdd);
			Statement statement = connection.createStatement();
			return statement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void modificationBdd(Statement connexion, String requete){
		try {
			connexion.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet recupererBdd(Statement connexion, String requete){
		try {
			ResultSet resultat = connexion.executeQuery(requete);
			return resultat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void fermeture(Statement connexion){
		try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Properties chargerProp(){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("bdd.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return prop;
	}
}
