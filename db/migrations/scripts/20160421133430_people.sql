-- // reserve order
-- Migration SQL that makes the change goes here.
CREATE TABLE people
(
  event_id BIGINT NOT NULL,
  name CHARACTER VARYING(255) NOT NULL,
  time_id BIGINT NOT NULL,
  address_id BIGINT NOT NULL,
  note CHARACTER VARYING(255) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE people;
