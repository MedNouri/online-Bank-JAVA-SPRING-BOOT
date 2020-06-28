package rnu.pi.dao;

import java.util.List;

import rnu.pi.entity.CheckBook;

public interface DemandeCheckBookDao {
	void save (CheckBook checkbook);
	List<CheckBook> searchByNumCompte(String numCompte);
	List<CheckBook> loadAll();
}
