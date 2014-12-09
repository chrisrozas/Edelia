package org.edelia.poc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = Constantes.BALISE_Site)
@XmlAccessorType(XmlAccessType.FIELD)
public class Site {

	@XmlElement(name="pdl")
	private String pdl;
	
	@XmlElement(name="numeroRue")
	private String numeroRue;
	
	
	@XmlElement(name="codePostal")
	private String codePostal	;
	
	
	@XmlElement(name="commune")
	private String commune;
	
	
	@XmlElement(name="pays")
	private String pays;	
	
	@XmlElement(name="phases")
	private String phases;

	public String getPdl() {
		return pdl;
	}

	public void setPdl(String pdl) {
		this.pdl = pdl;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPhases() {
		return phases;
	}

	public void setPhases(String phases) {
		this.phases = phases;
	}	
	
	
	
}
