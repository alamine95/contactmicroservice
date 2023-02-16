package sn.cfoa.contactmicroservice.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "Campagne")
public class Campagne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom_compagne", nullable=false)
	private String nom;
	
	@Column(name="date_debut", nullable=false)
	private Date dateDebut;
	
	@Column(name="chiffre_attendue", nullable=false)
	private String chiffreAttendue;
	
	@Column(name="type", nullable = false)
	private String type;
	
	@Column(name="etape")
	private String etape;
	
	@Column(name="date_fin", nullable = false)
	private Date fin;

	@OneToMany(mappedBy = "campagne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Lead> leads  = new ArrayList<>();
	
	public Campagne() {}

	public Campagne(String nom, Date dateDebut, String chiffreAttendue, String type, String etape, Date fin,
			List<Lead> leads) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.chiffreAttendue = chiffreAttendue;
		this.type = type;
		this.etape = etape;
		this.fin = fin;
		this.leads = leads;
	}

	public void addLead(Lead lead) {
		leads.add(lead);
	}
	
	public void removeLead(Lead lead) {
		leads.remove(lead);
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

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
	
	
	
}
