package org.activiti.poc.service;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.edelia.poc.ws.cxf.Client;
import org.edelia.poc.ws.cxf.ClientServiceImplService;

public class SouscriptionCustomerTask implements JavaDelegate {


	public void execute(DelegateExecution execution) throws Exception {
		
		ResourceBundle prop = ResourceBundle.getBundle("placeholder",Locale.FRENCH);
		
		java.net.URL url = new URL(prop.getString("camel.url.proxy.soap"));
		ClientServiceImplService clientService = new ClientServiceImplService(url);
		
		
		String response = "KO";
		String messageErreur = "";
		if(execution.getVariable("contextActiviti")==null)
			createContext(execution);
		
		ContextActiviti contextActiviti = (ContextActiviti)execution.getVariable("contextActiviti");
		ClientActiviti ca = contextActiviti.getClient();
		
		Client c = null;

		try {
			// Recherche by id
			c = clientService.getClientServiceImplPort().rechercheParNom(ca.getId());
			String id = null;
			if (c == null) {
                 c =  new Client();
				c.setEmail(ca.getEmail());
				c.setId(ca.getId());
				c.setNom(ca.getNom());
				c.setPrenom(ca.getPrenom());
				c.setEmail(ca.getEmail());

				id = clientService.getClientServiceImplPort().creationClient(c);
			} else {
				ca.setId(c.getId());
				ca.setEtat(c.getEtat());
				ca.setNom(c.getNom());
				ca.setPrenom(c.getPrenom());
				ca.setEmail(c.getEmail());
				messageErreur = "[" + c.getId() + "]:" + prop.getString("message.client.existe");
			}

			if (id != null) {
				response = "OK";
			}
		} catch (Throwable e) {
			messageErreur = e.getMessage();
			e.printStackTrace();
		}

	
		
		contextActiviti.setClient(ca);

		execution.setVariable("responseWs", response);
		execution.setVariable("MessageErreur", messageErreur);
		 execution.setVariable("contextActiviti", contextActiviti);

	}

	private void createContext(DelegateExecution execution) {
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
		
		execution.removeVariables();
		 execution.setVariable("contextActiviti", contextActiviti);
	}

}
