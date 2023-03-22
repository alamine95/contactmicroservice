package sn.cfoa.contactmicroservice.model;

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
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "code_cate", nullable = false, length = 255)
	private String codeCate;
	
	@Column(name = "libelle", nullable = false, length = 255)
	private String libelle;
	
	@Column(name = "description", nullable = false, length = 255)
	private String desc;
	
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Opportunite> opportunites = new ArrayList<>();
	
	public void addOpportunite(Opportunite opportunite) {
		opportunites.add(opportunite);
	}
	
	public void removeOpportunite(Opportunite opportunite) {
		opportunites.remove(opportunite);
	}

	public Categorie() {}

	public Categorie(String codeCate, String libelle, String desc, List<Opportunite> opportunites) {
		this.codeCate = codeCate;
		this.libelle = libelle;
		this.desc = desc;
		this.opportunites = opportunites;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
