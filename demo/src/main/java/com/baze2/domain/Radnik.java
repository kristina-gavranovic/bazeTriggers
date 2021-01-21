package com.baze2.domain;

import com.baze2.udt.ImePrezime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Radnik {
	int id;
	ImePrezime imePrezime;
	String jmbg;

}
