create table goal
(
    id            bigserial
        primary key,
    actual_weight double precision,
    goal_weight   double precision,
    start_weight  double precision,
    profil_id     bigint
        constraint fkt4cet51m3atgtuadk7vs6kerl
            references profil
);

alter table goal
    owner to postgres;

