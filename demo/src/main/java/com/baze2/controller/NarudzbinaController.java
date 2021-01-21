package com.baze2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baze2.domain.JedinicaMere;
import com.baze2.domain.Narudzbina;
import com.baze2.domain.Proizvod;
import com.baze2.domain.Radnik;
import com.baze2.domain.VrstaProizvoda;
import com.baze2.service.NarudzbinaService;
import com.baze2.service.RadnikService;

@Controller
public class NarudzbinaController {
	private final RadnikService radnikService;
	private final NarudzbinaService narudzbinaService;
	
	public NarudzbinaController() {
		radnikService=new RadnikService();
		narudzbinaService=new NarudzbinaService();
	}

	
	@GetMapping("/narudzbina")
	public String proizvodHome(Model model) {
	
		ArrayList<Radnik> radnici = radnikService.findAll();
		ArrayList<Narudzbina> narudzbine=narudzbinaService.findAll();
		Narudzbina newNar=new Narudzbina();
		
		model.addAttribute("radnici", radnici);
		model.addAttribute("newNar", newNar);
		model.addAttribute("narudzbine", narudzbine);
		return "narudzbina";
	}
	
	
	@RequestMapping("/updateRadnik")
	public String idiNaIzmeniRadnik(@RequestParam int id, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("id radnik" + id );

	 Radnik r= radnikService.get(id);
	 System.out.println(r.toString());
//		
		model.addAttribute("r", r);
		return "izmeniRadnik";
		//return "redirect:/proizvod";
	}
	
	@RequestMapping("/updateNar")
	public String idiNaIzmeniNar(@RequestParam int id, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("id nar" + id );
	
	Narudzbina nar=narudzbinaService.get(id);
	
	 System.out.println(nar.toString());
	
		model.addAttribute("nar", nar);
		return "izmeniNar";
		
	}
	
	@RequestMapping(value="/izmeniRadnik", method = RequestMethod.POST)
	public String updateProizvod(@ModelAttribute Radnik r, Model model, RedirectAttributes redirectAttributes) {
		String uspesno="";
		radnikService.izmeniRadnik(r);
		
			redirectAttributes.addFlashAttribute("message", uspesno);
		
		return "redirect:narudzbina";
	}
	
	@RequestMapping(value="/izmeniNar", method = RequestMethod.POST)
	public String updateNar(@ModelAttribute Narudzbina n, Model model, RedirectAttributes redirectAttributes) {
		String uspesno="";
		narudzbinaService.updateIdRanik(n);
		
			redirectAttributes.addFlashAttribute("message", uspesno);
		
		return "redirect:narudzbina";
	}
	
	@RequestMapping(value="/izmeniNarIme", method = RequestMethod.POST)
	public String updateNarIme(@ModelAttribute Narudzbina n, Model model, RedirectAttributes redirectAttributes) {
		String uspesno="";
		uspesno=narudzbinaService.updateImeRanik(n);
		
			redirectAttributes.addFlashAttribute("message", uspesno);
		
		return "redirect:narudzbina";
	}
	
	@RequestMapping(value="/izmeniNarIdRadnik", method = RequestMethod.POST)
	public void izmeniNarIdRadnik(@ModelAttribute("n") Narudzbina n,  Model model) {
		//narudzbinaService.updateIdRadnik();
		System.out.println(n.toString());
		
		
	}
}
