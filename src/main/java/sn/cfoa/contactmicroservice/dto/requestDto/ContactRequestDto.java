package sn.cfoa.contactmicroservice.dto.requestDto;

import lombok.Data;


@Data
public class ContactRequestDto {

	private String nom;
	
	private String prenom;
	
	private String genre;
	
	private String adresse;
	
	private String telephone;	
	
	private String email;
	
	private String type;
	
	private Integer tacheId;
	
	private Integer personneMoralId;

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

	public Integer getTacheId() {
		return tacheId;
	}

	public void setTacheId(Integer tacheId) {
		this.tacheId = tacheId;
	}

	public Integer getPersonneMoralId() {
		return personneMoralId;
	}

	public void setPersonneMoralId(Integer personneMoralId) {
		this.personneMoralId = personneMoralId;
	}
	
	
}
