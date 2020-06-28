package rnu.pi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
 
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="checkBook")
public class CheckBook {

	
	@Id
     private String  idCheckBook;
	
	@Column
	String adresse;
	
	@ManyToOne(cascade = {CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Compte compte;
	
public CheckBook() {}
	
	public CheckBook(String adresse, Compte compte, User usr) {
	super();
	this.adresse = adresse;
	this.compte = compte;
	this.usr = usr;
}

	@ManyToOne(cascade = {CascadeType.REMOVE},fetch=FetchType.EAGER)
    private User usr;


	public String  getIdCheckBook() {
		return idCheckBook;
	}


	public void setIdCheckBook(String  idCheckBook) {
		this.idCheckBook = idCheckBook;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public User getUsr() {
		return usr;
	}


	public void setUsr(User usr) {
		this.usr = usr;
	}
	
	
	
}
