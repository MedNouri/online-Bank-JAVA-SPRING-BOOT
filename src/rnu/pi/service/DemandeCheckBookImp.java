package rnu.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 import rnu.pi.dao.DemandeCheckBookDao;
import rnu.pi.entity.CheckBook;


@Service
@Transactional
public class DemandeCheckBookImp implements CheckBookServie {

	@Autowired
	DemandeCheckBookDao checkBookServie;
	
	
	@Override
	public void save(CheckBook checkbook) {
		// TODO Auto-generated method stub
		this.checkBookServie.save(checkbook);
	}

	@Override
	public List<CheckBook> searchByNumCompte(String numCompte) {
		// TODO Auto-generated method stub
		return this.checkBookServie.searchByNumCompte(numCompte);
	}

	@Override
	public List<CheckBook> loadAll() {
		// TODO Auto-generated method stub
		return this.checkBookServie.loadAll();

	}

}
