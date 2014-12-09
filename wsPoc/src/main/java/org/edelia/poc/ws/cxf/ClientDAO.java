package org.edelia.poc.ws.cxf;

public interface ClientDAO  {
  
	public Client rechercheClientParNom(String nom) ;
	
	public void creationClient(Client client);
	
	public void miseAjourClient(Client client);
}
