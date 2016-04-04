-- // add_country_to_account
-- Migration SQL that makes the change goes here.
ALTER TABLE account
ADD COLUMN country CHARACTER VARYING(32);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE account
DROP COLUMN country;
