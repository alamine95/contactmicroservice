package sn.cfoa.contactmicroservice.dto.requestDto;

import java.sql.Date;

import lombok.Data;

@Data
public class CampagneRequestDto {

	private String nom;
	
	private Date dateDebut;
	
	private String chiffreAttendue;
	
	private String type;
	
	private String etape;
	
	private Date fin;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getChiffreAttendue() {
		return chiffreAttendue;
	}

	public void setChiffreAttendue(String chiffreAttendue) {
		this.chiffreAttendue = chiffreAttendue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtape() {
		return etape;
	}

	public void setEtape(String etape) {
		this.etape = etape;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
}
