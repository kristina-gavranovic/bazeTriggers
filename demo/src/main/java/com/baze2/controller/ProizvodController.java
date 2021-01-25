package com.baze2.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.baze2.domain.JedinicaMere;
import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;
import com.baze2.domain.Racun;
import com.baze2.domain.VrstaProizvoda;
import com.baze2.service.JedinicaMereService;
import com.baze2.service.PravnoLiceService;
import com.baze2.service.ProizvodService;
import com.baze2.service.RacunService;
import com.baze2.service.VrstaProizvodaService;

@Controller
public class ProizvodController {

	private final ProizvodService proizvodService;
	private final JedinicaMereService jedinicaMereService;
	private final VrstaProizvodaService vrstaProizvodaService;
//	private final RacunService racunService;

	public ProizvodController() {
		this.proizvodService = new ProizvodService();
		vrstaProizvodaService = new VrstaProizvodaService();
		jedinicaMereService = new JedinicaMereService();
//		racunService=new RacunService();

	}

	@GetMapping("/proizvod")
	public String proizvodHome(Model model) {
		Proizvod p1 = new Proizvod();
		Proizvod p2 = new Proizvod();
		ArrayList<VrstaProizvoda> vrsteProizvoda = vrstaProizvodaService.findAll();
		ArrayList<JedinicaMere> jediniceMere = jedinicaMereService.findAll();
		ArrayList<Proizvod> proizvodi = proizvodService.findAll();

		model.addAttribute("vrsteProizvoda", vrsteProizvoda);
		model.addAttribute("jediniceMere", jediniceMere);
		model.addAttribute("proizvodi", proizvodi);
		model.addAttribute("proizvod", p1);
		model.addAttribute("p", p2);
		return "proizvod";
	}
	
//	@GetMapping("/racun")
//	public String racunHome(Model model) {
//		Racun racun=new Racun();
//		model.addAttribute("racun", racun);
//
//		return "racun";
//	}
//
//	@RequestMapping(value = "/saveRacun", method = RequestMethod.POST)
//	public String saveRacun(@ModelAttribute("racun") Racun racun) {
//		System.out.println(racun.toString());
//		racunService.save(racun);
//
//		return "redirect:/racun";
//	}
	
	
	@RequestMapping(value = "/saveProizvod", method = RequestMethod.POST)
	public String save(@ModelAttribute("proizvod") Proizvod proizvod) {
		System.out.println(proizvod.toString());
		proizvodService.save(proizvod);
//		int odgovor = knjigaService.saveKnjiga(knjiga);
//		String uspesno = "nesuspesnoDodavanje";
//		if(odgovor==1) {
//			uspesno = "uspesnoDodavanje";
//		}
//		return "redirect:/searchKnjiga?uspesno=" + uspesno;
		return "redirect:/proizvod";
	}

	@RequestMapping("/updateProizvod")
	public String idiNaIzmeniProizvod(@RequestParam int ident, int idjm, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("ident idjm" + ident + "  " + idjm);
	//	System.out.println(nazivJM);
//		String uspesno = "";
//		if (nazivJM == null) {
//			uspesno = proizvodService.updateIdJM(ident, idjm);
//			redirectAttributes.addFlashAttribute("message", uspesno);
//		} else {
//			uspesno = proizvodService.updateNazivJm(ident, idjm, nazivJM);
//			redirectAttributes.addFlashAttribute("message", uspesno);
//		}
	 Proizvod p= proizvodService.get(ident,idjm);
	 System.out.println(p.toString());
//		
		model.addAttribute("p", p);
		return "izmeniProizvod";
		//return "redirect:/proizvod";
	}
	
	@RequestMapping(value="/izmeniProizvod", method = RequestMethod.POST)
	public String updateProizvod(@ModelAttribute Proizvod p, Model model, RedirectAttributes redirectAttributes) {
	//	System.out.println(ident+"  "+naziv);
		String uspesno="";
		uspesno = proizvodService.updateNazivJm(p.getVrstaProizvoda().getIdent(), p.getJedinicaMere().getId(), p.getNazivJM());
		
			//uspesno = proizvodService.updateIdJM(p.getVrstaProizvoda().getIdent(), p.getJedinicaMere().getId());
			redirectAttributes.addFlashAttribute("message", uspesno);
		
		return "redirect:proizvod";
	}
	
		@RequestMapping("/updateNazivJM")
		public String idiNaIzmeniJM(@RequestParam int id, String naziv, Model model) {
			System.out.println(id+"  "+naziv);
			//jedinicaMereService.updateNaziv(id, naziv);
//			ModelAndView mv=new ModelAndView("izmeniJM");
//			mv.addObject("id", id);
//			mv.addObject("naziv", naziv);
			JedinicaMere jm=new JedinicaMere();
			jm.setId(id);
			jm.setNaziv(naziv);
			
			model.addAttribute("jm", jm);
			model.addAttribute("id", id);
			model.addAttribute("naziv", naziv);
			
			return "izmeniJM";
		}

		@RequestMapping(value="/izmeniJM", method = RequestMethod.POST)
		public String updateJM(@ModelAttribute("jm") JedinicaMere jm, Model model) {
			//System.out.println(id+"  "+naziv);
			jedinicaMereService.updateNaziv(jm.getId(), jm.getNaziv());
			
			
			return "redirect:proizvod";
		}
		
		
}
