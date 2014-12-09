package org.activiti.designer.test;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class ProcessTestMyProcess extends AbstractWorkflowTest {

	@Test
	@Deployment(resources = { "process/XMyProcess.bpmn" })
	public void startProcess() throws Exception {

		try {
			Map<String, Object> variableMap = new HashMap<String, Object>();

			variableMap.put("name", "Activiti");

			variableMap.put("client_email", "activiti.org@yahoo.com");
			variableMap.put("client_etat", "S");
			variableMap.put("client_nom", "Activiti");
			variableMap.put("client_prenom", "Org");
			variableMap.put("client_id", "1");
			variableMap.put("signalParam", "1");

		

			ProcessInstance processInstance = runtimeService
					.startProcessInstanceByKey("myProcess", variableMap);
			runtimeService.signalEventReceived("mySignal", variableMap);

			


		} catch (Exception e) {
            e.printStackTrace();
			fail("Exception Process : " + e.getMessage());
		}

	}
}