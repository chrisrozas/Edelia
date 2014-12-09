package org.activiti.poc.service;

import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class PerformencesListener implements ExecutionListener {

	private final static Logger LOG =   Logger.getLogger(PerformencesListener.class.getName());
	
	
	private static final long serialVersionUID = 4148985753176267462L;

	public void notify(DelegateExecution execution) throws Exception {
		
		long dateMs = System.currentTimeMillis();
		LOG.finer(  " Variable  " + execution.getVariables());
		LOG.finer("@@@@@@@@@@@@@@@@@@@@@@@");
		LOG.finer("Process Instance Id:=" + execution.getProcessInstanceId() + " - "+ execution.getProcessDefinitionId() + " - "  + execution.getCurrentActivityName() + "- Current Time in ms [" + dateMs  + "]"  );
		LOG.finer("@@@@@@@@@@@@@@@@@@@@@@@");
		
		
		
	}

}
