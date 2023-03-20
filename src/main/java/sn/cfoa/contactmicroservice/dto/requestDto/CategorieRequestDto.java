package sn.cfoa.contactmicroservice.dto.requestDto;

import lombok.Data;

@Data
public class CategorieRequestDto {

	private String codeCate;
	
	private String libelle;
	
	private String desc;

	public String getCodeCate() {
		return codeCate;
	}

	public void setCodeCate(String codeCate) {
		this.codeCate = codeCate;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
