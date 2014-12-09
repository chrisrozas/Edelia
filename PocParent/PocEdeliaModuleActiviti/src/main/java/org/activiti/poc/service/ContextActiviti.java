package org.activiti.poc.service;

import java.io.Serializable;


public class ContextActiviti implements Serializable {

	
	private  String processDefinitionId ;
	private ClientActiviti client = new ClientActiviti();
	
	
	
	
	
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public ClientActiviti getClient() {
		return client;
	}
	public void setClient(ClientActiviti client) {
		this.client = client;
	}
	
	
	
	
	
	
	
}
