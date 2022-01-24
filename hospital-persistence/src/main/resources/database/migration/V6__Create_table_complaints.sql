CREATE TABLE complaints (
complaint_id BIGINT NOT NULL AUTO_INCREMENT,
patient_id BIGINT NOT NULL,
description VARCHAR(255) NOT NULL,
doctor_id BIGINT NULL DEFAULT NULL,
PRIMARY KEY (complaint_id),
KEY patient_id (patient_id),
KEY doctor_id (doctor_id),
CONSTRAINT FK_complaints_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id),
CONSTRAINT FK_complaints_patients FOREIGN KEY (patient_id) REFERENCES patients (patient_id)
);

