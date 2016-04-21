-- // reserve order
-- Migration SQL that makes the change goes here.
CREATE TABLE address
(
  event_id BIGINT NOT NULL,
  address_id BIGINT NOT NULL,
  note CHARACTER VARYING(255) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE address;
