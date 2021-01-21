package com.baze2.service;

import java.util.ArrayList;

import com.baze2.dao.VrstaProizvodaDAO;
import com.baze2.domain.VrstaProizvoda;


public class VrstaProizvodaService {
private final VrstaProizvodaDAO vrstaProizvodaDAO;
	
	public VrstaProizvodaService() {
		vrstaProizvodaDAO=new VrstaProizvodaDAO();
	}
	
	public ArrayList<VrstaProizvoda> findAll(){
		return vrstaProizvodaDAO.findAll();
		
		
	}
}
