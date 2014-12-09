package org.edelia.poc.processor;

import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultMessage;

public class ResponseProcessor implements Processor {

	private final static Logger LOG =   Logger.getLogger(ResponseProcessor.class.getName());
	
	
	public void process(Exchange exch) throws Exception {
		exch.setPattern(ExchangePattern.InOut);

		Message msgOut = new DefaultMessage();
		msgOut.setHeader("CamelHttpResponseCode", "200");
		msgOut.setBody("OK",String.class);
		msgOut.setHeaders(exch.getIn().getHeaders());
		exch.setIn(msgOut);
		
	}

	
	

}