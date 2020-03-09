CREATE TABLE customer(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    code VARCHAR(255),
    legal_entity BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE invoice(
    id SERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES customer(id),
    date_time timestamptz NOT NULL
);