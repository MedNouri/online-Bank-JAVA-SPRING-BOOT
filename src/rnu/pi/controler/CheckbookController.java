package rnu.pi.controler;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rnu.pi.entity.CheckBook;
import rnu.pi.entity.Compte;
 
import rnu.pi.entity.User;
import rnu.pi.service.CheckBookServie;
 
import rnu.pi.service.TypeCarteService;
import rnu.pi.service.UserService;

@Controller
public class CheckbookController {

	
	@Autowired
	CheckBookServie checkBookService;
	
	public CheckBookServie getcheckBookService() {
		return checkBookService;
	}

	public void setcheckBookService(CheckBookServie checkBookService) {
		this.checkBookService = checkBookService;
	}
	
 
	
	@Autowired
	 UserService userService;
	@Autowired
	TypeCarteService typeCarteService;
	 Compte compte;
	

	public TypeCarteService getTypeCarteService() {
		return typeCarteService;
	}

	public void setTypeCarteService(TypeCarteService typeCarteService) {
		this.typeCarteService = typeCarteService;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	 
	@RequestMapping(value = "/Checkbook")
	public  ModelAndView goToDemCarte(@ModelAttribute("usr") String userId,@ModelAttribute("checkBookA") CheckBook carte,BindingResult bindingResult) {
	      
	 

		User us=this.userService.getUserById(userId);

		   ModelAndView model=new ModelAndView();
		if (us == null ) {
			model.setViewName("/");

			return model;
		}else {
		   String destination="Checkbook";

			model.setViewName(destination);
   List<Compte> listCompte= us.getComptes();
	    	  model.addObject("listC", listCompte);
	    	  model.addObject("user", us);
	    	  
	    	  List<CheckBook> listch= this.checkBookService.searchByNumCompte(userId);
	    	  model.addObject("listDem", listch);
	    	  
	    	  
	    	  carte.setUsr(us);
	    	  
			return model;
		}
		}
 
	@RequestMapping(value = "/CheckbookSave", method = RequestMethod.POST)

	public  ModelAndView SaveCheckBook( @ModelAttribute("usr") String userId,@ModelAttribute("checkBookA") CheckBook carte,BindingResult bindingResult, HttpServletRequest httpRequest,
            HttpSession httpSession) {
		 
			   User us=this.userService.getUserById(httpRequest.getParameter("usr.id"));
		  
				 

 			   
			   
			   ModelAndView model=new ModelAndView();
			if (us == null ) {
				model.setViewName("/");

				return model;
			}else {
 
				carte.setIdCheckBook(UUID.randomUUID().toString());
				this.checkBookService.save(carte);
		   String destination="Checkbook";
	       	  List<Compte> listCompte= us.getComptes();
	    	  model.addObject("listC", listCompte);
	    	  model.addObject("user", us);
	    	  List<CheckBook> listch= this.checkBookService.searchByNumCompte(userId);
	    	  model.addObject("listDem", listch);
	    	  
	    	  
			model.setViewName(destination);

	    	 return model;
			}
		}
	
	
	
	
	
}
