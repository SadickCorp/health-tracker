CREATE TABLE IF NOT EXISTS users
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS profil
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    birth DATE,
    created_at DATE,
    food_preference VARCHAR,
    height DOUBLE PRECISION,
    name VARCHAR,
    sexe VARCHAR,
    surname VARCHAR,
    weight DOUBLE PRECISION,
    user_id UUID NOT NULL REFERENCES users (id)
    );

CREATE TABLE IF NOT EXISTS roles
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    name VARCHAR
    );


CREATE TABLE IF NOT EXISTS users_roles
(
    user_id UUID NOT NULL REFERENCES users (id),
    role_id UUID NOT NULL REFERENCES roles (id)
    );

CREATE TABLE IF NOT EXISTS goal
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    actual_weight DOUBLE PRECISION,
    goal_weight DOUBLE PRECISION,
    start_weight DOUBLE PRECISION,
    user_id UUID NOT NULL REFERENCES users (id)
    );

CREATE TABLE IF NOT EXISTS monitoring
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    date date NOT NULL,
    weight DOUBLE PRECISION,
    user_id UUID NOT NULL REFERENCES users (id)
    );

CREATE TABLE IF NOT EXISTS recipe
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    date date NOT NULL,
    category VARCHAR,
    is_favorite BOOLEAN,
    label VARCHAR,
    type VARCHAR,
    user_id UUID NOT NULL REFERENCES users (id)
    );

CREATE TABLE IF NOT EXISTS foodcomposition
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    "name" VARCHAR,
    calories DOUBLE PRECISION,
    serving_size_g DOUBLE PRECISION,
    fat_total_g DOUBLE PRECISION,
    fat_saturated_g DOUBLE PRECISION,
    protein_g DOUBLE PRECISION,
    sodium_mg DOUBLE PRECISION,
    potassium_mg DOUBLE PRECISION,
    cholesterol_mg DOUBLE PRECISION,
    carbohydrates_total_g DOUBLE PRECISION,
    fiber_g DOUBLE PRECISION,
    sugar_g DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS food
(
    id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v1(),
    calorie DOUBLE PRECISION,
    family VARCHAR,
    name VARCHAR,
    quantity DOUBLE PRECISION,
    weight DOUBLE PRECISION,
    foodcomposition_id UUID NOT NULL REFERENCES foodcomposition (id),
    recipe_id UUID NOT NULL REFERENCES recipe (id)
    );


