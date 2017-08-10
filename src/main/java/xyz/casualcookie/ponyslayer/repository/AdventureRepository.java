package xyz.casualcookie.ponyslayer.repository;

import java.time.Instant;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.casualcookie.ponyslayer.domain.Adventure;


@Transactional
@Repository
public class AdventureRepository extends AbstractRepository<Adventure> {
	
	public AdventureRepository(){
		super(Adventure.class);
	}
	
	@Override
	public <S extends Adventure> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Adventure> findAll(Instant date) {
		CriteriaQuery<Adventure> criteria = getSession().getCriteriaBuilder().createQuery(domainClass);
		Root<Adventure> root = criteria.from(domainClass);
		criteria.select(root);
		return getSession().createQuery(criteria).getResultList();
	}
	
}
