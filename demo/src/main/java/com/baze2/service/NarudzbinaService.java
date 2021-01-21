package com.baze2.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.baze2.dao.NarudzbinaDAO;
import com.baze2.dao.PravnoLiceDAO;
import com.baze2.dao.ProizvodDao;
import com.baze2.domain.Narudzbina;
import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;

public class NarudzbinaService {

	private final NarudzbinaDAO narudzbinaDAO;

	public NarudzbinaService() {
		narudzbinaDAO = new NarudzbinaDAO();
	}

//	public Proizvod save(Proizvod proizvod){
//		try {
//			return proizvodDao.save(proizvod);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		return null;
//		
//	}

	public ArrayList<Narudzbina> findAll() {
		return narudzbinaDAO.findAll();

	}

	public Narudzbina get(int id) {
		ArrayList<Narudzbina> all = narudzbinaDAO.findAll();

		for (Narudzbina narudzbina : all) {
			if (narudzbina.getId() == id)
				return narudzbina;
		}

		return null;
	}

	public void updateIdRanik(Narudzbina n) {
		 narudzbinaDAO.updateNarudzbina(n);
		
	}
	
	public String updateImeRanik(Narudzbina n) {
		return  narudzbinaDAO.updateNarudzbinaIme(n);
		
	}

//	public Proizvod get(int ident, int idjm) {
//		ArrayList<Proizvod>list=proizvodDao.findAll();
//		
//	
//		for (Proizvod p : list) {
//			System.out.println(p);
//			if(p.getJedinicaMere().getId()==idjm && p.getVrstaProizvoda().getIdent()==ident) {
//				System.out.println(p.toString());
//				return p;
//				
//			}
//			
//		}
//		return null;
//	}
//
//	public String updateIdJM(int ident, int idjm) {
//		return proizvodDao.updateIdJM(ident, idjm);
//		
//	}
//
//	public String updateNazivJm(int ident, int idjm, String nazivJM) {
//		return proizvodDao.updateNazivJm(ident, idjm, nazivJM);
//		
//	}
//	

}
