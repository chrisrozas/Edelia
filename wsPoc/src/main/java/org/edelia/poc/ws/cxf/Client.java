package org.edelia.poc.ws.cxf;

import java.io.Serializable;


public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4716636713418432843L;

	private String id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String etat;
	
	

	public Client(){
		super();
	}
	
	public Client(String id, String nom, String prenon, String email){
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenon;
		this.email = email;
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

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	
}
