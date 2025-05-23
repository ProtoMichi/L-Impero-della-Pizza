ALTER TABLE pizza ALTER COLUMN id SET DEFAULT nextval('pizza_seq');
ALTER TABLE ingrediente ALTER COLUMN id SET DEFAULT nextval('ingrediente_seq');
ALTER TABLE recensione ALTER COLUMN id SET DEFAULT nextval('recensione_seq');

INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Margherita', 5.0, '/images/pizza-margherita.jpg');
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Diavola', 7.0, '/images/pizza-diavola.jpg');	
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Quattro Formaggi', 8.0,'/images/pizza-quattro-formaggi.jpg');

INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Pomodoro',1.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Mozzarella',2.50,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Basilico',0.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina',1.50,true,false);

INSERT INTO recensione(descrizione, data_di_creazione, stelle) VALUES ('DIAVOLA SUPER BUONISSIMA!', 03/10/2023, 5.0);
INSERT INTO recensione(descrizione, data_di_creazione, stelle) VALUES ('Ottime pizze, personale gentile, ma i baffi del titolare puzzano', 16/07/2024, 4.0);
INSERT INTO recensione(descrizione, data_di_creazione, stelle) VALUES ('Buono tutto, specie la diavola!', 17/07/2024, 4.5);
INSERT INTO recensione(descrizione, data_di_creazione, stelle) VALUES ('Tutto ok.', 01/01/2025, 4.0);


