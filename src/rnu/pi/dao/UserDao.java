package rnu.pi.dao;


import rnu.pi.entity.Compte;
import rnu.pi.entity.User;

public interface UserDao {
	public void sauvegarder(User u);
 User getUserById(String  id);
	public void AddCompte(User c,Compte u);

}
