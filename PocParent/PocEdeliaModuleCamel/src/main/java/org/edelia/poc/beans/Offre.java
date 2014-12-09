package org.edelia.poc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = Constantes.BALISE_Offre)
@XmlAccessorType(XmlAccessType.FIELD)
public class Offre {

	@XmlElement(name="id")
	private String id;
	
	
	@XmlElement(name="codeOffre")
	private String codeOffre;
	
	
	@XmlElement(name="statutContratService")
	private String statutContratService;
	
	@XmlElement(name="idContratService")
	private String idContratService;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodeOffre() {
		return codeOffre;
	}

	public void setCodeOffre(String codeOffre) {
		this.codeOffre = codeOffre;
	}

	public String getStatutContratService() {
		return statutContratService;
	}

	public void setStatutContratService(String statutContratService) {
		this.statutContratService = statutContratService;
	}

	public String getIdContratService() {
		return idContratService;
	}

	public void setIdContratService(String idContratService) {
		this.idContratService = idContratService;
	}
	
	
	
	
}
