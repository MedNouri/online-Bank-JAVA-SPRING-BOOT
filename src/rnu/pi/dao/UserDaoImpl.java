package rnu.pi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rnu.pi.entity.Compte;
import rnu.pi.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;


	public User getUserById(String  id) {
	
		 
				
				 Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.id=:scn");
			     query.setParameter("scn", id);
			     User user = (User) query.uniqueResult();    
				
			 
						return user;
				
				
	}


	@Override
	public void sauvegarder(User u) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(u);

		
	}


	@Override
	public void AddCompte(User c ,Compte u) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.openSession();
	       

	        c.getComptes().add(u);
			this.sessionFactory.getCurrentSession().save(c);

	}


 

}
