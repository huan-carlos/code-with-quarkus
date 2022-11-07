-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO categoria (descricao, sigla) values ('Eletrônicos', 'EL');
INSERT INTO categoria (descricao, sigla) values ('Informática', 'IF');
INSERT INTO categoria (descricao, sigla) values ('Cozinha', 'CZ');

INSERT INTO produto (nome, categoria_id) values ('TV', 1),
                                                ('PC', 2),
                                                ('Fogão', 3);