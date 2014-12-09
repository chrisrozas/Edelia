package org.activiti.poc.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CreateContextTask implements JavaDelegate {

	

	public void  execute(DelegateExecution execution) throws Exception {
		
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
		
		
	        
		 execution.setVariable("contextActiviti", contextActiviti);
		
	        }


	        
		}

