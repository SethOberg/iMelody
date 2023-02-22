# iMelody
This is a Java prototype for a media player similar to iTunes called iMelody. It is implemented with Spring Boot to interact with a PostgreSQL database called Chinook, which models the iTunes database of customers purchasing songs.

## Functionality: 

* Reads all the customers in the database, displaying their Id, first name, last name, country, postal code, phone number and email.
* Reads a specific customer from the database (by Id), displaying everything listed in the above point.
* Reads a specific customer by name.
* Returns a page of customers from the database. This takes in limit and offset as parameters and make use of the SQL limit and offset keywords to get a subset of         the customer data.
* Adds a new customer to the database, adding only the fields listed above.
* Updates an existing customer.
* Returns the country with the most customers.
* Customers who is the highest spender (total in invoice table is the largest).
* For a given customer, displays their most popular genre (in the case of a tie, display both).

## Technologies
* Java 17
* Spring Data JPA
* Lombok 
* PostgreSQL

## Contributors
* Ali Habesh
* Seth Öberg

## About the project
Add description.
