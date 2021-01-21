package com.baze2.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.baze2.dao.PravnoLiceDAO;
import com.baze2.dao.ProizvodDao;
import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;

public class ProizvodService {

	private final ProizvodDao proizvodDao;
	
	public ProizvodService() {
		proizvodDao=new ProizvodDao();
	}
	
	public Proizvod save(Proizvod proizvod){
		try {
			return proizvodDao.save(proizvod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	public ArrayList<Proizvod> findAll(){
		return proizvodDao.findAll();
		
		
	}

	public Proizvod get(int ident, int idjm) {
		ArrayList<Proizvod>list=proizvodDao.findAll();
		
	
		for (Proizvod p : list) {
			System.out.println(p);
			if(p.getJedinicaMere().getId()==idjm && p.getVrstaProizvoda().getIdent()==ident) {
				System.out.println(p.toString());
				return p;
				
			}
			
		}
		return null;
	}

	public String updateIdJM(int ident, int idjm) {
		return proizvodDao.updateIdJM(ident, idjm);
		
	}

	public String updateNazivJm(int ident, int idjm, String nazivJM) {
		return proizvodDao.updateNazivJm(ident, idjm, nazivJM);
		
	}
	
	
}
