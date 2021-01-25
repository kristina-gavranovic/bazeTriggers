package com.baze2.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StavkaNarudzbina {
	int id;
	int idNar;
	int kolicina;
	Proizvod proizvod;
	
	public StavkaNarudzbina() {
		proizvod=new Proizvod();
	}
}
