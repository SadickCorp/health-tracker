create table food
(
    id                 bigserial
        primary key,
    calorie            integer,
    family             varchar(255),
    name               varchar(255),
    quantity           integer,
    weight             integer,
    foodcomposition_id bigint
        constraint fkplsvuhum2tqeibq3tmgw7e06q
            references foodcomposition,
    recipe_id          bigint
        constraint fk69ijw94tgy87hgt23h90pud0k
            references recipe
);

alter table food
    owner to postgres;

