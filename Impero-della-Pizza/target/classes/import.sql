ALTER TABLE pizza ALTER COLUMN id SET DEFAULT nextval('pizza_seq');
ALTER TABLE ingrediente ALTER COLUMN id SET DEFAULT nextval('ingrediente_seq');

INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Margherita', 5.0, '/images/pizza-margherita.jpg');
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Diavola', 7.0, '/images/pizza-diavola.jpg');	
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Quattro Formaggi', 8.0,'/images/pizza-quattro-formaggi.jpg');

INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Pomodoro',1.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Mozzarella',2.50,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Basilico',0.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina',1.50,true,false);



