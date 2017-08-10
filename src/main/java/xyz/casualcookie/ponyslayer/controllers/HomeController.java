package xyz.casualcookie.ponyslayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.casualcookie.ponyslayer.configuration.Pages;
import xyz.casualcookie.ponyslayer.domain.Adventure;
import xyz.casualcookie.ponyslayer.services.AdventureService;
import xyz.casualcookie.ponyslayer.util.Partition;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired AdventureService adventureService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		Partition<Adventure> partition = new Partition<>(adventureService.getAdventures(),3);
		model.addAttribute("adventureList",partition.getAll());
		
		//load modal to the create form.
		model.addAttribute("emptyAdventure", new Adventure());
		return Pages.INDEX.getIndexName();
	}
}
