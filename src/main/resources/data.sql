INSERT INTO roles (name) VALUES ('ADMIN'), ('USER');
INSERT INTO users (email, first_name, last_name, age, password) VALUES ('admin@gmail.com', 'Alex', 'Cooper', 35, 'pass'),
                                                                       ('user@gmail.com', 'Matthew', 'Crost', 23, 'pass');
INSERT INTO users_roles (user_id, roles_id) VALUES ((SELECT users.id FROM users WHERE id=1),(SELECT roles.id FROM roles WHERE id=1)),
                                                   ((SELECT users.id FROM users WHERE id=1),(SELECT roles.id FROM roles WHERE id=2)),
                                                   ((SELECT users.id FROM users WHERE id=2),(SELECT roles.id FROM roles WHERE id=2));