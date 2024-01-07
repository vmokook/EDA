# Practical Work #1 
# Application with common JavaEE architecture

Glassfish 7.0.11
..

## Task 1

Запуск сервера GlassFish по команде: 

`asadmin start-domain`

![1](https://github.com/vmokook/EDA/blob/main/1_JavaEE/images/1.png)

## Task 2 

Будем использовать базу данных PostgreSQL 

## Task 3 

Выбираем предметную область - медицина. База данных будет состоять из двух объектов: пациентов (`patients`) и медицинских записей (`medical_records`). 
Вот скрипт для создания схемы и таблиц выбранной модели:
(нужно дополнить!!!!)

```
CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    gender VARCHAR(10)
);

CREATE TABLE medical_records (
    id SERIAL PRIMARY KEY,
    patient_id INTEGER REFERENCES patients(id),
    visit_date DATE,
    diagnosis TEXT,
    prescription TEXT,
);
```

## Task 4 

### Разработка Data layer



