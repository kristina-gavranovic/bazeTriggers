package com.baze2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.JedinicaMere;


public class JedinicaMereDAO {
	
	public ArrayList<JedinicaMere> findAll(){
		
		ArrayList<JedinicaMere> list=new ArrayList<JedinicaMere>();
        try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query="select idjm, nazivjm  from jedinicamere";
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
            	JedinicaMere pl=new JedinicaMere();
				pl.setId(resultSet.getInt("idjm"));
				pl.setNaziv(resultSet.getNString("nazivjm"));
			
				list.add(pl);
				
			}
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}

	public void updateNaziv(int id, String naziv) {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			 String query = "update jedinicamere set nazivjm='"+naziv+"' where idjm="+id;;
			 Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	    
	     
	     

		
	}

}
