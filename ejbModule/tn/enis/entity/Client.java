package tn.enis.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import lombok.NoArgsConstructor;



@Entity
@Table(name = "t_client")

@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Client implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id 
	@Include
	private String cin;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Compte> comptes;

public Client() {
	
}
	public Client(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(cin, other.cin);
	}
	
	

	

}
