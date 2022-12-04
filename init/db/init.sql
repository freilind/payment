CREATE USER kcuserdb WITH PASSWORD 'qwerty';
CREATE DATABASE keycloak;
GRANT ALL PRIVILEGES ON DATABASE keycloak TO kcuserdb;

CREATE USER userdbpayment WITH PASSWORD 'qwerty';
CREATE DATABASE payment;
GRANT ALL PRIVILEGES ON DATABASE payment TO userdbpayment;


INSERT INTO public.product(id, code, name) VALUES (gen_random_uuid (), 'tdd01', 'Tarjeta Débito');
INSERT INTO public.product(id, code, name) VALUES (gen_random_uuid (), 'tdd02', 'Tarjeta Crédito');
INSERT INTO public.product(id, code, name) VALUES (gen_random_uuid (), 'tdd03', 'Tarjeta Virtual');
INSERT INTO public.product(id, code, name) VALUES (gen_random_uuid (), 'tdd04', 'Tarjeta Puntos');