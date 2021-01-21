package com.baze2.domain;

import java.util.ArrayList;
import java.util.Date;

import com.baze2.udt.ImePrezime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Narudzbina {
	int id;
	Date datum;
	String dostava;
	Date rokIsporuke;
	String napomena;
	PravnoLice dobavljac;
	PravnoLice prevoznik;
	Radnik radnik;
	ImePrezime imePrezime;
	ArrayList<StavkaNarudzbina> stavke;
	
	public Narudzbina() {
		stavke=new ArrayList<StavkaNarudzbina>();
		dobavljac=new PravnoLice();
		prevoznik=new PravnoLice();
		radnik=new Radnik();
	}

	public Narudzbina(int id, Date datum, String dostava, Date rokIsporuke, String napomena, PravnoLice dobavljac,
			PravnoLice prevoznik, Radnik radnik,ImePrezime imePrezime) {
		super();
		this.id = id;
		this.datum = datum;
		this.dostava = dostava;
		this.rokIsporuke = rokIsporuke;
		this.napomena = napomena;
		this.dobavljac = dobavljac;
		this.prevoznik = prevoznik;
		this.radnik = radnik;
		this.imePrezime=imePrezime;
		stavke=new ArrayList<StavkaNarudzbina>();
	}
	
}
