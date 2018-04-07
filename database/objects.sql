CREATE SEQUENCE public."STUDENT_SEQ"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."STUDENT_SEQ"
    OWNER TO postgres;



-- Table: public."STUDENT"

-- DROP TABLE public."STUDENT";

CREATE TABLE public."STUDENT"
(
    "ID" integer NOT NULL,
    "NAME" character varying(24) COLLATE pg_catalog."default" NOT NULL,
    "LAST_NAME" character varying(24) COLLATE pg_catalog."default" NOT NULL,
    "EMAIL" character varying(48) COLLATE pg_catalog."default" NOT NULL,
    "DNI" integer NOT NULL,
    "PASSWORD" character varying(256) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "STUDENT_pkey" PRIMARY KEY ("DNI")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."STUDENT"
    OWNER to postgres;