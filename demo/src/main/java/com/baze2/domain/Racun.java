package com.baze2.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Racun {
	int id;
	Date datum;
	String dostava;
	String odgovornaOsoba;
	Date datumValute;
	Date datumPrometaDobara;
	Date datumFakture;
	String mestoFakture;
	Radnik radnik;
	PravnoLice kupac;
	PravnoLice primalac;

	public Racun() {
		kupac=new PravnoLice();
		primalac=new PravnoLice();
		
		
	
	}

}
