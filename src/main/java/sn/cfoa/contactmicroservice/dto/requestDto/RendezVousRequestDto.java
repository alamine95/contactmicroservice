package sn.cfoa.contactmicroservice.dto.requestDto;

import java.sql.Date;

import lombok.Data;

@Data
public class RendezVousRequestDto {

	private Date date;
	
	private String heure;
	
	private String object;
	
	private Integer contactId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
}
