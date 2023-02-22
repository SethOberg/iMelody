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

## Continous integration
Each time a push to the main branch is done, a maven build is run to see if project can be built, the tests are skipped since the project uses a local database which will cause an error otherwise.

## Chinook - Entity relationship diagram 
(Only the tables relevant for the assignment are included in this ER diagram)
![Chinook_Entity_Relationship_Diagram](https://user-images.githubusercontent.com/48513637/220643708-1d32bdd5-4c53-4ba3-95af-0e3b72266c28.png)

## Superhero database - SQL files in Appendix_A_SQL_Files
The SQL files in the folder appendix_a_sql_files, contain files to set up a superhero database. The superhero database has a hero table, an assistants table, a powers table and lastly a linking table between hero and powers. 
There is an entity relationship diagram of the superhero database below this section.

## Superhero database - Entity relationship diagram 
![Hero_Entity_Relationship_Diagram](https://user-images.githubusercontent.com/48513637/220648171-f9b51b2f-ee93-4283-8c39-cb1c2af1dd21.png)

