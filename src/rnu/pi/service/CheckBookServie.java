package rnu.pi.service;

import java.util.List;

import rnu.pi.entity.CheckBook;

public interface CheckBookServie {
 
		void save (CheckBook checkbook);
		List<CheckBook> searchByNumCompte(String userId);
		List<CheckBook> loadAll();
	
	 

}
