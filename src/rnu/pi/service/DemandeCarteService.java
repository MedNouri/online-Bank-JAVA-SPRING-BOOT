package rnu.pi.service;

import java.util.List;

import rnu.pi.entity.DemandeCarte;

public interface DemandeCarteService {
	void save (DemandeCarte demande);
	List<DemandeCarte> searchByNumCompte(String numCompte);
	List<DemandeCarte> loadAll();
}
