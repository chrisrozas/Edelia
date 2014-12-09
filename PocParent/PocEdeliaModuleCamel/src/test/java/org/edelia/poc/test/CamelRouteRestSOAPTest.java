package org.edelia.poc.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelRouteRestSOAPTest extends CamelSpringTestSupport {

	ResourceBundle prop = ResourceBundle.getBundle("camelContext",
			Locale.FRENCH);
	String restActivation = prop.getString("route.rest.url.activation");

	@Test
	public void activationClientExistTest() throws Exception {

		String jsonString = " { \"id\": \"917\",\"nom\": \"jobs\",\"prenom\":  \"denis\",\"email\": \"stevr.jobs@cloud.com\",\"etat\": \"A\"}";
		String response = (String) template.requestBody("restlet:"
				+ restActivation + "?restletMethod=post", jsonString);

		assertTrue("Response is null", response.equals("OK"));

	}

	@Test
	public void restTest() throws Exception {

		String jsonString = " { \"id\": \""
				+ System.currentTimeMillis()
				+ "\",\"nom\": \"jobs\",\"prenom\":  \"denis\",\"email\": \"stevr.jobs@cloud.com\",\"etat\": \"A\"}";
		Context context = new Context();
		Client client = new Client(context, Protocol.HTTP);

		int i = 0;

		//while (true) {

			System.out.println("@@@@@ Nbr iteration :" + i
					+ "   max iteration: 19105");
			i++;
			final ClientResource cr = new ClientResource(context,
					"http://localhost:9024/rs/createCSVFile");
			final StringRepresentation stringJson = new StringRepresentation(
					jsonString);
			cr.setNext(client);
			Representation r = null;

			cr.setMethod(Method.POST);
			cr.getReference().addQueryParameter("format", "json");

			try {
				stringJson.setMediaType(MediaType.APPLICATION_JSON);

				// cr.post(stringJson).write(System.out);
				r = cr.post(stringJson);

			} catch (Exception e) {
				System.out
						.println(" ## Execption -- Activiti - SendRestRequestTask   ## ERROR  URL SERVICE REST => "
								+ "   message :" + e.getMessage());

				// handling of exceptions
				e.printStackTrace();

			} finally {
				try {
					r.exhaust();
					stringJson.release();
					cr.release();
					cr.getResponseEntity().exhaust();
					cr.getResponseEntity().release();
					if (client != null)
						client.stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			}

		//}//end while

	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}