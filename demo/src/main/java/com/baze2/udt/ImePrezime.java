package com.baze2.udt;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import oracle.jdbc.OracleData;

@Getter
@Setter
@ToString
public class ImePrezime  implements SQLData{
	
	String ime;
	String prezime;
	
	  public ImePrezime() {
		// TODO Auto-generated constructor stub
	}
	  

	@Override
	public String getSQLTypeName() throws SQLException {
		return "ImePrezime";
	}

	@Override
	public void readSQL(SQLInput arg0, String arg1) throws SQLException {
		ime=arg0.readNString();
		prezime=arg0.readNString();
		
	}

	@Override
	public void writeSQL(SQLOutput arg0) throws SQLException {
		arg0.writeString(ime);
		arg0.writeString(prezime);
		
	}


}
