package com.baze2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;

public class ProizvodDao {

	
	 public Proizvod save(Proizvod proizvod) throws SQLException {
	
			try {
				  Connection connection = ConnectionFactory.getInstance().getConnection();
			     String query = "INSERT INTO proizvod (ident,idjm,stanjeZaliha,cenaKupovna) VALUES(?,?,?,?)";

			        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			        preparedStatement.setInt(1, proizvod.getVrstaProizvoda().getIdent());
			        preparedStatement.setInt(2, proizvod.getJedinicaMere().getId());
			        preparedStatement.setDouble(3, proizvod.getStanjeZalihe());
			        preparedStatement.setDouble(4, proizvod.getCenaKupovna());

			        preparedStatement.executeUpdate();

			        connection.commit(); // TODO: commit uraditi u servis metodi
			        preparedStatement.close();
			    
			        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		    return proizvod;
	    }
	 
	 public ArrayList<Proizvod> findAll(){
			
			ArrayList<Proizvod> list=new ArrayList<Proizvod>();
	        try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select ident, idjm, stanjezaliha, nazivjm, cenakupovna from proizvod";
				Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
	            
	            while (resultSet.next()) {
	            	Proizvod pl=new Proizvod();
					pl.getVrstaProizvoda().setIdent((resultSet.getInt("ident")));
					pl.getJedinicaMere().setId((resultSet.getInt("idjm")));
					pl.setStanjeZalihe(resultSet.getDouble("stanjezaliha"));
					pl.setCenaKupovna(resultSet.getDouble("cenakupovna"));
					pl.setNazivJM(resultSet.getNString("nazivjm"));
					list.add(pl);
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return list;
		}

	public String updateIdJM(int ident, int idjm) {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			 String query = "update proizvod set idjm="+idjm+" where idjm="+idjm+" and ident= "+ident;
			 Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	    
	     
	     
		return "uspelo";
	}

	public String updateNazivJm(int ident, int idjm, String nazivJM) {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			 String query = "update proizvod set nazivjm='"+nazivJM+"' where idjm="+idjm+" and ident= "+ident;
			 Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	    
	     
	     
		return "uspelo";
	}
	
}
