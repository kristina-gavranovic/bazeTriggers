package com.baze2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baze2.domain.PravnoLice;
import com.baze2.domain.Racun;
import com.baze2.service.PravnoLiceService;
import com.baze2.service.RacunService;


@Controller
public class RacunController {
	private final RacunService racunService;
	private final PravnoLiceService pravnoLiceService;
	
	public RacunController() {
		racunService=new RacunService();
		pravnoLiceService=new PravnoLiceService();
	}
	
	@GetMapping("/racun")
	public String racunHome(Model model) {
		Racun racun=new Racun();
		model.addAttribute("racun", racun);
		ArrayList<PravnoLice> pravnaLica=pravnoLiceService.findAll();
		model.addAttribute("pravnaLica", pravnaLica);

		return "racun";
	}

	@RequestMapping(value = "/saveRacun", method = RequestMethod.POST)
	public String saveRacun(@ModelAttribute("racun") Racun racun) {
		System.out.println(racun.toString());
		racunService.save(racun);

		return "redirect:/racun";
	}

}
