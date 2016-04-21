-- // create item
-- Migration SQL that makes the change goes here.

CREATE TABLE event (
   event_id SERIAL PRIMARY KEY,
   url CHARACTER VARYING(32) NOT NULL,
   name CHARACTER VARYING(255) NOT NULL,
   owner CHARACTER VARYING(255) NOT NULL,
   password CHARACTER VARYING(255) NOT NULL,
   description CHARACTER VARYING(255) NOT NULL,
   active BOOLEAN NOT NULL
 );

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE event;