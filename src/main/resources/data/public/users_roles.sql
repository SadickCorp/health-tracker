create table users_roles
(
    user_id bigint not null
        constraint fk2o0jvgh89lemvvo17cbqvdxaa
            references users,
    role_id bigint not null
        constraint fkj6m8fwv7oqv74fcehir1a9ffy
            references roles
);

alter table users_roles
    owner to postgres;

