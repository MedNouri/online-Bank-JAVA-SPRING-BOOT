package rnu.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rnu.pi.dao.UserDao;
import rnu.pi.entity.Compte;
import rnu.pi.entity.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
	UserDao userDao;
	public boolean checkUser(String  login, String password) {
		boolean resultatAuthent=false;
		User us=userDao.getUserById(login);
		if(us!=null) {
			if(us.getPassword().equals(password)) {
				resultatAuthent=true;
				List<Compte> l=us.getComptes();
				System.out.println("***"+l.size());
				
			}
			
		}
		
		return resultatAuthent;
	}
 
	@Override
	public void sauvegarder(User u) {
		// TODO Auto-generated method stub
		this.userDao.sauvegarder(u);
	}
 
	@Override
	public User getUserById(String login) {
		User us=this.userDao.getUserById(login);
		return us;
	}

	@Override
	public void AddCompte(User c,Compte u) {
		// TODO Auto-generated method stub
		this.userDao.AddCompte(c,u);

	}

}
