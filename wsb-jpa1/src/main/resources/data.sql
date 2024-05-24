INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES 
    ('New York', '123 Main St', 'Apt 4B', '10001'),
    ('Los Angeles', '456 Elm St', 'Suite 200', '90001'),
    ('Chicago', '789 Oak Ave', NULL, '60601'),
    ('Houston', '101 Pine St', 'Apt 10', '77001');

INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES 
    ('John', 'Doe', '123456789', 'john.doe@example.com', 'D001', 'SURGEON', 1),
    ('Emily', 'Smith', '987654321', 'emily.smith@example.com', 'D002', 'PEDIATRICIAN', 2),
    ('Michael', 'Johnson', '555444333', 'michael.johnson@example.com', 'D003', 'CARDIOLOGIST', 3),
    ('Sarah', 'Brown', '111222333', 'sarah.brown@example.com', 'D004', 'DERMATOLOGIST', 1);

INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES 
    ('Jane', 'Doe', '123456789', 'jane.doe@example.com', 'P001', '1980-05-15', 1),
    ('Adam', 'Wilson', '555123456', 'adam.wilson@example.com', 'P002', '1975-08-20', 2),
    ('Rachel', 'Jones', '777888999', 'rachel.jones@example.com', 'P003', '1990-03-10', 3),
    ('Daniel', 'Garcia', '333555777', 'daniel.garcia@example.com', 'P004', '1988-12-05', 1);

INSERT INTO VISIT (description, time, doctor_id, patient_id)
VALUES 
    ('Annual Checkup', '2024-05-20T10:00:00', 1, 1),
    ('Dental Checkup', '2024-06-15T09:30:00', 2, 3),
    ('Eye Examination', '2024-07-20T11:15:00', 3, 2),
    ('Physical Therapy', '2024-08-10T14:00:00', 4, 1);

INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES 
    ('Blood Test', 'DIAGNOSTIC', 1),
    ('X-Ray', 'IMAGING', 1),
    ('Dental Cleaning', 'TREATMENT', 2),
    ('Contact Lens Fitting', 'TREATMENT', 3),
    ('Joint Mobilization', 'THERAPY', 4);