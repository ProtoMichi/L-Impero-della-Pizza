ALTER TABLE pizza ALTER COLUMN id SET DEFAULT nextval('pizza_seq');

INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Margherita', 5.0, '/images/pizza-margherita.jpg');
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Diavola', 7.0, '/images/pizza-diavola.jpg');	
INSERT INTO pizza (nome, prezzo, URLImmagine) VALUES ('Quattro Formaggi', 8.0,'/images/pizza-quattro-formaggi.jpg');

