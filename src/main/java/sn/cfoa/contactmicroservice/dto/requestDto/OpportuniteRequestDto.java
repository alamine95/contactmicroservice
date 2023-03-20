package sn.cfoa.contactmicroservice.dto.requestDto;

import java.sql.Date;

import lombok.Data;	

@Data
public class OpportuniteRequestDto {

	private String matricule;
	
	private Date mec;
	
	private String valVenal;
	
	private String valNeuf;
	
	private Date debut;
	
	private Date fin;
	
	private String dureContrat;
	
	private String prime;
	
	private Integer contactId;
	
	private Integer leadId;

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

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}
	
}
