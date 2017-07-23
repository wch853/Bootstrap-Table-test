DROP TABLE IF EXISTS per;
CREATE TABLE per
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  age int(11) NOT NULL,
  address varchar(255) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO per (id, name, age, address) VALUES (1, 'wch', 21, 'NanJing, NJFU');
INSERT INTO per (id, name, age, address) VALUES (2, 'Andrew Garfield', 23, 'AM');
INSERT INTO per (id, name, age, address) VALUES (3, 'Pili Groyne', 13, 'BR');
INSERT INTO per (id, name, age, address) VALUES (4, 'Hayley Atwell', 24, 'AM');
INSERT INTO per (id, name, age, address) VALUES (5, 'Wagner Moura', 25, 'BR');
INSERT INTO per (id, name, age, address) VALUES (6, 'Claire Danes', 31, 'AM');
INSERT INTO per (id, name, age, address) VALUES (7, 'Rose Byrne', 23, 'AM');
INSERT INTO per (id, name, age, address) VALUES (8, 'Daniel Brühl', 22, 'AM');
INSERT INTO per (id, name, age, address) VALUES (9, 'Uma Thurman', 32, 'BR');
INSERT INTO per (id, name, age, address) VALUES (10, 'Haruka Ayase', 14, 'BR');
INSERT INTO per (id, name, age, address) VALUES (11, 'Rosamund Pike', 33, 'AM');
INSERT INTO per (id, name, age, address) VALUES (12, 'Ewan McGregor', 34, 'AM');
INSERT INTO per (id, name, age, address) VALUES (13, 'Saoirse Ronan', 18, 'AM');
INSERT INTO per (id, name, age, address) VALUES (14, 'Quentin Tarantino', 39, 'AM');