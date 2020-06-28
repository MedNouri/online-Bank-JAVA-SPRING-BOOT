package rnu.pi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	  @Id
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	  //  @Basic(optional = false)
	//    @Column(name = "id",unique=true, nullable = false)
    private String  id;
	@Column
	private String password;
	@Column
	private String nom;
	@Column
	private String prenom;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
    private List<Compte> comptes;
	
	 
 
	public User(String id, String password, String nom, String prenom, List<Compte> comptes) {
		super();
		this.id = id;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.comptes = comptes;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", comptes="
				+ comptes + "]";
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
 
	public String  getId() {
		return id;
	}
	public void setId(String  id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
