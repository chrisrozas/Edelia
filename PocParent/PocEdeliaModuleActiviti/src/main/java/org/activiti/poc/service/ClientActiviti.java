package org.activiti.poc.service;

import java.io.Serializable;


public class ClientActiviti implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 374348533789270151L;

	private String id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String etat;

	
	
	public ClientActiviti(){}
	
	
	
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
	
	
	
	
}
