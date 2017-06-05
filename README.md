# api-sync
Api sample synchronous 

Technologies used: Java 7 , Maven and Spring-Boot

How to build and deploy the code:

	- mvn clean install  (to build the code and make war available in the local repository)
	
	- mvn spring-boot:run (deploy war file in embedded tomcat)
	
Once deployed, the endpoint runs under the URL http://localhost:8080/listing. It supports the following operations

	Sample JSON: 
			{  
  			 "id":"48b1cc10-b8ce-4871-a769-d58b35392286",
   			 "contact":{  
      				"phone":"15126841100",
      				"formattedPhone":"+1 512-684-1100"
   				},
		     "address":{  
      			"address":"1011 W 5th St",
      			"postalCode":"1011",
      			"countryCode":"US",
  			    "city":"Austin",
      			"state":"TX",
      			"country":"United States"
   			},
   			"location":{  
      			"lat":40.225548,
      			"lng":-3.70756
   			}
			}

	POST: to create a listing
	GET: Retrieve a listing. URL: http://localhost:8080/listing/{listingid}
 	PUT: Update a listing
 	DELETE : delete a given listing URL: http://localhost:8080/listing/{listingid}
 	
 	All operation return a listing object that was modified
