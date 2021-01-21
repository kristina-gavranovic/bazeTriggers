package com.baze2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.baze2.domain.Proizvod;
import com.baze2.domain.Racun;

public class RacunDAO {
	
	 public Racun save(Racun racun) throws SQLException {
	
			try {
				  Connection connection = ConnectionFactory.getInstance().getConnection();
				  //idRačun, datumRačuna,dostava,odgovornaOsoba,datumValute, datumPrometaDobara, mestoFakture, datumFakture, idRadnik, PIBKupac, PIBPrimalac)
				  
		//	     String query = "insert into racunsve values("+racun.getId()+", '"+ (java.sql.Date) racun.getDatum()+"','"+racun.getDostava()+"','"+racun.getOdgovornaOsoba()+"','"+(java.sql.Date)racun.getDatumValute()+"', '"+(java.sql.Date)racun.getDatumValute()+"', '"+racun.getMestoFakture()+"', '"+(java.sql.Date)racun.getDatumValute()+"', "+racun.getRadnik().getId()+", "+racun.getKupac().getPib()+", "+racun.getPrimalac().getPib()+")";
				     String query = "insert into racunsve values("+lastRacunID()+", sysdate,'"+racun.getDostava()+"','"+racun.getOdgovornaOsoba()+"',sysdate, sysdate, '"+racun.getMestoFakture()+"', sysdate, 1, "+racun.getKupac().getPib()+", "+racun.getPrimalac().getPib()+")";
				     System.out.println(query);
				 	Statement statement = connection.createStatement();
		            ResultSet rs = statement.executeQuery(query);
		            

			        connection.commit(); // TODO: commit uraditi u servis metodi
			    
			    
			        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		    return racun;
	    }
	 
	 public int lastRacunID() throws SQLException{
		 	int lastId=-1;
		 
	        try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select max(idracun) from racun";
				Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
	            
	            while (resultSet.next()) {
	            	lastId=resultSet.getInt("max(idracun)");
	            	System.out.println(lastId);
	
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return lastId+1;
	 }

}
