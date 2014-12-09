package org.activiti.poc.service;

import java.util.Locale;
import java.util.ResourceBundle;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.util.json.JSONObject;

public class SendRestRequestTask implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		ResourceBundle prop = ResourceBundle.getBundle("placeholder",
				Locale.FRENCH);

		// -- Appel d'un Service REST fournit par Camel
		String urlRest = prop.getString("camel.rest.url");

		ContextActiviti contextActiviti = (ContextActiviti)execution.getVariable("contextActiviti");
		ClientActiviti ca = contextActiviti.getClient();
		ca.setEtat("A");

		// create json object and populate it
		JSONObject jsonData = new JSONObject();
		jsonData.put("id", ca.getId());
		jsonData.put("nom", ca.getNom());
		jsonData.put("prenom", ca.getPrenom());
		jsonData.put("email", ca.getEmail());
		jsonData.put("etat", ca.getEtat());

		ActivitiRest ar = new ActivitiRest();
		boolean resquestOK = ar.sendRestRequest(urlRest, jsonData);

	}

}
