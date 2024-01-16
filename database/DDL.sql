-- Table: cityweather

-- PostgresSQL

DROP TABLE IF EXISTS cityweather;

-- Create the table
CREATE TABLE cityweather
(
    id SERIAL PRIMARY KEY,
    cityname VARCHAR(50) COLLATE pg_catalog."default" NOT NULL,
    temperature DOUBLE PRECISION,
    time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT cityname_cn UNIQUE (cityname)
);