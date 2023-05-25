create table foodcomposition
(
    id       bigserial
        primary key,
    glucides double precision,
    lipides  double precision,
    proteins double precision,
    sugar    double precision
);

alter table foodcomposition
    owner to postgres;

