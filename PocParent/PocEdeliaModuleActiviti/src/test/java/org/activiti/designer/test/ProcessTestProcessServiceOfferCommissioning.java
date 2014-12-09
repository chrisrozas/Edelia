package org.activiti.designer.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.activiti.poc.service.ClientActiviti;
import org.activiti.poc.service.ContextActiviti;
import org.junit.Test;

public class ProcessTestProcessServiceOfferCommissioning extends AbstractWorkflowTest {
	
	

	/***
	 * Start process Operation Service offer Comminssioning with "isRequest" Parameters
	 * @throws Exception
	 */
	@Test
	@Deployment(resources = { "process/OperationServOffCom.bpmn",
							"process/SubProcessProvisionning.bpmn"  })
	public void startProcess() throws Exception {
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
		// Parametre du process
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("client_nom", "barrez");
		variableMap.put("client_prenom", "joram");
		variableMap.put("client_email", "joram.barrez@actviti.com");
		variableMap.put("client_id", String.valueOf(randomInt));
		
		ProcessInstance processInstanceOP = runtimeService.startProcessInstanceByKey("Process_Service_Offer_Commissioning", variableMap);
				
		assertNotNull(processInstanceOP.getId());
		
		System.out.println("id Process:= " + processInstanceOP.getId() + " Nom Process:=" + processInstanceOP.getProcessDefinitionId());
		
		ContextActiviti ca = (ContextActiviti)  runtimeService.getVariable(processInstanceOP.getId(), "contextActiviti");
		ClientActiviti c = ca.getClient();
		
		Thread.sleep(2000);
		
		
		assertNotNull("Client is null", c);
		assertTrue(c.getNom().equals("barrez"));
		assertTrue(c.getPrenom().equals("joram"));
		
	}
	

	
}