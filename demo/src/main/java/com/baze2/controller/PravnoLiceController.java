package com.baze2.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.baze2.domain.JedinicaMere;
import com.baze2.domain.PravnoLice;
import com.baze2.service.PravnoLiceService;

@Controller
public class PravnoLiceController {
	private final PravnoLiceService pravnoLiceService;

	public PravnoLiceController() {
		pravnoLiceService = new PravnoLiceService();
	}

	@GetMapping("/pravnaLica")
	public String proizvodHome(Model model) {
		ArrayList<PravnoLice> list = pravnoLiceService.findAll();
		model.addAttribute("list", list);
		return "pravnaLica";
	}
	
	@GetMapping({"/all","/"})
	public String searchAutor() {
	
		
		return "home";
	}

}
