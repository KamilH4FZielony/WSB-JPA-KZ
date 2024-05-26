insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, age)
VALUES
('John', 'Doe', '123456789', 'john.doe@example.com', 'P123', '1980-01-01', 41),
('Jane', 'Doe', '987654321', 'jane.doe@example.com', 'P456', '1985-05-05', 36),
('Alice', 'Smith', '555111222', 'alice.smith@example.com', 'P789', '1990-10-10', 31),
('Michael', 'Johnson', '999888777', 'michael.johnson@example.com', 'P111', '1975-03-15', 46),
('Emily', 'Williams', '333222111', 'emily.williams@example.com', 'P222', '1988-07-20', 33),
('William', 'Brown', '666555444', 'william.brown@example.com', 'P333', '1995-12-25', 26),
('Olivia', 'Jones', '444333222', 'olivia.jones@example.com', 'P444', '1983-09-30', 38),
('Ethan', 'Garcia', '222333444', 'ethan.garcia@example.com', 'P555', '1970-11-05', 51),
('Ava', 'Martinez', '777666555', 'ava.martinez@example.com', 'P666', '1982-04-12', 39),
('Noah', 'Lopez', '888999000', 'noah.lopez@example.com', 'P777', '1992-08-18', 29);

INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
('Dr. John', 'Smith', '111222333', 'dr.smith@example.com', 'D123', 'FAMILY_MEDICINE'),
('Dr. Erik', 'Johnson', '444555666', 'dr.johnson@example.com', 'D456', 'PEDIATRICS'),
('Dr. Adrian', 'Williams', '777888999', 'dr.williams@example.com', 'D789', 'SURGERY'),
('Dr. Bob', 'Brown', '333444555', 'dr.brown@example.com', 'D111', 'CARDIOLOGY'),
('Dr. Guy', 'Garcia', '999000111', 'dr.garcia@example.com', 'D222', 'DERMATOLOGY'),
('Dr. Wojtek', 'Martinez', '666777888', 'dr.martinez@example.com', 'D333', 'PSYCHIATRY'),
('Dr. Adam', 'Lopez', '888999000', 'dr.lopez@example.com', 'D444', 'OPHTHALMOLOGY'),
('Dr. Henryk', 'Lee', '222333444', 'dr.lee@example.com', 'D555', 'ENDOCRINOLOGY'),
('Dr. Jurek', 'Adams', '555666777', 'dr.adams@example.com', 'D666', 'ORTHOPEDICS'),
('Dr. Eustachy', 'Scott', '444333222', 'dr.scott@example.com', 'D777', 'UROLOGY');

INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES
('Regular checkup', '2024-06-01 10:00:00', 1, 1),
('Vaccination', '2024-06-15 14:30:00', 2, 2),
('Consultation', '2024-07-05 09:15:00', 3, 3),
('Follow-up appointment', '2024-07-20 11:00:00', 4, 4),
('Dental cleaning', '2024-08-10 15:45:00', 5, 5),
('Physical examination', '2024-08-25 08:30:00', 6, 6),
('Eye examination', '2024-09-05 13:20:00', 7, 7),
('Routine checkup', '2024-09-20 09:45:00', 8, 8),
('Annual physical', '2024-10-10 12:15:00', 9, 9),
('Surgical consultation', '2024-10-25 16:00:00', 10, 10);