CREATE TABLE patients (
patient_id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(15) NOT NULL,
patient_name VARCHAR(50) NOT NULL,
patient_surname VARCHAR(50) NOT NULL,
gender VARCHAR(20) NULL DEFAULT NULL,
birthday_date DATE NULL DEFAULT NULL,
life_status CHAR(5) NOT NULL DEFAULT 'alive',
address_id BIGINT NULL DEFAULT NULL,
PRIMARY KEY (patient_id),
KEY username (username),
KEY address_id (address_id),
CONSTRAINT FK_patients_addresses FOREIGN KEY (address_id) REFERENCES addresses (address_id),
CONSTRAINT FK_patients_users FOREIGN KEY (username) REFERENCES users (username)
);

