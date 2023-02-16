package sn.cfoa.contactmicroservice.dto.responseDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class ContactResponseDto {
	
	private Integer id;

	private String nom;
	
	private String prenom;
	
	private String genre;
	
	private String adresse;
	
	private String telephone;	
	
	private String email;
	
	private String type;
	
	private List<String> noteNames;
	
	private List<String> rendezVousNames;
	
	private List<String> opportuniteNames;
	
	private Set<String> tache = new HashSet<>();

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

	public List<String> getNoteNames() {
		return noteNames;
	}

	public void setNoteNames(List<String> noteNames) {
		this.noteNames = noteNames;
	}

	public List<String> getRendezVousNames() {
		return rendezVousNames;
	}

	public void setRendezVousNames(List<String> rendezVousNames) {
		this.rendezVousNames = rendezVousNames;
	}

	public List<String> getOpportuniteNames() {
		return opportuniteNames;
	}

	public void setOpportuniteNames(List<String> opportuniteNames) {
		this.opportuniteNames = opportuniteNames;
	}

	public Set<String> getTache() {
		return tache;
	}

	public void setTache(Set<String> tache) {
		this.tache = tache;
	}
	
}
