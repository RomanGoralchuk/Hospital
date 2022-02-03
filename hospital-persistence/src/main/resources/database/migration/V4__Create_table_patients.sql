CREATE TABLE patients (
patient_id VARCHAR(10) NOT NULL,
username VARCHAR(15) NOT NULL,
name VARCHAR(50) NOT NULL,
surname VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
phone VARCHAR(50) NOT NULL,
life_status VARCHAR(15) NOT NULL DEFAULT 'alive',
PRIMARY KEY (patient_id),
FOREIGN KEY (username) REFERENCES users (username)
);