insert into users values ('user1','{bcrypt}$2a$10$gmNIjZbJKSsBcX3kbc0Izudn7JY9tFmKeeBBJ6OSey.WvmPGkxYRm',true);
insert into users values ('user2','{bcrypt}$2a$10$5UERb4FzhGKY2wkXNR3zNu62GQ6tcjdCsVMdQSSyeeodeyOKrcida',true);
insert into users values ('user3','{bcrypt}$2a$10$3kkCLgYB8/bVhkmAT.e8bO1tTHE.btcUg/oreu9r8.oEa8QhZWLoK',true);

insert into authorities values ('user1','ROLE_USER');
insert into authorities values ('user2','ROLE_USER');
insert into authorities values ('user2','ROLE_EDITOR');
insert into authorities values ('user3','ROLE_USER');
insert into authorities values ('user3','ROLE_EDITOR');
insert into authorities values ('user3','ROLE_ADMIN');

insert into t_owner(id,first_name,last_name) values (1,'Ahmet','Gürbüz');
INSERT INTO t_owner (id,first_name,last_name) VALUES (2, 'Beşir', 'Dal');
INSERT INTO t_owner (id,first_name,last_name) VALUES (3, 'Eda', 'Rize');
INSERT INTO t_owner (id,first_name,last_name) VALUES (4, 'Hadi', 'Duru');
INSERT INTO t_owner (id,first_name,last_name) VALUES (5, 'Pınar', 'Mus');
INSERT INTO t_owner (id,first_name,last_name) VALUES (6, 'Çiğdem', 'Su');
INSERT INTO t_owner (id,first_name,last_name) VALUES (7, 'Aslı', 'Zor');
INSERT INTO t_owner (id,first_name,last_name) VALUES (8, 'Murat', 'Eski');
INSERT INTO t_owner (id,first_name,last_name) VALUES (9, 'Davut', 'Saz');
INSERT INTO t_owner (id,first_name,last_name) VALUES (10, 'Kadir', 'Mutlu');

INSERT INTO t_vet (id,first_name,last_name) VALUES (11, 'Elif', 'Taş');
INSERT INTO t_vet (id,first_name,last_name) VALUES (12, 'Gülbahar', 'Taş');
INSERT INTO t_vet (id,first_name,last_name) VALUES (13, 'Zahit', 'Güney');


insert into t_pet(id,name,birth_date,owner_id) values (1,'Dave','2015-01-05',1);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (2, 'Donetello', '2008-08-06', 1);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (3, 'Karabaş', '2001-04-17', 1);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (4, 'Joe', '2009-03-07', 2);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (5, 'Canavar', '2010-11-30', 2);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (6, 'Tatlım', '2010-01-20', 3);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (7, 'Samanta', '2008-09-04', 5);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (8, 'Boncuk', '2008-09-04', 5);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (9, 'Şanslı', '2007-08-06', 5);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (10, 'Karaburun', '2009-02-24', 6);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (11, 'Twetty', '2000-03-09', 7);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (12, 'Tarçın', '2000-06-24', 8);
INSERT INTO t_pet (id,name,birth_date,owner_id) VALUES (13, 'Sarı', '2002-06-08', 9);


