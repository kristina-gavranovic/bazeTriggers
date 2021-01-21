package com.baze2.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PravnoLice {
	
	private int pib;
	private String naziv;
	private String adresa;
	ArrayList<TipPravnoLice> tipovi;
	
	public PravnoLice() {
		this.tipovi = new ArrayList<TipPravnoLice>();
	}
	public PravnoLice(int pib, String naziv, String adresa) {
		super();
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.tipovi = new ArrayList<TipPravnoLice>();
	}
	
	


}
