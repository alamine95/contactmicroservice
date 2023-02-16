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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom", nullable = false)
	private String nom;
	
	@Column(name="prenom", nullable = false)
	private String prenom;
	
	@Column(name="genre", nullable = false)
	private String genre;
	
	@Column(name="adresse", nullable = false)
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;	
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Note> notes = new ArrayList<>();
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RendezVous> rendezVouses  = new ArrayList<>();
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Opportunite> opportunites  = new ArrayList<>();
	
	@OneToMany(mappedBy = "contact",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Tache> taches = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personneMoral_id")
	private PersonneMoral personneMoral;
	
	public void addNote(Note note) {
		notes.add(note);
	}
	
	public void removeNote(Note note) {
		notes.remove(note);
	}
	
	public void addRendezVous(RendezVous rendezVous) {
		rendezVouses.add(rendezVous);
	}
	
	public void removeRendezVous(RendezVous rendezVous) {
		rendezVouses.remove(rendezVous);
	}
	
	public void addOpportunite(Opportunite opportunite) {
		opportunites.add(opportunite);
	}
	
	public void removeOpportunite(Opportunite opportunite) {
		opportunites.remove(opportunite);
	}

	public Contact() {}

	public Contact(String nom, String prenom, String genre, String adresse, String telephone, String email,
			String type, List<Note> notes, List<RendezVous> rendezVouses, List<Opportunite> opportunites,
			List<Tache> taches, PersonneMoral personneMoral) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
		this.notes = notes;
		this.rendezVouses = rendezVouses;
		this.opportunites = opportunites;
		this.taches = taches;
		this.personneMoral = personneMoral;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<RendezVous> getRendezVouses() {
		return rendezVouses;
	}

	public void setRendezVouses(List<RendezVous> rendezVouses) {
		this.rendezVouses = rendezVouses;
	}

	public List<Opportunite> getOpportunites() {
		return opportunites;
	}

	public void setOpportunites(List<Opportunite> opportunites) {
		this.opportunites = opportunites;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public PersonneMoral getPersonneMoral() {
		return personneMoral;
	}

	public void setPersonneMoral(PersonneMoral personneMoral) {
		this.personneMoral = personneMoral;
	}

}
