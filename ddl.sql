-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
  id serial NOT NULL ,
  name character varying(100),
  surname character varying(100),
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO postgres;


-- Table: public.contact

-- DROP TABLE public.contact;

CREATE TABLE public.contact
(
  id serial NOT NULL,
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

  
