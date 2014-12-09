package org.edelia.poc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import com.google.gson.Gson;

@CsvRecord( separator = "," ,generateHeaderColumns = true , crlf = "UNIX" )
@XmlRootElement(name = Constantes.BALISE_Client)
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

	@DataField(pos = 1)
	@XmlElement(name="id")
	private String id;
	
	@DataField(pos = 2)
	@XmlElement(name="nom")
	private String nom;
	
	@DataField(pos = 3)
	@XmlElement(name="prenom")
	private String prenom;
	
	@DataField(pos = 4)
	@XmlElement(name="email")
	private String email;
	
	@DataField(pos = 5)
	@XmlElement(name="etat")
	private String etat;

	@XmlElement(name="civilite")
	private String civilite ;
	
	
	
	public Client(){}
	
	public Client(String jsonString){
		Gson gson = new Gson();
		Client c = gson.fromJson(jsonString, Client.class);
		
		this.id = c.getId();
		this.nom = c.getNom();
		this.prenom = c.getPrenom();
		this.email = c.getEmail();
		this.etat = c.getEtat();
		this.civilite = c.getCivilite();
		
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	
	
	
}
