package xyz.casualcookie.ponyslayer.repository;

import java.time.Instant;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractRepository<T> implements Repository<T, Long> {
	@Autowired SessionFactory sessionFactory;
	Class<T> domainClass;
	
	public AbstractRepository(Class<T> domainClass){
		this.domainClass=domainClass;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Save adventure
	 * @param arg0
	 * @return adventure that was saved
	 */
	protected abstract <S extends T> S save(S arg0);
	
	@Transactional
	public boolean deleteById(Long id){
		Object toDelete = getSession().load(domainClass,id);
		if(toDelete!=null){
			getSession().delete(toDelete);
			return true;
		}
		return false;
	};

	/**
	 * Returns all adventures.
	 * @param date date of the day the adventures should be returned.
	 * @return 
	 */
	protected abstract List<T> findAll(Instant date);

}
