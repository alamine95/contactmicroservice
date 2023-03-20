	package sn.cfoa.contactmicroservice.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table
public class Opportunite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "matricule", nullable = false)
	private String matricule;
	
	@Column(name = "mec", nullable = false)
	private Date mec;
	
	@Column(name = "valeur_venal", nullable = false)
	private String valVenal;
	
	@Column(name = "valeur_neuf", nullable = false)
	private String valNeuf;
	
	@Column(name = "date_debut", nullable = false)
	private Date debut;
	
	@Column(name = "date_fin", nullable = false)
	private Date fin;
	
	@Column(name = "dure_contrat", nullable = false)
	private String dureContrat;
	
	@Column(name = "prime", nullable = false)
	private String prime;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	@JsonIgnore
	private Contact contact;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "lead_id")
	private Lead lead;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categorie_id")
	@JsonIgnore
	private Categorie categorie;

	public Opportunite() {}

	public Opportunite(String matricule, Date mec, String valVenal, String valNeuf, Date debut, Date fin,
			String dureContrat, String prime, Contact contact, Lead lead, Categorie categorie) {
		this.matricule = matricule;
		this.mec = mec;
		this.valVenal = valVenal;
		this.valNeuf = valNeuf;
		this.debut = debut;
		this.fin = fin;
		this.dureContrat = dureContrat;
		this.prime = prime;
		this.contact = contact;
		this.lead = lead;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getMec() {
		return mec;
	}

	public void setMec(Date mec) {
		this.mec = mec;
	}

	public String getValVenal() {
		return valVenal;
	}

	public void setValVenal(String valVenal) {
		this.valVenal = valVenal;
	}

	public String getValNeuf() {
		return valNeuf;
	}

	public void setValNeuf(String valNeuf) {
		this.valNeuf = valNeuf;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getDureContrat() {
		return dureContrat;
	}

	public void setDureContrat(String dureContrat) {
		this.dureContrat = dureContrat;
	}

	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}
	
}
