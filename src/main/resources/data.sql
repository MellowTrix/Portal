INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE)
VALUES (nextval('user_sequence'), 'admin', '$2a$10$r5Me01u6ND9eC8aG17MFY.JeF2XvA6xBmAnQNjAnivHHiClm.aUlq', 'ADMIN');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE)
VALUES (nextval('user_sequence'), 'Bob', '$2a$10$ZNYsqenZekWe8rdjOH/sQuFmmeR07MVtO34pRS1sfkx9klS0FYUDK', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE)
VALUES (nextval('user_sequence'), 'Sofie', '$2a$10$B34UYAqFJQDvSvVnYO7TF.0DaFoHS8wx/IA1YwW2p.bBWjfYmdhPy', 'DESIGNER');