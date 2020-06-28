package rnu.pi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rnu.pi.entity.DemandeCarte;
import rnu.pi.entity.User;
@Repository
public class DemandeCarteDaoImpl implements DemandeCarteDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DemandeCarte demande) {
	
		sessionFactory.getCurrentSession().save(demande);
	}

	@Override
	public List<DemandeCarte> searchByNumCompte(String numCompte) {
		Query query=sessionFactory.getCurrentSession().createQuery("from DemandeCarte where compte.numCompte=:num");
 	     query.setParameter("num",  numCompte );
  		List<DemandeCarte> list=query.list();

		return list;
	}

	@Override
	public List<DemandeCarte> loadAll() {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from DemandeCarte");
		List<DemandeCarte> list=query.list();
		
		return list;
	}

}
