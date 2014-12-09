package org.edelia.poc.beans;

public interface Constantes {

 // xml
 String BALISE_DEMANDE_SMR ="demandeSMR";
 String BALISE_Client ="client";
 String BALISE_Site ="site";
 String BALISE_Offre ="offre";
 String BALISE_ContratFournitureElec ="contratFournitureElec";
 
 
 
 //header rest 
 String HEADER_ACCEPT =  "Accept";
 String HEADER_CONTENT_TYPE =  "Content-Type";
 String APPLICATION_JSON = "application/json";
 
 
 // Activiti paremeter for start Process 
 String Process_Definition_Key="processDefinitionKey";
 String Business_Key = "businessKey";
 String Variables = "variables";
 
 //Process name
 String Process_Service_Offer_Commissioning = "Process_Service_Offer_Commissioning";
	
 String Activiti_signalName="signalName";
 String Activiti_variables = "variables";
 String Activiti_name = "name";
 String Activiti_value = "value";
 
 String ActivationClientModif="ActivationClientModif";
 String signalIdClient = "signalIdClient";
String  async = "async";
String signalEventReceived = "signalEventReceived";
String Action = "action";
String ActionActivitiRest = "actionActivitiRest";
}
