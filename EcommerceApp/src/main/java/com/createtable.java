
package com;

import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class createtable {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		SpringApplication.run(createtable.class, args);
		System.out.println("Akshatha here");
      // createTable();
		
		
	// insert();

	}
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
		}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:dtclass.db");
		
		return connection;
	}
	
	public static void createTable() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		System.out.println(connection);
		
		String query = "Create table admin (username varchar(100), password varchar(100))";
		
		Statement statement = connection.createStatement();
		
		boolean result = statement.execute(query);
		
		System.out.println(result);
		
		connection.close();
	}
	
	
	
public static void insert() throws ClassNotFoundException, SQLException {
		
		Connection connection= getConnection();
		
		String sql = "insert into admin values('admin','admin')";
	
		PreparedStatement ps = connection.prepareStatement(sql);
		
		int i = ps.executeUpdate();
		System.out.println(i + " row inserted....");
	
	}
}
