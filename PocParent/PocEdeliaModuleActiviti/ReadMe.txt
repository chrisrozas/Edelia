Activiti Project
========================

This project includes a BPMN 2.0 Diagrams and java classes utilities.

Les libs des Web Services sont génerées par maven (répertoire : /generated/cxf).  



            
Deployement 
Ce fait a l'aide du plugin Activiti qui génere 2 artifacts dans le réperoire deployment
        - (artifact bar : business archive) OperationServOffCom.bar -- Utilisation Activiti explorer pour le deployement 
        - (artifact jar : java archive)  OperationServOffCom.jar    -- qui doivent être copié (visible dans le classpath d'activiti)


Pour le déployement des Process Activiti 
        - Utilisation de la console Activiti-Explorer http://localhost:8080/activiti-explorer/ 
        - Dans le menu Management/Deployment/upload new deployement ou Processes/Model Workspace/import
        
        
        
          

Pour le déployement des Jar utilitaires
  il faut copier les jar ( OperationServOffCom.jar) Web Service dans :
            - tomcat\webapp\activiti-explorer\WEB-INF\lib
            - tomcat\webapp\activiti-rest\WEB-INF\lib



 il faut copier le Driver de la base de données
            - tomcat\lib
            
il faut copier les lib de script des taches (groovy|javascript)
            - tomcat\lib            

            
    
        
TODO 

 -- Test  de performance JMETER ??

-- Gestion du versioning 
    * Tomcat 
       OK pour les process
       KO pour le java
    * Jboss camunda 
       OK pour les process
       OK pour le java    
       
-- fail over 

-- Gestion Erreur / Compensation / modification context -- Il existe 2 types de compensations 
    * Prevu pendant la conception au niveau du design avec un Formulaire utilisateur 
    * Compensation technique java try/catch
    * Double compensation formulaire + java try/catch
    
-- Transaction 


-- Correlation  :  a chaque changement de système    
              
-- idempotence  : coté camel             

-- KPI 
    ** voir ce que l'on peut faire avec les rapports d'Activiti
        
-- Purge de tables historiques        