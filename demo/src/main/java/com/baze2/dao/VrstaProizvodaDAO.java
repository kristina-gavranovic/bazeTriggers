package com.baze2.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.VrstaProizvoda;
import com.baze2.udt.Pdv;

public class VrstaProizvodaDAO {
	public ArrayList<VrstaProizvoda> findAll() {

		ArrayList<VrstaProizvoda> list = new ArrayList<VrstaProizvoda>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "select ident, nazivvrstaproizvoda, stopapdv  from VrstaProizvoda";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				VrstaProizvoda pl = new VrstaProizvoda();
				pl.setIdent(resultSet.getInt("ident"));
				pl.setNaziv(resultSet.getString("nazivvrstaproizvoda"));
				pl.setStopaPdv((Pdv)resultSet.getObject("stopapdv"));

				list.add(pl);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String save(VrstaProizvoda vrstaProizvoda) {
		try {
			  Connection connection = ConnectionFactory.getInstance().getConnection();
			  System.out.println(vrstaProizvoda.getStopaPdv().getVrednost());
		     String query = "INSERT INTO vrstaproizvoda (nazivvrstaproizvoda,stopapdv) VALUES('"+vrstaProizvoda.getNaziv()+"',new pdv("+new BigDecimal(vrstaProizvoda.getStopaPdv().getVrednost())+"))";
		     System.out.println(query);
		     Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
			 connection.commit();
		    
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.err.println(e.getMessage());
			return e.getMessage();
		}
	    return "Uspesno ste uneli novu vrstu proizvoda!";
  }
	
}
