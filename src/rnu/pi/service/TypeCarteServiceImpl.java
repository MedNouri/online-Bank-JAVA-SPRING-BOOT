package rnu.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rnu.pi.dao.TypeCarteDao;
import rnu.pi.entity.TypeCarte;
@Service
@Transactional
public class TypeCarteServiceImpl implements TypeCarteService  {
    @Autowired
	TypeCarteDao typeCarteDao;
	
	
	@Override
	public List<TypeCarte> load() {
		// TODO Auto-generated method stub
		return this.typeCarteDao.load();
	}

}
