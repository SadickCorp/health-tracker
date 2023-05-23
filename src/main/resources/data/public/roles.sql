create table roles
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table roles
    owner to postgres;

