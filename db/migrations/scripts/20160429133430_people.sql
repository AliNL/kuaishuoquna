-- // people
-- Migration SQL that makes the change goes here.
CREATE TABLE people
(
  people_id SERIAL PRIMARY KEY,
  name CHARACTER VARYING(255) NOT NULL,
  event_url CHARACTER VARYING(255) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE people;
