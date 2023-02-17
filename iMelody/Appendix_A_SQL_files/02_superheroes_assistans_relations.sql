ALTER table assistants 
ADD COLUMN superheroId int;

ALTER TABLE assistants
ADD CONSTRAINT FK_Superhero_Assistant
FOREIGN KEY (superheroId)
REFERENCES superheroes(superhero_id) 
ON DELETE CASCADE;
