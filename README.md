# Hystrix-Spring-Boot

# Overview
Circuit breaker is used to stop failures from cascading down, and provide a way to self-heal, which improves the system’s overall resiliency. I’ll be implementing two Microservices – Library and Books. Library microservice is dependent on Book microservice. Hystrix will be used which is a production ready implementation of circuit breaker made by Netflix. Later by disabling book microservice, will see how Hystrix with the help of fallback methods would stop failure from cascading down. 

# Running
Firstly, we will install and run both Microservices by installing them on seperate cmd prompt.
Run book service first by going into bookservice directory on cmd and run:
      
      mvn clean install
      java -jar target\bookservice-0.0.1-SNAPSHOT.jar

Then setup library microservice in the same way as bookservice:
     
     mvn clean install
     java -jar target\java -jar target\bookservice-0.0.1-SNAPSHOT.jar
     
After that, run the api below to test that book microservice is working fine:

     http://localhost:8081/getBookDetailsForLibrary/NationalLibrary
     or
     http://localhost:8081/getBookDetailsForLibrary/StateLibrary

Now run the below library service api which is getting data from the book microservice:
     
     http://localhost:8082/getLibraryDetails/NationalLibrary
     or 
     http://localhost:8082/getLibraryDetails/StateLibrary
     
By calling the above api we will see that the response would include: 
     
     Microservice working and flow is normal
     
Now if we stop the book mircoservice by pressing ctrl+c in cmd and run the library service api's again we will see that the response would change to:

     No Response From Book Service at this moment. Service will be back shortly

This means that the fallbackMethod is now being called as Hysterix has detected that the book microservice is down. Now it will forward all subsequent calls to the fallback method, to prevent future failures.

 
 
