
package org.edelia.poc.ws.cxf;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class ClientServiceImplTest extends AbstractTests{
    

	
    @Test
    public void testCreationClient () {
    	AbstractApplicationContext ctx  = createApplicationContext();
    	ClientService csi = ctx.getBean("clientServiceImpl",ClientServiceImpl.class);
    	
			
		
    	
        String id ="" +  (int)(Math.random() * 1000);
        Client c = new Client(id, id+"nom",id+"prenom",id+".email@yahoo.com");

       Client c1 = csi.rechercheParNom(c.getNom());
       assertNull("Response Null",c1);
        
        
        String response = csi.creationClient(c);
        assertNotNull("Response Null", response);

        
        
        c.setEmail("chris.rozas@gmai.com");
        c.setEtat("A");
        csi.modificationClient(c);
        assertEquals("chris.rozas@gmai.com", c.getEmail());
        assertEquals("A", c.getEtat());
        
        
        System.out.println("Id Client " + response);
    	}
        
       
}
