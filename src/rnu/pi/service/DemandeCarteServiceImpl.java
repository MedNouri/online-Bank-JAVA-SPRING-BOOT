package rnu.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rnu.pi.dao.DemandeCarteDao;
import rnu.pi.entity.DemandeCarte;


@Service
@Transactional
public class DemandeCarteServiceImpl implements DemandeCarteService {
	@Autowired
	DemandeCarteDao demandeCarteDao;
	@Override
	public void save(DemandeCarte demande) {
		this.demandeCarteDao.save(demande);
		
	}

	@Override
	public List<DemandeCarte> searchByNumCompte(String numCompte) {
		
		return this.demandeCarteDao.searchByNumCompte(numCompte);
	}

	@Override
	public List<DemandeCarte> loadAll() {
		// TODO Auto-generated method stub
		return this.demandeCarteDao.loadAll();
	}

}
