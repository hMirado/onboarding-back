ALTER TABLE customer MODIFY license VARCHAR(255) NULL;
ALTER TABLE customer ADD UNIQUE (license);
ALTER TABLE customer MODIFY incorporation_date DATE NOT NULL;
ALTER TABLE customer MODIFY email VARCHAR(255) NOT NULL;
ALTER TABLE customer DROP INDEX email;

ALTER TABLE shareholders DROP INDEX passport;