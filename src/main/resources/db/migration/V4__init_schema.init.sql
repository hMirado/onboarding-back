ALTER TABLE customer ADD COLUMN registrat_number VARCHAR(255) NULL;
ALTER TABLE customer ADD UNIQUE (registrat_number);