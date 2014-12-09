package org.activiti.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.activiti.engine.impl.util.json.JSONObject;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Parameter;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;


public class ActivitiRest {

	private final static Logger LOG =   Logger.getLogger(ActivitiRest.class.getName());
	
	final static Context context = new Context();
	

	public boolean sendRestRequest(String urlRest, JSONObject jsonData) {
		final  ArrayList<Protocol> listProtocol = new ArrayList<Protocol>();
		listProtocol.add(Protocol.HTTP);

		//final  Client client = new Client(context, listProtocol, "org.restlet.ext.httpclient.HttpClientHelper");
		final  Client client = new Client(context, listProtocol);
		
		
		boolean restOK = true;
		final ClientResource cr = new ClientResource(context,Method.POST, urlRest);
		final StringRepresentation stringJson = new StringRepresentation(jsonData.toString());
		cr.setNext(client);
		
		Representation r = null;
		cr.getReference().addQueryParameter("format", "json");

		try {
			stringJson.setMediaType(MediaType.APPLICATION_JSON);

			r = cr.post(stringJson);

		} catch (Exception e) {
			LOG.info(" ## Execption -- Activiti - ActivitiRest   ## ERROR  URL SERVICE REST => "
							+ urlRest + "   message :" + e.getMessage());

			// handling of exceptions
			e.printStackTrace();

			restOK = false;
		} finally {
			try {
				
				if(r!=null){
				    r.getText();
					r.exhaust();
				}
				if(stringJson!=null)
					stringJson.release();
				if(cr!=null)
					cr.release();
				
				if(cr.getResponseEntity()!=null){
					cr.getResponseEntity().exhaust();
					cr.getResponseEntity().release();
					}
				
				if (client != null)
				client.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return restOK;
	}

}
