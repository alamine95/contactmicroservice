package sn.cfoa.contactmicroservice.dto.requestDto;

import lombok.Data;


@Data
public class LeadRequestDto {

	
	private String nom;
	
	private String prenom;
	
	private String age;
	
	private String genre;
	
	private String profession;
	
	private Integer campagneId;

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

	public Integer getCampagneId() {
		return campagneId;
	}

	public void setCampagneId(Integer campagneId) {
		this.campagneId = campagneId;
	}
	
}
