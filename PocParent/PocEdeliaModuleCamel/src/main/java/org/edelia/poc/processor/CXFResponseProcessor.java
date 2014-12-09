package org.edelia.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.gson.Gson;

public class CXFResponseProcessor implements Processor {

	public void process(Exchange exch) throws Exception {

		org.edelia.poc.ws.cxf.Client c =  null; 
		
		org.apache.cxf.message.MessageContentsList  ml =  exch.getOut().getBody(org.apache.cxf.message.MessageContentsList.class);
		
		if ( ml!=null  &&  ml.get(0)!=null ){
			
			c = (org.edelia.poc.ws.cxf.Client) ml.get(0);
			Gson gs = new Gson();
			String json =  gs.toJson(c);
			exch.getIn().setBody(json);
		
		}
	}

	
	

}