package org.edelia.poc.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.edelia.poc.beans.Client;

public class JsonArrayListProcessor implements Processor {

	public void process(Exchange exch) throws Exception {

		final List<Object> params = new ArrayList<Object>();
		org.edelia.poc.ws.cxf.Client c =  new org.edelia.poc.ws.cxf.Client(); 
		
		if (exch.getIn().getBody()==null ) return;
		
		String jsonString = exch.getIn().getBody(String.class);
		Client clientBeans = new Client(jsonString);
		
		c.setId(clientBeans.getId());
		c.setNom(clientBeans.getNom());
		c.setPrenom(clientBeans.getPrenom());
		c.setEmail(clientBeans.getEmail());
		c.setEtat(clientBeans.getEtat());
		
		//Add param for web Service 
        params.add(c);
        exch.getIn().setBody(params);
        exch.setPattern(ExchangePattern.InOnly);
		
        
	}

	
	

}