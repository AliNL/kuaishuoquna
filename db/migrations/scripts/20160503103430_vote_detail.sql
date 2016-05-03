-- // voteDetail
-- Migration SQL that makes the change goes here.
CREATE TABLE vote_detail
(
  people_id BIGINT NOT NULL,
  type CHARACTER VARYING(255) NOT NULL,
  item_id BIGINT NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE vote_detail;
