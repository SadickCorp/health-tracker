create table profil
(
    id              bigserial
        primary key,
    birth           date,
    created_at      date,
    food_preference varchar(255),
    height          double precision,
    name            varchar(255),
    sexe            varchar(255),
    surname         varchar(255),
    weight          double precision,
    user_id         bigint
        constraint fkpkir43pan9xlvvi0e65glqk7q
            references users
);

alter table profil
    owner to postgres;

