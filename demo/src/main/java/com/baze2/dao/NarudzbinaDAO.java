package com.baze2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.Narudzbina;
import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;
import com.baze2.udt.ImePrezime;

public class NarudzbinaDAO {

	
//	 public Proizvod save(Proizvod proizvod) throws SQLException {
//	
//			try {
//				  Connection connection = ConnectionFactory.getInstance().getConnection();
//			     String query = "INSERT INTO proizvod (ident,idjm,stanjeZaliha,cenaKupovna) VALUES(?,?,?,?)";
//
//			        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			        preparedStatement.setInt(1, proizvod.getVrstaProizvoda().getIdent());
//			        preparedStatement.setInt(2, proizvod.getJedinicaMere().getId());
//			        preparedStatement.setDouble(3, proizvod.getStanjeZalihe());
//			        preparedStatement.setDouble(4, proizvod.getCenaKupovna());
//
//			        preparedStatement.executeUpdate();
//
//			        connection.commit(); // TODO: commit uraditi u servis metodi
//			        preparedStatement.close();
//			    
//			        
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				
//				e.printStackTrace();
//				System.err.println(e.getMessage());
//			}
//		    return proizvod;
//	    }
	 
	 public ArrayList<Narudzbina> findAll(){
			
			ArrayList<Narudzbina> list=new ArrayList<Narudzbina>();
	        try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select idNarudzbina, datum, dostava, rokIsporuke, napomena, PIBDobavljac, PIBPrevoznik, idRadnik, imePrezime from narudzbina";
				Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            
	            while (rs.next()) {
	            	Narudzbina n=new Narudzbina();
	            	
	            	n.setId(rs.getInt("idNarudzbina"));
	            	n.setDatum((java.util.Date)rs.getDate("datum"));
	            	n.setDostava(rs.getNString("dostava"));
	            	n.setRokIsporuke((java.util.Date)rs.getDate("rokIsporuke"));
	            	n.setNapomena(rs.getNString("napomena"));
	            	n.getDobavljac().setPib(rs.getInt("PIBDobavljac"));
	            	n.getPrevoznik().setPib(rs.getInt("PIBPrevoznik"));
	            	n.setImePrezime((ImePrezime)rs.getObject("imePrezime"));
	            	n.getRadnik().setId(rs.getInt("idradnik"));
	            	
	            	
				
					list.add(n);
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return list;
		}

	public Narudzbina get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateNarudzbina(Narudzbina n) {
		try {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		 String query = "update narudzbina set idradnik="+n.getRadnik().getId()+" where idnarudzbina="+n.getId();
		 Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
		 connection.commit();
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	

	}
	}
//	public String updateIdJM(int ident, int idjm) {
//		try {
//			Connection connection = ConnectionFactory.getInstance().getConnection();
//			 String query = "update proizvod set idjm="+idjm+" where idjm="+idjm+" and ident= "+ident;
//			 Statement statement = connection.createStatement();
//	            ResultSet resultSet = statement.executeQuery(query);
//			 
//			 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			return e.getMessage();
//		}
//	    
//	     
//	     
//		return "uspelo";
//	}
//
//	public String updateNazivJm(int ident, int idjm, String nazivJM) {
//		try {
//			Connection connection = ConnectionFactory.getInstance().getConnection();
//			 String query = "update proizvod set nazivjm='"+nazivJM+"' where idjm="+idjm+" and ident= "+ident;
//			 Statement statement = connection.createStatement();
//	            ResultSet resultSet = statement.executeQuery(query);
//			 
//			 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			return e.getMessage();
//		}
//	    
//	     
//	     
//		return "uspelo";
//	}

	public String updateNarudzbinaIme(Narudzbina n) {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			 String query = "update narudzbina SET imeprezime = new ImePrezime('"+n.getImePrezime().getIme()+"','"+n.getImePrezime().getPrezime()+"') where idnarudzbina="+n.getId();
			 Statement statement = connection.createStatement();
			 System.out.println(query);
	            ResultSet resultSet = statement.executeQuery(query);
			 connection.commit();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		return e.getMessage();

		}
		return "uspelo";
		
	}
	
}
