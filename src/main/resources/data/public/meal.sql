create table recipe
(
    id          bigserial
        primary key,
    category    bytea,
    date        timestamp,
    is_favorite boolean,
    label       varchar(255),
    type        bytea,
    food_id     bigint
        constraint fk8rbpjdbkct9awfymg01vhcuk4
            references food
);

alter table recipe
    owner to postgres;

