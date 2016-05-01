-- // reserve order
-- Migration SQL that makes the change goes here.
CREATE TABLE address
(
  address_id SERIAL PRIMARY KEY,
  event_url CHARACTER VARYING(255) NOT NULL,
  note CHARACTER VARYING(255) NOT NULL,
  count_number INT DEFAULT 0
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE address;
