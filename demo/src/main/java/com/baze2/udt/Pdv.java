package com.baze2.udt;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Pdv  implements SQLData {
	
	double vrednost;


	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return "PDV";
	}

	@Override
	public void readSQL(SQLInput arg0, String arg1) throws SQLException {
		vrednost=arg0.readDouble();
		
	}

	@Override
	public void writeSQL(SQLOutput arg0) throws SQLException {
		arg0.writeDouble(vrednost);
		
	}

}
