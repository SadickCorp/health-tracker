create table recipe
(
    id          bigserial
        primary key,
    category    varchar(255),
    date        date,
    is_favorite boolean,
    label       varchar(255),
    type        varchar(255),
    profil_id   bigint
        constraint fk68jnd1r257mhr0j09kxawt8ue
            references profil
);

alter table recipe
    owner to postgres;

