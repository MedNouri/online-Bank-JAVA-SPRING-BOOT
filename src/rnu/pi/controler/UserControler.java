package rnu.pi.controler;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

 
import rnu.pi.entity.Compte;
 
import rnu.pi.entity.History;
 
import rnu.pi.entity.User;
import rnu.pi.service.CompteDioService;
import rnu.pi.service.HistoryService;
import rnu.pi.service.UserService;

@Controller
public class UserControler {
	
	public UserControler() {
		System.out.println("UserControler()");
		 
	}
	
	 @Autowired
	 UserService userService;
	 
	 
	 public CompteDioService getCompteService() {
		return compteService;
	}




	public void setCompteService(CompteDioService compteService) {
		this.compteService = compteService;
	}




	public HistoryService getHistoryService() {
		return historyService;
	}




	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}


	@Autowired
	 CompteDioService compteService;
	 
	 @Autowired
	 HistoryService historyService;
	
	@RequestMapping(value = "/checkUser")
	public  ModelAndView checkUser(@ModelAttribute("usr") User usr  ,@ModelAttribute("compte") Compte p,BindingResult bindingResult, HttpServletRequest httpRequest, HttpSession httpSession){
		
		String login=usr.getId();
      String password=usr.getPassword();
      ModelAndView model=new ModelAndView();
      String destination="index";
      String message="Login ou mot de passe incorrect";
      if (login == null) {
    	     model.addObject("erreur", message);
 			model.setViewName(destination);
 			return model;
      }
      
      
      boolean resultatCheckUser = userService.checkUser(login, password);
    
	      if( resultatCheckUser==true) {
	    	  destination="principale";
	    	  User us=this.userService.getUserById(login);
	    	  List<Compte> listCompte= us.getComptes();
	    	  model.addObject("listC", listCompte);
	    	  model.addObject("user", us);
			  model.addObject("IDU", login);

	    	  message="";
	    	   
	      }
	        model.addObject("erreur", message);
			model.setViewName(destination);
			return model;
 }
	
 
	
 
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public  ModelAndView save(@ModelAttribute("usr") User p,BindingResult bindingResult) {
	     // Fill Random DATA 

 		 Compte compte = new Compte();
		 compte.setNumCompte(ThreadLocalRandom.current().nextInt(1, 100 + 1));

			compte.setDateCreation(new Date());
			compte.setSolde(0); 
			compte.setLibelle("Compte intiale");
		 this.compteService.insert(compte);
		 List<Compte> comptes =  new ArrayList<Compte>();
		 comptes.add(compte);
		 p.setComptes(comptes);
		 p.setId(UUID.randomUUID().toString());
		 this.userService.sauvegarder(p);
		 
	      for (int value = 0; value < 10; value = value + 1) {
	    	  
	    	  History hisotry = new History();
	 		 hisotry.setId(ThreadLocalRandom.current().nextInt(1, 100 + 1));
	 		 hisotry.setAmount("500");
	 		 hisotry.setOperationType("V");
	 		 hisotry.setDate(new Date());
	 		 hisotry.setCompteC(compte);
	 		 this.historyService.insert(hisotry);
	 
	        }
		
		 
		 
		String destination="index";
		ModelAndView model=new ModelAndView();
		 model.addObject("Newid", p.getId());
		model.setViewName(destination);
		 return model;
	}
 
	@RequestMapping(value = "/creatBankAcount", method = RequestMethod.POST)
	@ResponseBody

	public  ModelAndView createAccount(@ModelAttribute("usr") String userId ,@ModelAttribute("compte") Compte p,BindingResult bindingResult) {
		  ModelAndView model=new ModelAndView();
		    
 		User us=this.userService.getUserById(userId);
      
		 
		 
		 Compte compte = new Compte();
		 compte.setNumCompte(ThreadLocalRandom.current().nextInt(1, 100 + 1));

			compte.setDateCreation(new Date());
			compte.setSolde(5000); 
			compte.setLibelle("Compte 0");
		// this.compteService.insert(compte);
		  
		 this.userService.AddCompte(us,compte);

	 
	
 
		    
 			  System.out.println("userId="+userId);
				 
		      String destination="principale";
		      
		       System.out.println(us.getNom());
		      
			  List<Compte> listCompte= us.getComptes();
			     

			  model.addObject("listC", listCompte);
			  model.addObject("user", us);
			  model.addObject("IDU", userId);
		 	  model.setViewName(destination);
		 
		 
		

 
	       

		 return model;
	}
	

	
	@RequestMapping(value = "/principale") 
	@ResponseBody

	public  ModelAndView goToCompteList(@ModelAttribute("usr") String userId,@ModelAttribute("compte") Compte compte,BindingResult bindingResult) {
	  ModelAndView model=new ModelAndView();
      User us=this.userService.getUserById(userId);
 
	 
      String destination="principale";
      
       System.out.println(us.getNom());
      
	  List<Compte> listCompte= us.getComptes();
	     

	  model.addObject("listC", listCompte);
	  model.addObject("user", us);
	  model.addObject("IDU", userId);
 	  model.setViewName(destination);
 
	  
		return model;
		

		
		
	}
	 
	
	
	@RequestMapping(value = "/History")
	public  ModelAndView GetCompteHisttory(@ModelAttribute("usr") String userId,@ModelAttribute("compteID") String compteID) {
	  ModelAndView model=new ModelAndView();
       User us=this.userService.getUserById(userId);

	  System.out.println("userId="+compteID);

	  
	  List<History> listH= this.historyService.getHistoryById(compteID);
	     
	  model.addObject("user", us);
	  model.addObject("listH", listH);
	  model.addObject("ID", compteID);
      String destination="History";
 
    
	  model.setViewName(destination);
	  
	  
	  
		return model;
		

		
		
	}
	
	
 
	@RequestMapping(value="/")
	public  ModelAndView index() {
	      ModelAndView model=new ModelAndView();
	      User u=new User();
	  	model.addObject("usr", u);
	  	
	      String destination="index";
	      model.setViewName(destination);
			return model;
			
		}
	 
	
  
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	@ResponseBody
	public  ModelAndView supprimer(@ModelAttribute("usr") String userId ,@ModelAttribute("compte") Compte compteID,BindingResult bindingResult) {
	
		  
		   
		  this.compteService.delete(compteID);
		  
		  ModelAndView model=new ModelAndView();
 		   User us=this.userService.getUserById(userId);
 	     

	      String destination="principale";
	      
	       
	      
		  List<Compte> listCompte= us.getComptes();
		  boolean ans = listCompte.isEmpty(); 
	        if (ans == false) { 

		  model.addObject("listC", listCompte);
	        }
		  model.addObject("user", us);
		  model.addObject("IDU", userId);
	 	  model.setViewName(destination);
	 
		  
			return model;
			
		}
	@RequestMapping(value="/register")
	public  ModelAndView registerLoad() {
	      ModelAndView model=new ModelAndView();
	      User u=new User();
	  	model.addObject("usr", u);
	  	
	      String destination="register";
	      model.setViewName(destination);
			return model;
			
		}
	
	
	
	
	
	
	
}
