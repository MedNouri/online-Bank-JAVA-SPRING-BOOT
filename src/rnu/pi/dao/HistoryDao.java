package rnu.pi.dao;

import java.util.List;

import rnu.pi.entity.History;
 
 

 
public interface HistoryDao {

	List<History> getHistoryById(String id);
	public void insert(History f);

	}
