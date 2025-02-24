CREATE TABLE purpose (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

INSERT INTO purpose (name) VALUES ('Investment portfolio') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO purpose (name) VALUES ('Account to operate locally') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO purpose (name) VALUES ('Account to operate overseas') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO purpose (name) VALUES ('Energy & commodities financing') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO purpose (name) VALUES ('Investment portfolio') ON DUPLICATE KEY UPDATE name=name;

CREATE TABLE entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

INSERT INTO entity (name) VALUES ('Trust') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO entity (name) VALUES ('Associaton') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO entity (name) VALUES ('Private Company') ON DUPLICATE KEY UPDATE name=name;

CREATE TABLE business (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

INSERT INTO business (name) VALUES ('Banking') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO business (name) VALUES ('Fishing') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO business (name) VALUES ('Manufacturing') ON DUPLICATE KEY UPDATE name=name;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    purpose_id INT NOT NULL,
    entity_id INT NOT NULL,
    business_id INT NOT NULL,
    company VARCHAR(255) NOT NULL UNIQUE,
    license VARCHAR(255) NOT NULL UNIQUE,
    country VARCHAR(100) NOT NULL,
    incorporation_date DATETIME NOT NULL,
    applicant VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    FOREIGN KEY (purpose_id) REFERENCES purpose(id),
    FOREIGN KEY (entity_id) REFERENCES entity(id),
    FOREIGN KEY (business_id) REFERENCES business(id)
);

CREATE TABLE shareholders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    passport VARCHAR(100) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);