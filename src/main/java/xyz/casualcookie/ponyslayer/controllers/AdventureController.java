package xyz.casualcookie.ponyslayer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.casualcookie.ponyslayer.domain.Adventure;
import xyz.casualcookie.ponyslayer.services.AdventureService;
import xyz.casualcookie.ponyslayer.util.JsonErrors;
import xyz.casualcookie.ponyslayer.util.Partition;

@RestController
@RequestMapping("/adventure")
public class AdventureController {
	@Autowired AdventureService adventureService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<JsonErrors> createAdventure(@Validated @RequestBody Adventure adventure, Errors errors){
		if(!errors.hasErrors()){
			adventureService.addAdventure(adventure);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonErrors(errors));
		}
	}
	
	//200 - ok  202 -accepted //204 - no contact
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public HttpStatus deleteAdventure(@PathVariable Long id){
		System.out.println(id);
		if(adventureService.deleteAdventure(id)){
			return HttpStatus.OK;
		};
		return HttpStatus.NOT_FOUND;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<List<Adventure>> getAdventures(){
		Partition<Adventure> partition = new Partition<>(adventureService.getAdventures(),3);
		return partition.getAll();
	}

}
