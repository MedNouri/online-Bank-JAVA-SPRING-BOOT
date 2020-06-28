package rnu.pi.dao;

import java.util.List;

import rnu.pi.entity.DemandeCarte;

public interface DemandeCarteDao {
void save (DemandeCarte demande);
List<DemandeCarte> searchByNumCompte(String numCompte);
List<DemandeCarte> loadAll();
}
