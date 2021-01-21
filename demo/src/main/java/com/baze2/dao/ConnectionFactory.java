package com.baze2.dao;

import java.sql.Connection;
import com.baze2.udt.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	
	  private Connection connection;
	    private static ConnectionFactory instance;

	    private ConnectionFactory() throws SQLException {
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  
	        	System.out.println("************************");

	            connection =DriverManager.getConnection(  
	            		"jdbc:oracle:thin:@localhost:1521/orcl","student","student");  
	            System.out.println("Povezao sa sa bazom");
	           connection.setAutoCommit(false); 
	           
	           java.util.Map map = connection.getTypeMap();
	           map.put("STUDENT.IMEPREZIME", ImePrezime.class);
	           connection.setTypeMap(map);
	           
	           java.util.Map map2 = connection.getTypeMap();
	           map.put("STUDENT.PDV", Pdv.class);
	           connection.setTypeMap(map2);
	           
	           
	        } catch (SQLException ex) {
	            throw new SQLException(ex.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    public Connection getConnection() {
	        return connection;
	    }

	    public static ConnectionFactory getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new ConnectionFactory();
	        }
	        return instance;
	    }
}


