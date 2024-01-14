insert into posts (medical_center, id_post) values
('Medical Center A', 1),
('Medical Center A', 2),
('Medical Center C', 1);

insert into patients (id_post, id_patient, first_name, last_name, birth_date, gender) values
(1, 1, 'Marina', 'Pops', '07-05-2000', 'Female'),
(2, 2, 'Semen', 'Yuw', '27-09-1997', 'Male'),
(1, 3, 'Vika', 'Der', '05-05-2001', 'Female');


insert into medical_records (id_post, id_medrec, id_patient, visit_date, diagnosis, prescription) values
(1, 1, 1, '13-01-2024', 'Common Cold', 'Rest and plenty of fluids'),
(2, 2, 2, '12-12-2023', 'Influenza', 'Antiviral medication'),
(1, 3, 3, '29-12-2023', 'Allergic Rhinitis', 'Antihistamines');





