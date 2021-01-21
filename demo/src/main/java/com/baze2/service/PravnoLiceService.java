package com.baze2.service;

import java.util.ArrayList;

import com.baze2.dao.PravnoLiceDAO;
import com.baze2.domain.PravnoLice;

public class PravnoLiceService {

	private final PravnoLiceDAO pravnoLiceDAO;
	
	public PravnoLiceService() {
	pravnoLiceDAO=new PravnoLiceDAO();
	}
	
	public ArrayList<PravnoLice> findAll(){
		return pravnoLiceDAO.findAll();
		
		
	}
	
}
