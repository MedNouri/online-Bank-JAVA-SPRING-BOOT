package rnu.pi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rnu.pi.entity.TypeCarte;

@Repository
public class TypeCarteDaoImpl implements TypeCarteDao{
	@Autowired
	private SessionFactory sessionFactory;
	public List<TypeCarte> load() {
		Query query=sessionFactory.getCurrentSession().createQuery(" from TypeCarte");
		
		List<TypeCarte> list=query.list();
		System.out.println(list.size());
		return list;
	}

}
