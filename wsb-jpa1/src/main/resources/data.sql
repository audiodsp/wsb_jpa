insert into address (id, address_line1, address_line2, city, postal_code)
values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
values (2, 'xasdx', 'yydsadas', 'adsdacity', '62asddas-030');


insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
values (1, 'JD01D', 'j.doe@clinic.com', 'John', 'Doe', 'DERMATOLOGIST', 'DERMATOLOGIST', 1);

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
values (2, 'CT02S', 'c.tree@clinic.com', 'Carl', 'Tree', 'SURGEON', 'OCULIST', 2);



insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, DOES_HAVE_CHRONIC_DISEASE, ADDRESS_ID)
values (1, 'Karen', 'Ipsum', '123-321-432', 'karen.ipsum@outlook.com', 'ki@01', '2000-12-21', FALSE, 1);
insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, DOES_HAVE_CHRONIC_DISEASE, ADDRESS_ID)
values (2, 'Lorem', 'Dolo', '321-321-121', 'lorem.dolo@outlook.com', 'ld@02', '2002-10-12', TRUE, 2);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Routine checkup', '2024-12-21 10:00:00', 1, 1);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (2, 'Routine checkup', '2024-10-20 15:00:00', 2, 2);


INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Ultrasound scan', 'USG', 1),
       (2, 'Electrocardiogram', 'EKG', 2)

