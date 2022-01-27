CREATE TABLE authorities (
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
KEY username (username),
FOREIGN KEY (username) REFERENCES users (username)
);