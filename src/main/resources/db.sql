CREATE TABLE event (
  id BIGINT NOT NULL,
   title VARCHAR(255),
   description VARCHAR(255),
   agecategory VARCHAR(255),
   capacity INTEGER,
   version INTEGER,
   CONSTRAINT pk_event PRIMARY KEY (id)
);
CREATE TABLE ticket (
  id BIGINT NOT NULL,
   event_id BIGINT,
   place INTEGER,
   row INTEGER,
   version INTEGER,
   CONSTRAINT pk_ticket PRIMARY KEY (id)
);

ALTER TABLE ticket ADD CONSTRAINT FK_TICKET_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (id);
CREATE SEQUENCE  IF NOT EXISTS "public.seq_event" START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS "public.seq_ticket" START WITH 1 INCREMENT BY 1;