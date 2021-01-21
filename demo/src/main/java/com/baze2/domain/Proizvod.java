package com.baze2.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Proizvod {

	VrstaProizvoda vrstaProizvoda;
	JedinicaMere jedinicaMere;
	double stanjeZalihe;
	double cenaKupovna;
	String nazivJM;
	ArrayList<Cena> cene;
	
	public Proizvod(VrstaProizvoda vrstaProizvoda, JedinicaMere jedinicaMere, double stanjeZalihe, double cenaKupovna,String nazivJM) {
		super();
		this.vrstaProizvoda = vrstaProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.stanjeZalihe = stanjeZalihe;
		this.cenaKupovna = cenaKupovna;
		this.nazivJM=nazivJM;
		this.cene = new ArrayList<Cena>();
	}
	
	public Proizvod() {
		vrstaProizvoda=new VrstaProizvoda();
		jedinicaMere=new JedinicaMere();
		this.cene = new ArrayList<Cena>();
	}
	
	
	
}
