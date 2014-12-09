
package org.edelia.poc.ws.cxf;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "org.edelia.poc.ws.cxf.ClientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
	private JdbcClientDAO jdbcClientDAO ;
	
	
	public JdbcClientDAO getJdbcClientDAO() {
		return jdbcClientDAO;
	}

	public void setJdbcClientDAO(JdbcClientDAO jcd) {
		this.jdbcClientDAO = jcd;
	}

	@Override
	public Client rechercheParNom(String nom) {
		 
		 Client c=	 jdbcClientDAO.rechercheClientParNom(nom);
		 return c;
	}

	@Override
	public String creationClient(Client client) {
		jdbcClientDAO.creationClient(client);
		return client.getId();
	}

	@Override
	public void modificationClient(Client client) {
		jdbcClientDAO.miseAjourClient(client);
	    	
	}

   
	
}

