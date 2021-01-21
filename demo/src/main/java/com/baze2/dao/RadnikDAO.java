package com.baze2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.JedinicaMere;
import com.baze2.domain.Radnik;
import com.baze2.udt.ImePrezime;

//import oracle.sql.ORAData;


public class RadnikDAO {
	
	public ArrayList<Radnik> findAll(){
		
		ArrayList<Radnik> list=new ArrayList<Radnik>();
        try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query="select idradnik, imePrezime, jmbg  from radnik";
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
            	Radnik r=new Radnik();
				r.setId(resultSet.getInt("idradnik"));
				r.setImePrezime((ImePrezime)resultSet.getObject("imePrezime"));
				r.setJmbg(resultSet.getNString("jmbg"));
				list.add(r);
				
			}
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}

	public void updateRadnik(Radnik r) {
		try {
			System.out.println(r.toString());
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement statement= connection.prepareStatement("UPDATE radnik SET imeprezime = new ImePrezime('"+r.getImePrezime().getIme()+"','"+r.getImePrezime().getPrezime()+"') where idradnik="+r.getId());
			System.out.println("UPDATE radnik SET imeprezime = new ImePrezime('"+r.getImePrezime().getIme()+"','"+r.getImePrezime().getPrezime()+"') where idradnik="+r.getId());
			//statement.setObject(0,  );
			
			//String query="update radnik set imeprezime=('"+r.getImePrezime().getIme()+"','"+r.getImePrezime().getPrezime()+"') where idradnik="+r.getId();
			// String query = "update radnik set imeprezime.getIme()='"+r.getImePrezime().getIme()+"', imeprezime.getPrezime()='"+r.getImePrezime().getPrezime()+"' where idradnik="+r.getId();
			// Statement statement = connection.createStatement();
	            int upselo=statement.executeUpdate();
	            System.out.println(upselo);
	            connection.commit();
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}}

	public Radnik get(int id) {
		Radnik r=new Radnik();
		 try {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				String query="select *  from radnik where idradnik="+id;
				Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
	            
	            while (resultSet.next()) {
	            	r.setId(resultSet.getInt("idradnik"));
	            	r.setImePrezime((ImePrezime)resultSet.getObject("imeprezime"));
	            	r.setJmbg(resultSet.getNString("jmbg"));
					
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		return r;
	}
	    
	     
	     

		
//	}

}
