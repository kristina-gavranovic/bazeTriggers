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
import com.baze2.domain.StavkaNarudzbina;
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
				String query="select idNarudzbina, datum, dostava, rokIsporuke, napomena, PIBDobavljac, PIBPrevoznik, idRadnik, imePrezime, ukupnozaplacanje from narudzbina";
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
	            	n.setUkupnoZaPlacanje(rs.getDouble("ukupnozaplacanje"));
	            	
	            	
				
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

	public String updateUkupnoZaPlacanje(Narudzbina n) {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			 String query = "update narudzbina SET ukupnozaplacanje ="+n.getUkupnoZaPlacanje()+" where idnarudzbina="+n.getId();
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

	public Narudzbina getNarSaStavkama(Narudzbina nar) {
		 try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select * from stavkanarudzbina where idnarudzbina="+nar.getId();
				Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            
	            while (rs.next()) {
	            	StavkaNarudzbina sn=new StavkaNarudzbina();
	            	
	            	sn.setKolicina(rs.getInt("kolicina"));
	            	sn.setId(rs.getInt("idstavkanarudzbina"));
	            	sn.getProizvod().getVrstaProizvoda().setIdent(rs.getInt("ident"));
	            	sn.getProizvod().getJedinicaMere().setId(rs.getInt("idjm"));
	            	sn.getProizvod().getVrstaProizvoda().setNaziv(getNazivProizvoda(sn.getProizvod().getVrstaProizvoda().getIdent()));
	         
				
					nar.getStavke().add(sn);
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return nar;
		}
	
	
	public String getNazivProizvoda(int ident) {
		String naziv="";
		 try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select nazivvrstaproizvoda from vrstaproizvoda where ident="+ident;
				Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            
	            while (rs.next()) {
	            	
	            naziv=rs.getNString("nazivvrstaproizvoda");
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return naziv;
		
	}

	public StavkaNarudzbina saveStavka(StavkaNarudzbina stavka) {

		try {
			  Connection connection = ConnectionFactory.getInstance().getConnection();
		     String query = "INSERT INTO stavkaNarudzbina (idnarudzbina,kolicina,ident,idjm) VALUES(?,?,?,?)";

		        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		        preparedStatement.setInt(1, stavka.getIdNar());
		       // preparedStatement.setInt(2, Statement.RETURN_GENERATED_KEYS+1);
		        preparedStatement.setInt(2,stavka.getKolicina());
		        preparedStatement.setInt(3, stavka.getProizvod().getVrstaProizvoda().getIdent());
		        preparedStatement.setInt(4, getIDJM(getIDJM(stavka.getProizvod().getVrstaProizvoda().getIdent())));

		        preparedStatement.executeUpdate();

		        connection.commit(); 
		        preparedStatement.close();
		    
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	    return stavka;
	}
	
	public int getIDJM(int vrstaProizvodaID) {
		int idjm=-1;
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query="select idjm from proizvod where ident="+vrstaProizvodaID;
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	 idjm=rs.getInt(1);
            	
            
			}
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return idjm;
	}

	public void deleteStavka(int id) {
		Connection connection;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			String query="delete from stavkanarudzbina where idstavkanarudzbina="+id;
			Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        
	        connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
        
		
	}
		
		
	
	
}
