package com.baze2.service;

import java.util.ArrayList;

import com.baze2.dao.JedinicaMereDAO;
import com.baze2.dao.RadnikDAO;
import com.baze2.domain.JedinicaMere;
import com.baze2.domain.Radnik;



public class RadnikService {
	private final RadnikDAO radnikDAO;
	
	public RadnikService() {
		radnikDAO=new RadnikDAO();
	}
	
	public ArrayList<Radnik> findAll(){
		return radnikDAO.findAll();
		
		
	}

	public Radnik get(int id) {
		// TODO Auto-generated method stub
		return radnikDAO.get(id);}



	public void izmeniRadnik(Radnik r) {
		// TODO Auto-generated method stub
		 radnikDAO.updateRadnik(r);
	}

//	public void updateNaziv(int id, String naziv) {
//		radnikDAO.updateNaziv(id, naziv);
//		
//	}
}
