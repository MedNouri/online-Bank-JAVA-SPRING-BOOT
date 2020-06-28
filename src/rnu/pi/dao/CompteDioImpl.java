package rnu.pi.dao;

 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rnu.pi.entity.Compte;
 
@Repository
public class CompteDioImpl implements CompteDAO {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Compte f) {
		// TODO Auto-generated method stub
 
		sessionFactory.getCurrentSession().save(f);

	}

	@Override
	public void delete(Compte f) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(f);

	}

 
 
	
	

}