CREATE TABLE users
(
    user_id uuid         NOT NULL
        PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255)
);