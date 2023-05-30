-- Compte admin@gmail.com/Azerty1234! et dev@gmail.com/Azerty1234!
INSERT INTO public.users (id, email, password) values ('ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f', 'dev@gmail.com', '$2a$10$zNb2uhBv.DN8oeM9cJW8Vun5HtKDjDspnSVOASkv7weLTphPsEJEm'),
                                               ('042ec3a9-7ecf-4550-813c-f620dfb31203', 'admin@gmail.com', '$2a$10$zNb2uhBv.DN8oeM9cJW8Vun5HtKDjDspnSVOASkv7weLTphPsEJEm');


INSERT INTO public.profil (id, birth, created_at, food_preference, height, "name", sexe, surname, weight, user_id)
VALUES('00000000-0000-0000-0000-000000000001', '1990-01-01', '2023-01-01', 'NONE', 178, 'admin', 'MAN', 'test', 78, 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000002', '1990-01-01', '2023-01-01', 'NONE', 173, 'john', 'MAN', 'doe', 85, '042ec3a9-7ecf-4550-813c-f620dfb31203');

INSERT INTO public.goal
(id, actual_weight, goal_weight, start_weight, user_id)
VALUES('00000000-0000-0000-0000-000000000001', 78, 83, 78, 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000002', 85, 70, 85, '042ec3a9-7ecf-4550-813c-f620dfb31203');

INSERT INTO public.monitoring
(id, "date", weight, user_id)
VALUES('00000000-0000-0000-0000-000000000001', '2023-01-01', 78, 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000002', '2023-01-15', 80, 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000003', '2023-02-19', 82, 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000004', '2023-01-01', 85, '042ec3a9-7ecf-4550-813c-f620dfb31203'),
      ('00000000-0000-0000-0000-000000000005', '2023-01-10', 84, '042ec3a9-7ecf-4550-813c-f620dfb31203'),
      ('00000000-0000-0000-0000-000000000006', '2023-01-23', 82, '042ec3a9-7ecf-4550-813c-f620dfb31203'),
      ('00000000-0000-0000-0000-000000000007', '2023-02-15', 80, '042ec3a9-7ecf-4550-813c-f620dfb31203'),
      ('00000000-0000-0000-0000-000000000008', '2023-02-24', 79, '042ec3a9-7ecf-4550-813c-f620dfb31203'),
      ('00000000-0000-0000-0000-000000000009', '2023-03-20', 75, '042ec3a9-7ecf-4550-813c-f620dfb31203');

INSERT INTO public.recipe
(id, "date", category, is_favorite, "label", "type", user_id)
VALUES('00000000-0000-0000-0000-000000000001', '2023-05-20', 'BREAKFAST', true, 'cereale', 'NONE', 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000002', '2023-05-21', 'BREAKFAST', false, 'cereale', 'NONE', 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000003', '2023-05-20', 'DINER', false, 'soupe', 'NONE', 'ab2cf11d-2d39-41a2-9a1d-f7fe0a1e483f'),
      ('00000000-0000-0000-0000-000000000004', '2023-05-20', 'LUNCH', false, 'salade', 'NONE', '042ec3a9-7ecf-4550-813c-f620dfb31203');

INSERT INTO public.foodcomposition
(id, "name", calories, serving_size_g, fat_total_g, fat_saturated_g, protein_g, sodium_mg, potassium_mg, cholesterol_mg, carbohydrates_total_g, fiber_g, sugar_g)
VALUES('00000000-0000-0000-0000-000000000001','milk', 100, 10, 8, 26, 10, 6,  10, 60, 50, 10, 4);


INSERT INTO public.food
(id, calorie, "family", "name", quantity, weight, foodcomposition_id, recipe_id)
VALUES('00000000-0000-0000-0000-000000000001', 150, '', 'milk', 1, 100, '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001');


