package com.baze2.domain;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtkupniList {
	int id;
	Date datum;
	String mesto;
	String napomena;
	PravnoLice dobavljac;
	Radnik radnik;
	Narudzbina narudzbina;
	
	ArrayList<StavkaOtkupniList> stavke;
	public OtkupniList() {
		this.stavke=new ArrayList<StavkaOtkupniList>();
	}
	public OtkupniList(int id, Date datum, String mesto, String napomena, PravnoLice dobavljac, Radnik radnik,
			Narudzbina narudzbina) {
		super();
		this.id = id;
		this.datum = datum;
		this.mesto = mesto;
		this.napomena = napomena;
		this.dobavljac = dobavljac;
		this.radnik = radnik;
		this.narudzbina = narudzbina;
		this.stavke=new ArrayList<StavkaOtkupniList>();
	}
	
	
}
