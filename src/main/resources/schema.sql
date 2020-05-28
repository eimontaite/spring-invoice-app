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
    invoice_id BIGINT REFERENCES invoices(id),
    item_name VARCHAR(255)
);

CREATE TABLE contact_details(
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    name VARCHAR(255),
    surname VARCHAR(255),
    personal_number BIGINT,
    business_licence_no VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    bank_account VARCHAR(255),
    bank VARCHAR(255)
);