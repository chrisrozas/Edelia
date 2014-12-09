package org.edelia.poc.processor;

import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.edelia.poc.beans.Client;

public class InfoFileProcessor implements Processor {

	private final static Logger LOG =   Logger.getLogger(InfoFileProcessor.class.getName());
	
	
	public void process(Exchange exch) throws Exception {

		Client c =  exch.getIn().getBody(Client.class);
		c.getId();
		exch.getIn().setHeader("idClient" , c.getId());
		
		
	}

	
	

}