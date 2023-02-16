package sn.cfoa.contactmicroservice.dto.responseDto;

import lombok.Data;

@Data
public class NoteResponseDto {
	
	private Integer id;

	private String remarque;
	
	private Integer contactId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	
}
