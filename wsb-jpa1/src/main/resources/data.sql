insert into address (id, address_line1, address_line2, city, postal_code)
values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
values (2, 'xasdx', 'yydsadas', 'adsdacity', '62asddas-030');


insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION)
values (1, 'John', 'Doe', '123-546-789', 'j.doe@cliniclcom', 'JD01D', 'DERMATOLOGIST');

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION)
values (2, 'Carl', 'Tree', '321-654-987', 'c.tree@clinic.com', 'CT01O', 'OCULIST');



insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, DOES_HAVE_CHRONIC_DISEASE, ADDRESS_ID)
values (1, 'Karen', 'Ipsum', '123-321-432', 'karen.ipsum@outlook.com', 'ki@01', '2000-12-21', TRUE, 1);
insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, DOES_HAVE_CHRONIC_DISEASE, ADDRESS_ID)
values (2, 'Lorem', 'Dolo', '321-321-121', 'lorem.dolo@outlook.com', 'ld@02', '2002-10-12', FALSE, 2);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Routine checkup', '2018-12-21 10:00:00', 1, 1);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (2, 'Routine checkup', '2019-12-21 10:00:00', 2, 1);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (3, 'Routine checkup', '2020-12-21 10:00:00', 2, 2);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (4, 'Routine checkup', '2021-12-21 10:00:00', 2, 2);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (5, 'Routine checkup', '2022-12-21 10:00:00', 2, 1);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (6, 'Routine checkup', '2023-10-20 15:00:00', 1, 1);


INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Ultrasound scan', 'USG', 1),
       (2, 'Electrocardiogram', 'EKG', 2)