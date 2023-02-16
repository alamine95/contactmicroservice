package sn.cfoa.contactmicroservice.dto.requestDto;

import lombok.Data;

@Data
public class NoteRequestDto {

	private String remarque;
	private Integer contactId;

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
