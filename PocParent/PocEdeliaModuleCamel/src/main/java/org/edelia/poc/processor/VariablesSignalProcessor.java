package org.edelia.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.edelia.poc.beans.Constantes;

public class VariablesSignalProcessor implements Processor {

	public void process(Exchange exch) throws Exception {

		String body =  exch.getIn().getBody(String.class);
		String id = body.substring(5, body.length()-1);
		
//		 body = "{\""+Constantes.Activiti_signalName+"\": \""+ Constantes.ActivationClientModif + "\", "
//				//+ "\"" + Constantes.async + "\": true, " 
//		 		+ "\""+Constantes.Activiti_variables+"\": ["
//		 		+ "{\""+Constantes.Activiti_name+"\": \""+ Constantes.signalIdClient +"\", \""+Constantes.Activiti_value+"\": \"" +id +"\"}"
//		 		+ "]}";
//		
		String header =  exch.getIn().getHeader(Constantes.ActionActivitiRest,String.class);
		String newHeader = header.replaceAll("executionId", id);
		 exch.getIn().setHeader(Constantes.ActionActivitiRest, newHeader);
		
		 body = "{\""
	             +  Constantes.Action +"\": \""+ Constantes.signalEventReceived + "\", "
				 + "\""+  Constantes.Activiti_signalName+"\": \""+ Constantes.ActivationClientModif + "\" "
			 	 + "}";
			
		
		 System.out.println("*********  body " + body + "********" );
		exch.getIn().setBody(body);
	}

	
	

}