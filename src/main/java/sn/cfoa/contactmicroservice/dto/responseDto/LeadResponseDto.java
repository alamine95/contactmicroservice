package sn.cfoa.contactmicroservice.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class LeadResponseDto {
	
	private Integer id;

	private String nom;
	
	private String prenom;
	
	private String age;
	
	private String genre;
	
	private String profession;
	
	private String campagneName;
	
	private List<String> opportuniteNames;

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

	public String getCampagneName() {
		return campagneName;
	}

	public void setCampagneName(String campagneName) {
		this.campagneName = campagneName;
	}

	public List<String> getOpportuniteNames() {
		return opportuniteNames;
	}

	public void setOpportuniteNames(List<String> opportuniteNames) {
		this.opportuniteNames = opportuniteNames;
	}
	
	
}
