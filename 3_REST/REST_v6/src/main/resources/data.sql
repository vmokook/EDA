INSERT into houses (id, street, id_house) VALUES
    (1, 'Moscow street', 27),
    (2, 'Lenina street', 2),
    (3, 'Moscow street', 9);

INSERT into apartments (id, id_house, id_apar) VALUES
    (1, 27, 1),
    (2, 2, 23),
    (3, 9, 12);


INSERT into debtors (id_number, id_house, id_apar, full_name, sex, summy) VALUES
    (77461, 27, 1, 'Bob Petrov', 'male', 100),
    (77464, 2, 23, 'Laure Alibertovna', 'female', 400),
    (77469, 9, 12, 'Robert Kozlov', 'male', 293);

