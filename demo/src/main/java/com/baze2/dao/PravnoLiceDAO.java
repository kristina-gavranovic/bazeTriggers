package com.baze2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.PravnoLice;

public class PravnoLiceDAO {
	
	public ArrayList<PravnoLice> findAll(){
		
		ArrayList<PravnoLice> list=new ArrayList<PravnoLice>();
        try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query="select pib, naziv, adresa from pravnolice";
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
				PravnoLice pl=new PravnoLice();
				pl.setPib(resultSet.getInt("pib"));
				pl.setNaziv(resultSet.getNString("naziv"));
				pl.setAdresa(resultSet.getString("adresa"));
				list.add(pl);
				
			}
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}

}
