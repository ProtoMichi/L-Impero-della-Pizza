ALTER TABLE pizza ALTER COLUMN id SET DEFAULT nextval('pizza_seq');
ALTER TABLE ingrediente ALTER COLUMN id SET DEFAULT nextval('ingrediente_seq');
ALTER TABLE recensione ALTER COLUMN id SET DEFAULT nextval('recensione_seq');

INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina 00',1.50,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina 0',1.00,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina manitoba',2.50,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina integrale',3.00,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina di semola rimacinata di grano duro',3.50,true,false);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina di riso',3.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina di mais',2.75,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Farina di grano saraceno',4.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Pomodoro',1.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Mozzarella',2.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Basilico',0.50,true,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Cheddar',1.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Gorgonzola',2.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Fontina',2.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Parmiggiano Reggiano',2.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Ventricina',1.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Prosciutto Cotto',1.00,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Alici',2.50,false,true);
INSERT INTO ingrediente(nome,prezzo,vegan,celiaco)VALUES('Origano',0.50,true,true);

INSERT INTO pizza (nome,prezzo, URLImmagine,tipo_farina_id) VALUES ('Margherita',5.00, '/images/pizza-margherita.jpg',1);
INSERT INTO pizza (nome,prezzo, URLImmagine,tipo_farina_id) VALUES ('Diavola',7.00, '/images/pizza-diavola.jpg',51);	
INSERT INTO pizza (nome,prezzo, URLImmagine,tipo_farina_id) VALUES ('Quattro Formaggi',8.00,'/images/pizza-quattro-formaggi.jpg',101);

INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (1,401);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (1,451);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (1,501);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (51,401);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (51,451);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (51,751);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (101,701);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (101,451);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (101,601);
INSERT INTO pizza_lista_ingredienti(lista_pizze_id,lista_ingredienti_id) VALUES (101,651);

INSERT INTO recensione(pizza_id, descrizione, data_di_creazione, stelle) VALUES (51,'DIAVOLA SUPER BUONISSIMA!', '03-10-2023', 5.0);
INSERT INTO recensione(pizza_id, descrizione, data_di_creazione, stelle) VALUES (1,'Ottime pizze, personale gentile, ma i baffi del titolare puzzano', '16-07-2024', 4.0);
INSERT INTO recensione(pizza_id, descrizione, data_di_creazione, stelle) VALUES (1,'Buono tutto, specie la mozzarella!', '17-07-2024', 4.5);
INSERT INTO recensione(pizza_id, descrizione, data_di_creazione, stelle) VALUES (101,'Tutto ok.', '01-01-2025', 4.0);

INSERT INTO users(id, nome, cognome, email) VALUES(nextval('users_seq'), 'paolo', 'paolo', 'paolo@gmail.com');
INSERT INTO credentials(id, password, ruolo, username, user_id) VALUES(nextval('credentials_seq'), '$2a$10$F605H0XOC06ODyI.oQnCzeMWpWRPNOH2DM2Lmf.ZSAkNrTG6Kqa3q', 'DEFAULT', 'paolo',currval('users_seq'));
INSERT INTO users(id, nome, cognome, email) VALUES(nextval('users_seq'), 'admin', 'admin', 'admin@admin.com');
INSERT INTO credentials(id, password, ruolo, username, user_id) VALUES(nextval('credentials_seq'), '$2a$12$Lzmhtr/JjTVh8zJF.6h6IOswJfrt.zmuS3yjvjZW999TJdDoRroQu', 'ADMIN', 'admin',currval('users_seq'));
