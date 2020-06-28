package rnu.pi.service;

import rnu.pi.entity.Compte;
import rnu.pi.entity.User;

public interface UserService {
  boolean checkUser(String login, String password);
  User getUserById(String login);
	public void sauvegarder(User u);
	public void AddCompte(User c,Compte u);

}
