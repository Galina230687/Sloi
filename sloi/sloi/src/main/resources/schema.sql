create table if not exists CUSTOMERS (
ID              BIGSERIAL PRIMARY KEY,
name            TEXT not null,
surname         TEXT not null,
age             INTEGER not null,
phone_number    TEXT
);

create table if not exists ORDERS (
    ID              SERIAL PRIMARY KEY, -- Поле ID автоматически увеличивается
    customer_id     INTEGER not null,
    date            DATE,
    product_name    TEXT not null,
    amount          INTEGER not null
);



