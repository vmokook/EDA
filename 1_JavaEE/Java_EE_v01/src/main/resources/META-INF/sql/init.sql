DROP  TABLE IF EXISTS patients CASCADE;
DROP  TABLE IF EXISTS medical_records CASCADE;
DROP  TABLE IF EXISTS posts CASCADE;


create table posts (
 medrec TEXT,
 id_post integer primary key
);

create table patients(
 id_post int references posts(id_post),
 id_patient int primary key
 first_name TEXT,
 last_name TEXT,
 birth_date TEXT,
 gender TEXT,
);

create table medical_records(
 id_post int references posts(id_post),
 id_medrec int primary key,
 id_patient int references patients(id_patient),
 visit_date DATE,
 diagnosis TEXT,
 prescription TEXT,
);