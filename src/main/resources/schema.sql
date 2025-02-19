create table car (
    id INTEGER PRIMARY KEY,
    model VARCHAR,
    dateOfProduction DATE);

create SEQUENCE car_id_seq MINVALUE 1000000 owned by car.id;