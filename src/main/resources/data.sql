INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'admin', '$2a$10$r5Me01u6ND9eC8aG17MFY.JeF2XvA6xBmAnQNjAnivHHiClm.aUlq', 'portal@gmail.com', 'ADMIN', 0, false, null);
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'Bob', '$2a$10$ZNYsqenZekWe8rdjOH/sQuFmmeR07MVtO34pRS1sfkx9klS0FYUDK', 'bob@gmail.com', 'USER', 0, true, null);
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'Sofie', '$2a$10$B34UYAqFJQDvSvVnYO7TF.0DaFoHS8wx/IA1YwW2p.bBWjfYmdhPy', 'sofie@gmail.com', 'DESIGNER', 2, false, '2022-05-17');

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

insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Portal T-Shirt', true, 20, 'Black', 'https://my.spline.design/tshirtbodymaledarkcopy-81a74bc5f70ad55c1c341e14b98ee3aa/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Black Hoodie', true, 60, 'Black', 'https://my.spline.design/hoodiedarkcopy-171ef111a9158ac493f588dcf10aaf8b/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Yellow Hoodie', true, 90, 'Yellow', 'https://my.spline.design/hoodiedarkcopycopy-1e155e9a515cdf4a5497e98088b95691/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Green Hoodie', true, 10, 'Green', 'https://my.spline.design/hoodiedarkcopycopy-c46af14d6d6f2d7d5dc077c21cb6b31e/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'White long sleeved T-Shirt', true, 120, 'White', 'https://my.spline.design/tshirtlongsleevefemaledarkcopy-bd701fdc4a525eba0dc5eec73c922089/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Red long sleeved T-Shirt', true, 120, 'Red', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopy-2ef5a2ff45fb7feac7d7a9d7509c495d/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Blue long sleeved T-Shirt', true, 90, 'Blue', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopycopy-d69a38f15db47738b3239c499d79d43e/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Black Cap', true, 80, 'Black', 'https://my.spline.design/capdarkcopy-296a9e4612430d308060053efa75c3af/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Red Cap', true, 80, 'Red', 'https://my.spline.design/capdarkcopycopy-5138fe904df06f6a87de93bddad5b6dd/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Green Cap', true, 44, 'Green', 'https://my.spline.design/capdarkcopycopycopy-b9b4d17a13ddb9a7327a0286f8e60158/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Blue T-Shirt', true, 22, 'Blue', 'https://my.spline.design/tshirtbodymaledarkcopycopy-62f404732a26ad75d8493a6a6b6a18bc/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Red T-Shirt', true, 119, 'Red', 'https://my.spline.design/tshirtbodymaledarkcopycopycopy-55fa616caf724564c5bfdd4128c9d607/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Yellow T-Shirt', true, 1, 'Yellow', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopy-c9daef5c83ccca8250c18e5407275eb7/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'Green T-Shirt', true, 1, 'Green', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopy-0252fcd5e92ea09f67b1070dc533eaa2/');
insert into Item (id, name, for_sale, price, color, link) values (nextval('item_seq'), 'White T-Shirt', true, 1, 'White', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopycopy-e37856f0ea297a87ecb5f9ce53233ff5/');