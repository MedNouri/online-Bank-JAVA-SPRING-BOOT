package rnu.pi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name="history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String amount;
	
	@Column
	private String operationType;
	
	@Column
	private Date date;

	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "compteID", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Compte compte;
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompteC(Compte compte) {
		this.compte = compte;
	}

	

	   
	    
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public History() {
		super();
	}

	public History( String amount, String operationType, Date date, Compte compte) {
		super();
	 
		this.amount = amount;
		this.operationType = operationType;
		this.date = date;
		this.compte = compte;
	}
	
}
