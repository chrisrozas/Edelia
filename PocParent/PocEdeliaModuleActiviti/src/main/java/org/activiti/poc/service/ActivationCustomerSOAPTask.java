package org.activiti.poc.service;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.edelia.poc.ws.cxf.Client;
import org.edelia.poc.ws.cxf.ClientServiceImplService;

public class ActivationCustomerSOAPTask implements JavaDelegate {


	public void execute(DelegateExecution execution) throws Exception {

		ResourceBundle prop = ResourceBundle.getBundle("placeholder",
				Locale.FRENCH);

		java.net.URL url = new URL(prop.getString("camel.url.proxy.soap"));
		ClientServiceImplService clientService = new ClientServiceImplService(url);
		
		String response = "KO";
		String messageErreur = "";

		String nomClient = (String) execution.getVariable("client_nom");
		String prenomClient = (String) execution.getVariable("client_prenom");
		String idClient = (String) execution.getVariable("client_id");
		String emailClient = (String) execution.getVariable("client_email");
		Client c = new Client();
		c.setEmail(emailClient);
		c.setId(idClient);
		c.setNom(nomClient);
		c.setPrenom(prenomClient);
		c.setEmail(emailClient);
		c.setEtat("A");
		try {
			 clientService.getClientServiceImplPort().modificationClient(c);
			
		} catch (Throwable e) {
			messageErreur = e.getMessage();
		}

		execution.setVariable("responseWs", response);
		execution.setVariable("MessageErreur", messageErreur);

	}

}
