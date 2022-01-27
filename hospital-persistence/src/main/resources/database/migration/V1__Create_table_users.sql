CREATE TABLE users (
username VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
enabled TINYINT(1),
PRIMARY KEY (username)
);

