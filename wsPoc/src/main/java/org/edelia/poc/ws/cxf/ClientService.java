
package org.edelia.poc.ws.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ClientService {
	  public Client rechercheParNom(@WebParam(name="nom") String text);
	  public String creationClient(@WebParam(name="client") Client client);
	  public void modificationClient(@WebParam(name="client")  Client client);
}

