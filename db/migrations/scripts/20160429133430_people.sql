-- // reserve order
-- Migration SQL that makes the change goes here.
CREATE TABLE people
(
  name CHARACTER VARYING(255) NOT NULL,
  event_url CHARACTER VARYING(255) NOT NULL,
  time_id BIGINT NOT NULL,
  address_id BIGINT NOT NULL,
  note CHARACTER VARYING(255) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE people;
