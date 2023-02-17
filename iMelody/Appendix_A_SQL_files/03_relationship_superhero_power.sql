drop table if exists superhero_powers_relationship;

create table superhero_powers_relationship (
	superhero_id int, 
	power_id int
);

alter table superhero_powers_relationship
add constraint fk_superhero
foreign key(superhero_id)
references superheroes(superhero_id)
on delete cascade;

alter table superhero_powers_relationship 
add constraint fk_power
foreign key(power_id)
references powers(power_id)
on delete cascade;
	
	