package rnu.pi.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rnu.pi.dao.CompteDAO;
 import rnu.pi.entity.Compte;
 @Service
@Transactional
public class CompteDioServiceImpl implements CompteDioService {
public CompteDAO getFormationDao() {
		return compteDAO;
	}
	public void setFormationDao(CompteDAO compteDAO) {
		this.compteDAO = compteDAO;
	}
@Autowired
CompteDAO compteDAO;
 
	@Override
	public void insert(Compte f) {
		// TODO Auto-generated method stub
		this.compteDAO.insert(f);
	}
	@Override
	public void delete(Compte f) {
		// TODO Auto-generated method stub
		this.compteDAO.delete(f);
	}
	

}