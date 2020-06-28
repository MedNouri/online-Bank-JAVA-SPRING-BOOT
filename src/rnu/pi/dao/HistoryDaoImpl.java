package rnu.pi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 import rnu.pi.entity.History;
 @Repository
public class HistoryDaoImpl implements HistoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<History> getHistoryById(String id) {
		
 		 Query query = sessionFactory.getCurrentSession().createQuery("from History where compte.numCompte=:num");
 		int i=Integer.parseInt(id);  
 
  
	     query.setParameter("num",  i );
 	 
		List<History> list=query.list();
		
		return list;

 	}
	@Override
	public void insert(History f) {
		// TODO Auto-generated method stub
 		sessionFactory.getCurrentSession().save(f);


	}

}
