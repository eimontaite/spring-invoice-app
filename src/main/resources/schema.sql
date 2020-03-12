CREATE TABLE customers(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    code VARCHAR(255),
    legal_entity BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE invoices(
    id SERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES customers(id),
    date_time timestamptz NOT NULL
);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    type_id BIGINT,
    quantity BIGINT,
    price BIGINT,
    invoice_id BIGINT REFERENCES invoices(id)
);