DROP TABLE IF EXISTS patient;

CREATE TABLE patient (
                          patient_id    SERIAL     PRIMARY KEY,
                          login         VARCHAR(64)  NOT NULL,
                          password      VARCHAR(64)  NOT NULL
--                                 CONSTRAINT patient_id_fk  FOREIGN KEY (patient_id) REFERENCES report (id)
);

INSERT INTO patient (login, password)
VALUES
        ('Vika', 'p1'),
        ('Anna', 'p2'),
        ('Natalia', 'p3'),
        ('Oleg', 'p4');

DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
                         doctor_id    SERIAL     PRIMARY KEY,
                         last_name     VARCHAR(64)  NOT NULL,
                         direction    VARCHAR(64)  NOT NULL,
                         experience   BIGINT,
                         clinic VARCHAR(64)
--                                 CONSTRAINT patient_id_fk  FOREIGN KEY (patient_id) REFERENCES report (id)
);
INSERT INTO doctor (last_name, direction, experience, clinic)
VALUES
    ('Kirpichnikova', 'therapist', 15, 'Family'),
    ('Usikov', 'surgery', 11, 'MedCity'),
    ('Ivanov', 'ent', 7, 'Medsi'),
    ('Judakova', 'gastroenterologist', 21, 'RamBam');

DROP TABLE IF EXISTS report;

CREATE TABLE report (
                        report_id    SERIAL     PRIMARY KEY,
                        type         VARCHAR(64)  NOT NULL,
                        date         DATE  NOT NULL,
                        scan         VARCHAR(64)  NOT NULL,
                        patient_id   BIGINT,
                        doctor_id    BIGINT

--                                 CONSTRAINT patient_id_fk  FOREIGN KEY (patient_id) REFERENCES report (id)
);
INSERT INTO report (type, date, scan, patient_id, doctor_id)
VALUES
    ('dentalImage', '2022-01-05', 'scan1.png', 1, 4),
    ('analysis', '2023-03-27', 'scan2.png', 2, 3),
    ('diagnosis', '2024-01-17', 'scan3.jpg', 3, 1),
    ('x-ray-image', '2024-03-03', 'scan4.png', 1, 2),
    ('direction', '2024-03-18', 'scan5.pdf', 1, 2);


DROP TABLE IF EXISTS calendar;

CREATE TABLE calendar (
                        id    SERIAL     PRIMARY KEY,
                        date         DATE  NOT NULL,
                        patient_id   BIGINT,
                        doctor_id    BIGINT

--                                 CONSTRAINT patient_id_fk  FOREIGN KEY (patient_id) REFERENCES report (id)
);
INSERT INTO calendar (date, patient_id, doctor_id)
VALUES
    ('2024-04-07', 1, 4),
    ('2023-04-18', 1, 3),
    ('2024-04-28', 1, 4),
    ('2024-05-05', 2, 2);



