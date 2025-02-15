CREATE TABLE person_transactions(
 person_id VARCHAR(255) NOT NULL,
 transaction_id VARCHAR(255) NOT NULL,
 CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES persons(id),
 CONSTRAINT fk_transaction_id FOREIGN KEY (transaction_id) REFERENCES transactions(id)
)