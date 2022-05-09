INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, DESIGNER_APPLICATION)
VALUES (nextval('user_sequence'), 'admin', '$2a$10$r5Me01u6ND9eC8aG17MFY.JeF2XvA6xBmAnQNjAnivHHiClm.aUlq', 'ADMIN', false);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, DESIGNER_APPLICATION)
VALUES (nextval('user_sequence'), 'Bob', '$2a$10$ZNYsqenZekWe8rdjOH/sQuFmmeR07MVtO34pRS1sfkx9klS0FYUDK', 'USER', false);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, DESIGNER_APPLICATION)
VALUES (nextval('user_sequence'), 'Sofie', '$2a$10$B34UYAqFJQDvSvVnYO7TF.0DaFoHS8wx/IA1YwW2p.bBWjfYmdhPy', 'DESIGNER', false);

insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'bob', true, 20, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'janine', true, 60, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'roger', true, 90, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'erk', true, 10, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 120, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 90, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 80, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 80, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 44, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 22, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
insert into Item (id, name, for_sale, price, link, owner_id) values (nextval('item_seq'), 'item1', true, 119, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/', 2);
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');
-- insert into Item (id, name, for_sale, price, link) values (nextval('item_seq'), 'item1', true, 1, 'https://my.spline.design/tshirtbodymaledarkcopycopy-d29d2fca2da7b8f1405891ebf7413247/');