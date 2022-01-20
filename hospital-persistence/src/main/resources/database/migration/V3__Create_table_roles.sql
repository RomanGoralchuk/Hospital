CREATE TABLE roles (
login VARCHAR(255) NOT NULL,
rolename VARCHAR(100) NOT NULL,
INDEX FK_roles_users (login) USING BTREE,
CONSTRAINT FK_roles_users FOREIGN KEY (login) REFERENCES users (login)
);