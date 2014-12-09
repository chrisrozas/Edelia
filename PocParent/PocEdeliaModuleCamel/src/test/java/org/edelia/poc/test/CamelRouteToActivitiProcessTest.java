package org.edelia.poc.test;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelRouteToActivitiProcessTest extends CamelSpringTestSupport {
	
	ResourceBundle prop = ResourceBundle.getBundle("camelContext",
			Locale.FRENCH);

	/**
	 * Une Route camel déclenche le process à l'arrivé d'un fichier
	 * La route camel est defini dans le camel-context.xml 
	 * Le process bpm est deployer de manier automatique dans le confi activiti-context autodeploy_OperationServOffCom1.bpmn
	 * @throws Exception
	 */
	@Test
	public void camelRouteConsumeXmlAndTransformToMAp() throws Exception{
		File f = null;
		try{
		String filename = "test.xml";
		String directory = prop.getString("dir.root")+"/";
		String xml = "<p:DemandesSMR xsi:type='p:DemandesSMR' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:p='http://www.edelia.fr'>"
				+ "<demandeSMR>"
				+ " <ts>2014-03-27T15:54:00Z</ts><type>SouscriptionOffreDeService</type>"
				+ "<client><id>6100000166</id><prenom>Prenom166St</prenom><nom>Nom166St</nom></client>"
				+ "</demandeSMR>"
				+ "</p:DemandesSMR>";
		template.sendBodyAndHeader("file://"+directory,xml+"in/", Exchange.FILE_NAME, filename);

		Thread.sleep(2000);
		
		 f =  new File(directory+"done/"+filename);
		assertTrue("File not moved " + f.getAbsolutePath() , f.exists());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		f.delete();
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
}