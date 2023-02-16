package sn.cfoa.contactmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PersonneMoral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_compagnie")
	private String nom;
	
	@Column(name = "siege")
	private String siege;
	
	@Column(name = "activite")
	private String activite;
	
	@Column(name = "secteur")
	private String secteur;
	
	@Column(name = "taille")
	private String taille;

	public PersonneMoral() {}
	
	public PersonneMoral(String nom, String siege, String activite, String secteur, String taille) {
		this.nom = nom;
		this.siege = siege;
		this.activite = activite;
		this.secteur = secteur;
		this.taille = taille;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSiege() {
		return siege;
	}

	public void setSiege(String siege) {
		this.siege = siege;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}
	
}
