package rnu.pi.service;

import java.util.List;

import rnu.pi.entity.Compte;
import rnu.pi.entity.History;

public interface HistoryService {
 
		List<History> getHistoryById(String id);
	 
		public void insert(History f);

}
