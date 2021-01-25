package com.baze2.domain;

import com.baze2.udt.Pdv;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VrstaProizvoda {
	int ident;
	String naziv;
	Pdv stopaPdv;
	
	public VrstaProizvoda() {
		stopaPdv=new Pdv();
	}
	
}
