package sn.cfoa.contactmicroservice.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom", nullable = false)
	private String nom;
	
	@Column(name="prenom", nullable = false)
	private String prenom;
	
	@Column(name="age", nullable = true)
	private String age;
	
	@Column(name="genre", nullable = true)
	private String genre;
	
	@Column(name="profession", nullable = true)
	private String profession;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "campagne_id")
	private Campagne campagne;
	
	@OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Opportunite> opportunites  = new ArrayList<>();

	public Lead() {}

	public Lead(String nom, String prenom, String age, String genre, String profession, Campagne campagne,
			List<Opportunite> opportunites) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.genre = genre;
		this.profession = profession;
		this.campagne = campagne;
		this.opportunites = opportunites;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Campagne getCampagne() {
		return campagne;
	}

	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}

	public List<Opportunite> getOpportunites() {
		return opportunites;
	}

	public void setOpportunites(List<Opportunite> opportunites) {
		this.opportunites = opportunites;
	}
	
}
