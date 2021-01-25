package com.baze2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baze2.domain.PravnoLice;
import com.baze2.domain.Proizvod;
import com.baze2.domain.Racun;
import com.baze2.domain.VrstaProizvoda;
import com.baze2.service.VrstaProizvodaService;

@Controller
public class VrstaProizvodController {
     private final VrstaProizvodaService vrstaProizvodaService;

	
	public VrstaProizvodController() {
		vrstaProizvodaService= new VrstaProizvodaService();
	}
	
	@GetMapping("/vrstaProizvod")
	public String home(Model model) {
		VrstaProizvoda vp=new VrstaProizvoda();
		model.addAttribute("vp", vp);
		ArrayList<VrstaProizvoda> vrsteP=vrstaProizvodaService.findAll();
		model.addAttribute("vrsteP", vrsteP);

		return "vrstaProizvod";
	}
	
	@RequestMapping(value = "/saveVrstaProizvod", method = RequestMethod.POST)
	public String save(@ModelAttribute("vp") VrstaProizvoda vrstaProizvoda, RedirectAttributes redirectAttributes) {
		System.out.println(vrstaProizvoda.toString());
		String uspelo=vrstaProizvodaService.save(vrstaProizvoda);

		redirectAttributes.addFlashAttribute("message", uspelo);

		return "redirect:/vrstaProizvod";
	}

}
