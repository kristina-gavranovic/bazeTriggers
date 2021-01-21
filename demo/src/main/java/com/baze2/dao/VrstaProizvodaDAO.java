package com.baze2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.baze2.domain.VrstaProizvoda;

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
				//pl.setStopaPdv(resultSet.getString("stopapdv"));

				list.add(pl);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
