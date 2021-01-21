package com.baze2.service;

import java.util.ArrayList;

import com.baze2.dao.JedinicaMereDAO;
import com.baze2.domain.JedinicaMere;



public class JedinicaMereService {
	private final JedinicaMereDAO jedinicaMereDAO;
	
	public JedinicaMereService() {
		jedinicaMereDAO=new JedinicaMereDAO();
	}
	
	public ArrayList<JedinicaMere> findAll(){
		return jedinicaMereDAO.findAll();
		
		
	}

	public void updateNaziv(int id, String naziv) {
		jedinicaMereDAO.updateNaziv(id, naziv);
		
	}
}
