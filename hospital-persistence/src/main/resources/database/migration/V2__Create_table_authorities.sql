CREATE TABLE authorities (
authorities_id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,
KEY username (username),
FOREIGN KEY (username) REFERENCES users (username),
PRIMARY KEY (authorities_id)
);