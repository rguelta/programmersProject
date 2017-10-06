# programmersProject
Spring Boot project for Programmer's company avaliation

It's a simple Spring Boot Project, it contain some REST controllers to do operations for a Person CRUD


SET UP
 - Download or checkout the source
 - Go to the application root folder
 - Run the application using the maven command line bellow:
 		mvn spring-boot:run

 		
ACTIONS[Controllers]
- http://localhost:8080/person/save
	- Used to save/update a person	
	- Method: POST
	- Content Type: application/json
	- Sample Call:
	
		{
		    "firstName": "Robin",
		    "lastName": "Guelta",
		    "id": 1
		}
		
- http://localhost:8080/person/get/{id}
	- Get a specific person by id	
	- Method: GET
	- Sample Call: http://localhost:8080/person/get/1
		
- http://localhost:8080/person/remove/{id}
	- Used to remove a person	
	- Method: GET
	- Sample Call: http://localhost:8080/person/remove/1
	
- http://localhost:8080/person/list
	- List all persons	
	- Method: GET
	- Sample Call: http://localhost:8080/person/list
	
- http://localhost:8080/person/search
	- Filter persons by firstName and/or lastName
	- Method: POST
	- Content Type: application/json
	- Sample Calls:
	
		{
		    "firstName": "Robin"
		}
		
		{
		    "lastName": "Guelta"
		}
		
		{
			"firstName": "Robin",
		    "lastName": "Guelta"
		}
