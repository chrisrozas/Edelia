package org.activiti.poc.service;

import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class InfoProcessListener implements ExecutionListener {

	private final static Logger LOG =   Logger.getLogger(InfoProcessListener.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4148985753176267462L;

	public void notify(DelegateExecution execution) throws Exception {
		
		
		
		
		String idClient = (String) execution.getVariable("client_id");
		String nomClient = (String) execution.getVariable("client_nom");
		String prenomClient = (String) execution.getVariable("client_prenom");
		String emailClient = (String) execution.getVariable("client_email");  
		
		
		ClientActiviti client = new ClientActiviti();
		client.setId(idClient);
		client.setNom(nomClient);
		client.setPrenom(prenomClient);
		client.setEmail(emailClient);
		
		//Create Actviti Context
		ContextActiviti contextActiviti = new ContextActiviti();
		contextActiviti.setClient(client);
		contextActiviti.setProcessDefinitionId(execution.getProcessDefinitionId());
		
		//execution.removeVariables();
		 execution.setVariable("contextActiviti", contextActiviti);
		 
		 
		 
		
	}

}
