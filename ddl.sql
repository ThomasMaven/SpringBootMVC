-- Table: public.contact

-- DROP TABLE public.contact;

CREATE TABLE public.contact
(
  id integer NOT NULL DEFAULT nextval('kontakt_id_seq'::regclass),
  user_id integer NOT NULL,
  type character varying(100),
  value character varying(100),
  CONSTRAINT kontakt_pkey PRIMARY KEY (id),
  CONSTRAINT my_fk FOREIGN KEY (user_id)
      REFERENCES public.person (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contact
  OWNER TO postgres;

  
-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
  id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  name character varying(100),
  surname character varying(100),
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO postgres;
