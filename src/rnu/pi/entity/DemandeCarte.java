package rnu.pi.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DmdCarte")
public class DemandeCarte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int numDemCarte;
	public int getNumDemCarte() {
		return numDemCarte;
	}
	public void setNumDemCarte(int numDemCarte) {
		this.numDemCarte = numDemCarte;
	}
	public TypeCarte getTypeCarte() {
		return typeCarte;
	}
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@Column
	String adresse;
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@ManyToOne(cascade = {CascadeType.REMOVE},fetch=FetchType.EAGER)
private TypeCarte typeCarte;
	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}
	@ManyToOne(cascade = {CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Compte compte;
	@ManyToOne(cascade = {CascadeType.REMOVE},fetch=FetchType.EAGER)
   private User usr;
public User getUsr() {
	return usr;
}
public void setUsr(User usr) {
	this.usr = usr;
}
}
