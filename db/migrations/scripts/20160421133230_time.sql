-- // reserve order
-- Migration SQL that makes the change goes here.
CREATE TABLE time
(
  event_id BIGINT NOT NULL,
  time_id SERIAL PRIMARY KEY,
  note CHARACTER VARYING(255) NOT NULL,
  count_number INT DEFAULT 0
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE time;
