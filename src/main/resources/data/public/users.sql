create table users
(
    id       bigserial
        primary key,
    email    varchar(255) not null,
    password varchar(255) not null
);

alter table users
    owner to postgres;

