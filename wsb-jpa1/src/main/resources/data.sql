<<<<<<< HEAD
insert into address (id, address_line1, address_line2, city, postal_code)
values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
values (2, 'xasdx', 'yydsadas', 'adsdacity', '62asddas-030');


insert into doctor (ID, DOCTOR_NUMBER, EMAIL, FIRST_NAME, LAST_NAME, SPECIALIZATION, TELEPHONE_NUMBER)
values (1, 'JD01D', 'j.doe@clinic.com', 'John', 'Doe', 'DERMATOLOGIST', '123-456-789');

insert into doctor (ID, DOCTOR_NUMBER, EMAIL, FIRST_NAME, LAST_NAME, SPECIALIZATION, TELEPHONE_NUMBER)
values (2, 'CT02S', 'c.tree@clinic.com', 'Carl', 'Tree', 'SURGEON', '987-654-321');




INSERT INTO medical_treatment (id, description, type)
VALUES (1, 'Ultrasound scan', 'USG'),
       (2, 'Electrocardiogram', 'EKG'),
       (3, 'X-ray', 'RTG');

INSERT INTO visit (id, description, time, doctor_id)
VALUES (1, 'Routine checkup', '2024-12-21 10:00:00', 1);

INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id)
VALUES (1, 1),  -- Visit 1, Treatment 1
       (1, 2);  -- Visit 1, Treatment 2

=======
insert into address (id, address_line1, address_line2, city, postal_code)
values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
values (2, 'xasdx', 'yydsadas', 'adsdacity', '62asddas-030');


insert into doctor (ID, DOCTOR_NUMBER, EMAIL, FIRST_NAME, LAST_NAME, SPECIALIZATION, TELEPHONE_NUMBER)
values (1, 'JD01D', 'j.doe@clinic.com', 'John', 'Doe', 'DERMATOLOGIST', '123-456-789');

insert into doctor (ID, DOCTOR_NUMBER, EMAIL, FIRST_NAME, LAST_NAME, SPECIALIZATION, TELEPHONE_NUMBER)
values (2, 'CT02S', 'c.tree@clinic.com', 'Carl', 'Tree', 'SURGEON', '987-654-321');




INSERT INTO medical_treatment (id, description, type)
VALUES (1, 'Ultrasound scan', 'USG'),
       (2, 'Electrocardiogram', 'EKG'),
       (3, 'X-ray', 'RTG');

INSERT INTO visit (id, description, time, doctor_id)
VALUES (1, 'Routine checkup', '2024-12-21 10:00:00', 1);

INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id)
VALUES (1, 1),  -- Visit 1, Treatment 1
       (1, 2);  -- Visit 1, Treatment 2

>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
