drop table if exists superhero_powers_relationship; 
drop table if exists assistants; 
drop table if exists powers; 
drop table if exists superheroes;


CREATE TABLE superheroes (
	superhero_id serial primary key, 
	superhero_name varchar(50),
	superhero_alias varchar(50),
    superhero_origin varchar(50)
);

CREATE TABLE assistants (
	assistant_id SERIAL primary key, 
	asisstant_name varchar(50)
);

CREATE TABLE powers (
	power_id SERIAL primary key, 
	power_name varchar(50),
	power_description varchar(255)
);
 