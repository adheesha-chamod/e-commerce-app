CREATE SEQUENCE IF NOT EXISTS category_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE category
(
    id          INTEGER         NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    description VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id                 INTEGER          NOT NULL,
    name               VARCHAR(255)     NOT NULL,
    description        VARCHAR(255)     NOT NULL,
    available_quantity DOUBLE PRECISION NOT NULL,
    price              DECIMAL(10, 2)   NOT NULL,
    category_id        INTEGER,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT fk_product_on_category FOREIGN KEY (category_id) REFERENCES category (id);