create table monitoring
(
    id        bigserial
        primary key,
    date      date,
    weight    double precision,
    profil_id bigint
        constraint fklgpv7gc81alo9df2atq7uig7k
            references profil
);

alter table monitoring
    owner to postgres;

