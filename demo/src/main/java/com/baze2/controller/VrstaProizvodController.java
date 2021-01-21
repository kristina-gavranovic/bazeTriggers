package com.baze2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baze2.domain.PravnoLice;
import com.baze2.domain.Racun;
import com.baze2.domain.VrstaProizvoda;

@Controller
public class VrstaProizvodController {

	
	
	
	@GetMapping("/vrstaProizvod")
	public String home(Model model) {
		VrstaProizvoda vp=new VrstaProizvoda();
		model.addAttribute("vp", vp);

		return "vrstaProizvod";
	}
}
