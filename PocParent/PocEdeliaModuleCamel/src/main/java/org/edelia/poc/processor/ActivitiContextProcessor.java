package org.edelia.poc.processor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.edelia.poc.beans.Constantes;
import org.edelia.poc.beans.DemandeSMR;



public class ActivitiContextProcessor implements Processor {

	private final static Logger LOG =   Logger.getLogger(ActivitiContextProcessor.class.getName());
	
	public void process(Exchange exch) throws Exception {

		DemandeSMR obj =  exch.getIn().getBody(DemandeSMR.class);
		
		Map<String, Object> m = new HashMap<String, Object>();

		// Add   definitionKey Process + Business key and  tab of Map variable 
		String definitionKeyProcess = (String) exch.getIn().getHeader(Constantes.Process_Definition_Key);
		
		// Add Variables
		ArrayList<HashMap<String, Object>> tabMap = getActivitiVariables(obj,"_");
		
		m.put(Constantes.Variables, tabMap.toArray());
		m.put(Constantes.Process_Definition_Key,definitionKeyProcess);
		m.put(Constantes.Business_Key,obj.getClient().getId());
		
		LOG.info("Variables Actviti: " + tabMap.toString());		

		exch.getIn().setBody(m);
	}

	
	
	

    /**
     * 
     * Return : Renvoie un tableau de Map{name,"value for name"}, {"value", "value for value"} , le name à la forme suivant NomObject patern NomMethode
     * Exemple demandesmr_type ou client_nom en Minuscule
     * 
     * @param obj
     * @param pattern
     * @return
     */
	private ArrayList<HashMap<String, Object>>  getActivitiVariables(Object obj , String pattern) {
	   
		if(obj == null) return null; 
			   
		Class clasz = obj.getClass();
		Method[]  mtab = clasz.getMethods();
		String simpleName = clasz.getSimpleName();
		LOG.finest("Simple name:" + clasz.getSimpleName());
		 ArrayList<HashMap<String, Object>> lmap =  new ArrayList<HashMap<String, Object>>();
		
		for (int i = 0; i < mtab.length; i++) {
			String methodName = mtab[i].getName();
			Method m =  mtab[i];
			if(!methodName.equals("notifyAll") && 
					!methodName.equals("notify") &
					!methodName.equals("Class") &&
					!methodName.equals("hashCode") &&
					!methodName.equals("toString") &&
					!methodName.equals("equals") &&
					!methodName.equals("wait") &&
					!methodName.equals("getClass") && 
					!methodName.startsWith("set")
					)
			try {
			Object value =	m.invoke(obj,new  Object[0]);
			if(value instanceof java.lang.String) {
			methodName = methodName.replaceAll("get", "");
			methodName =simpleName + pattern + methodName;
			methodName =methodName.toLowerCase();
			LOG.finest(  " Nom:= " + methodName + " Value:= " + value);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", methodName);
			map.put("value", value );
			lmap.add(map);
			} else {
				if(value !=null )
					lmap.addAll( getActivitiVariables(value,pattern));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		return lmap;
		
	}
	
	
	
	

	

	
	
}