package rnu.pi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typecarte")
public class TypeCarte {
@Column
@Id
private String id;
@Column
private String libelle;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

}
