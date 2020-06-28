package rnu.pi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rnu.pi.entity.CheckBook;
import rnu.pi.entity.DemandeCarte;
import rnu.pi.entity.History;
@Repository
public class DemandeCheckBookDaoImp implements DemandeCheckBookDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(CheckBook checkbook) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(checkbook);

	}

	@Override
	public List<CheckBook> searchByNumCompte(String  numCompte) {
		// TODO Auto-generated method stub
 
				Query query=sessionFactory.getCurrentSession().createQuery("from CheckBook ");
 				List<CheckBook> list=query.list();
				
				return list;
  	}

	@Override
	public List<CheckBook> loadAll() {
		// TODO Auto-generated method stub
		  
		Query query=sessionFactory.getCurrentSession().createQuery("from CheckBook");
		List<CheckBook> list=query.list();
		
		return list;
	}

}
