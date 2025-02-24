CREATE TABLE status(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

INSERT INTO status (name) VALUES ('Approved') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO status (name) VALUES ('Rejected') ON DUPLICATE KEY UPDATE name=name;

ALTER TABLE customer ADD COLUMN status_id INT NULL;

ALTER TABLE customer ADD CONSTRAINT fk_customer_status
FOREIGN KEY (status_id) REFERENCES status (id);
