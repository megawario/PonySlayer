package xyz.casualcookie.ponyslayer.services;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.casualcookie.ponyslayer.domain.Adventure;
import xyz.casualcookie.ponyslayer.repository.AdventureRepository;

@Service
public class AdventureServiceImpl implements AdventureService{
	
	@Autowired AdventureRepository adventureRepository;

	@Override
	public List<Adventure> getAdventures() {
		List<Adventure> result = adventureRepository.findAll(Instant.now());
		return result==null || result.size()==0 ? Collections.emptyList():result;
	}
	
	@Override
	public boolean deleteAdventure(Long id) {
		return adventureRepository.deleteById(id);
	}
	
	

	@Override
	public void addAdventure(Adventure adventure) {
		// TODO Auto-generated method stub
	}



	

}
