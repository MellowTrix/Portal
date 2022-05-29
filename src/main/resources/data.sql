INSERT INTO USER (ID, USERNAME, DISPLAYNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'admin', 'admin', '$2a$10$r5Me01u6ND9eC8aG17MFY.JeF2XvA6xBmAnQNjAnivHHiClm.aUlq', 'portal@gmail.com', 'ADMIN', 0, false, null);
INSERT INTO USER (ID, USERNAME, DISPLAYNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'Bob', 'Bob', '$2a$10$ZNYsqenZekWe8rdjOH/sQuFmmeR07MVtO34pRS1sfkx9klS0FYUDK', 'bob@gmail.com', 'USER', 0, true, null);
INSERT INTO USER (ID, USERNAME, DISPLAYNAME, PASSWORD, EMAIL, ROLE, MONTHS_SUBSCRIBED, FREE_TRIAL_AVAILABLE, SUBSCRIPTION_END_DATE)
VALUES (nextval('user_sequence'), 'Sofie', 'Sofie', '$2a$10$B34UYAqFJQDvSvVnYO7TF.0DaFoHS8wx/IA1YwW2p.bBWjfYmdhPy', 'sofie@gmail.com', 'DESIGNER', 2, false, '2022-05-17');

---------------------------------------------------------------------

-- Bob --
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Black Hoodie', 2, 'black', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopy-171ef111a9158ac493f588dcf10aaf8b/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Yellow Hoodie', 2, 'yellow', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopycopy-1e155e9a515cdf4a5497e98088b95691/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green Hoodie', 2, 'green', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopycopy-c46af14d6d6f2d7d5dc077c21cb6b31e/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'White long sleeved T-Shirt', 2, 'white', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopy-bd701fdc4a525eba0dc5eec73c922089/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red long sleeved T-Shirt', 2, 'red', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopy-2ef5a2ff45fb7feac7d7a9d7509c495d/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Blue long sleeved T-Shirt', 2, 'blue', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopycopy-d69a38f15db47738b3239c499d79d43e/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Black Cap', 2, 'black', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopy-296a9e4612430d308060053efa75c3af/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red Cap', 2, 'red', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopycopy-5138fe904df06f6a87de93bddad5b6dd/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green Cap', 2, 'green', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopycopycopy-b9b4d17a13ddb9a7327a0286f8e60158/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Blue T-Shirt', 2, 'blue', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopy-62f404732a26ad75d8493a6a6b6a18bc/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red T-Shirt', 2, 'red', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopy-55fa616caf724564c5bfdd4128c9d607/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Yellow T-Shirt', 2, 'yellow', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopy-c9daef5c83ccca8250c18e5407275eb7/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green T-Shirt', 2, 'green', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopy-0252fcd5e92ea09f67b1070dc533eaa2/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'White T-Shirt', 2, 'white', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopycopy-e37856f0ea297a87ecb5f9ce53233ff5/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Black Hoodie', 2, 'black', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopy-171ef111a9158ac493f588dcf10aaf8b/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Yellow Hoodie', 2, 'yellow', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopycopy-1e155e9a515cdf4a5497e98088b95691/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green Hoodie', 2, 'green', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopycopy-c46af14d6d6f2d7d5dc077c21cb6b31e/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'White long sleeved T-Shirt', 2, 'white', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopy-bd701fdc4a525eba0dc5eec73c922089/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red long sleeved T-Shirt', 2, 'red', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopy-2ef5a2ff45fb7feac7d7a9d7509c495d/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Blue long sleeved T-Shirt', 2, 'blue', 'long sleeved t-shirt', '2022-05-17', 'https://my.spline.design/tshirtlongsleevefemaledarkcopycopycopy-d69a38f15db47738b3239c499d79d43e/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Black Cap', 2, 'black', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopy-296a9e4612430d308060053efa75c3af/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red Cap', 2, 'red', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopycopy-5138fe904df06f6a87de93bddad5b6dd/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green Cap', 2, 'green', 'cap', '2022-05-17', 'https://my.spline.design/capdarkcopycopycopy-b9b4d17a13ddb9a7327a0286f8e60158/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Blue T-Shirt', 2, 'blue', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopy-62f404732a26ad75d8493a6a6b6a18bc/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Red T-Shirt', 2, 'red', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopy-55fa616caf724564c5bfdd4128c9d607/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Yellow T-Shirt', 2, 'yellow', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopy-c9daef5c83ccca8250c18e5407275eb7/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Green T-Shirt', 2, 'green', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopy-0252fcd5e92ea09f67b1070dc533eaa2/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'White T-Shirt', 2, 'white', 't-shirt', '2022-05-17', 'https://my.spline.design/tshirtbodymaledarkcopycopycopycopycopycopy-e37856f0ea297a87ecb5f9ce53233ff5/');

-- Sofie --
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Black Hoodie', 3, 'black', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopy-171ef111a9158ac493f588dcf10aaf8b/');
insert into Item (id, name, owner_id, color, item_type, creation_date, link) values (nextval('item_seq'), 'Yellow Hoodie', 3, 'yellow', 'hoodie', '2022-05-17', 'https://my.spline.design/hoodiedarkcopycopy-1e155e9a515cdf4a5497e98088b95691/');


---------------------------------------------------------------------

INSERT INTO CONTACT_MESSAGE (ID, NAME, EMAIL, SUBJECT, MESSAGE)
VALUES (nextval('contactmessage_seq'), 'Robbe', 'robbe.uytdenhouwen@gmail.com', 'Password change', 'Hi, i was wondering if it would be possible to change my password.');
INSERT INTO CONTACT_MESSAGE (ID, NAME, EMAIL, SUBJECT, MESSAGE)
VALUES (nextval('contactmessage_seq'), 'Robbe', 'robbe.uytdenhouwen@gmail.com', 'Question subscription', 'Hi, could you tell me what the benefits are of subscribing to Portal?');

---------------------------------------------------------------------

INSERT INTO SOCIAL_POST (ID, OWNER_ID, ITEM_ID, SUBJECT, MESSAGE, CREATION_DATE)
VALUES (nextval('social_seq'), 1, 2, 'TestSubject', 'This message is a test scenario for this item', '2022-05-23');