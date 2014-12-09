package org.edelia.poc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = Constantes.BALISE_ContratFournitureElec)
@XmlAccessorType(XmlAccessType.FIELD)
public class Contrat {

	

	@XmlElement(name="id")
	private String id;
	
	@XmlElement(name="numAccordCommercial")
	private String numAccordCommercial;
	
	
	@XmlElement(name="tarif")
	private String tarif;
	
	
	@XmlElement(name="optionTarifaire")
	private String optionTarifaire;
	
	@XmlElement(name="puissanceSouscrite")
	private String puissanceSouscrite;
	
	@XmlElement(name="categorieTPN")
	private String dtr;
	
	
	
}
