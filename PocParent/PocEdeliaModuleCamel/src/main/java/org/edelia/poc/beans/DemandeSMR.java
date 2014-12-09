package org.edelia.poc.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = Constantes.BALISE_DEMANDE_SMR)
@XmlAccessorType(XmlAccessType.FIELD)
public  class DemandeSMR  implements Serializable  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6638461508283807285L;



	@XmlElement(name="ts")
	private  String ts ;
	
	

	@XmlElement(name="type")
	private String type;
	
	
	@XmlElement(name="client" )
	private Client client ;
	
	@XmlElement(name="site")
	private Site site ;
	
	@XmlElement(name="offre")
	private Offre offre ;
	
	@XmlElement(name="contratFournitureElec")
	private Contrat contrat ;
	
	
	public String getTs() {
		return ts;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	

	
	
}