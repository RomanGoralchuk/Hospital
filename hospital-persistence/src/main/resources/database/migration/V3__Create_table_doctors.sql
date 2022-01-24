CREATE TABLE doctors (
doctor_id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(15) NOT NULL,
doctor_name VARCHAR(50) NOT NULL,
doctor_surname VARCHAR(50) NOT NULL,
doctor_specialization VARCHAR(50) NOT NULL,
PRIMARY KEY (doctor_id),
FOREIGN KEY (username) REFERENCES users (username)
);

