CREATE TABLE users (
user_id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
enabled TINYINT(1),
UNIQUE (username),
PRIMARY KEY (user_id)
);

