package xyz.casualcookie.ponyslayer.services;

import java.util.List;

import javax.transaction.Transactional;

import xyz.casualcookie.ponyslayer.domain.Adventure;

public interface AdventureService {
	
	void addAdventure(Adventure adventure);
	boolean deleteAdventure(Long id);
	
	List<Adventure> getAdventures();
	
	

}
