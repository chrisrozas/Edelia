package org.edelia.poc.ws.cxf;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractTests {

	
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("beans-test.xml");
	}
}
