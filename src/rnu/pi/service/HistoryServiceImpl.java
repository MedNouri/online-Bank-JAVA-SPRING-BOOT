package rnu.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rnu.pi.dao.HistoryDao;
 import rnu.pi.entity.History;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
	   public HistoryDao getHistoryDao() {
		return historyDao;
	}

	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	@Autowired
		private HistoryDao historyDao;

	@Override
	public List<History> getHistoryById(String id) {
		// TODO Auto-generated method stub
		return this.historyDao.getHistoryById(id);
	}

	@Override
	public void insert(History f) {
		// TODO Auto-generated method stub
		this.historyDao.insert(f);

		
	}
}
