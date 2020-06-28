package rnu.pi.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rnu.pi.entity.Compte;
import rnu.pi.entity.DemandeCarte;
import rnu.pi.entity.TypeCarte;
import rnu.pi.entity.User;
import rnu.pi.service.DemandeCarteService;
import rnu.pi.service.TypeCarteService;
import rnu.pi.service.UserService;

@Controller
public class DemandeCarteController {
	@Autowired
	DemandeCarteService demandeCarteService;
	
	public DemandeCarteService getDemandeCarteService() {
		return demandeCarteService;
	}

	public void setDemandeCarteService(DemandeCarteService demandeCarteService) {
		this.demandeCarteService = demandeCarteService;
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
	@RequestMapping(value = "/demCarte")
	public  ModelAndView goToDemCarte(@ModelAttribute("usr") String userId,@ModelAttribute("carte") DemandeCarte carte,BindingResult bindingResult) {
		
		   String destination="demandecarte";

		   ModelAndView model=new ModelAndView();
		      User us=this.userService.getUserById(userId);
	       	  List<Compte> listCompte= us.getComptes();
	    	  model.addObject("listC", listCompte);
	    	  model.addObject("user", us);
	    	  carte.setUsr(us);
	    	  
	    	  System.out.println("22222222222**");
	    	  List<TypeCarte> listTypeCartes=this.typeCarteService.load();
 	    	  model.addObject("listTC",listTypeCartes);
	    	  List<DemandeCarte> listDemCarte=this.demandeCarteService.loadAll();
	    	  model.addObject("listDem",listDemCarte);
	    			model.setViewName(destination);
			return model;
	
		}
	@RequestMapping(value = "/addCarte", method = RequestMethod.POST)

	public  ModelAndView addCarte(@ModelAttribute("usr") String userId,@ModelAttribute("carte") DemandeCarte carte,BindingResult bindingResult,
            HttpServletRequest httpRequest,
            HttpSession httpSession) {
		
		   String destination="demandecarte";
		  
		   ModelAndView model=new ModelAndView();
		   
		   this.demandeCarteService.save(carte);
		   
		   User us=this.userService.getUserById(carte.getUsr().getId());
	       	  List<Compte> listCompte= us.getComptes();
	    	  model.addObject("listC", listCompte);
	    	  model.addObject("user", us);
	    	 List<TypeCarte> listTypeCartes=this.typeCarteService.load();
 	    	  model.addObject("listTC",listTypeCartes);
	    	  
	    	  List<DemandeCarte> listDemCarte=this.demandeCarteService.loadAll();
	    	  model.addObject("listDem",listDemCarte);
	    			model.setViewName(destination);
			return model;
	
		}
}
