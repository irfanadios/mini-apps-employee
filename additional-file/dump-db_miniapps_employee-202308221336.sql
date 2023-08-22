--
-- PostgreSQL database dump
--

-- Dumped from database version 14.7
-- Dumped by pg_dump version 14.7

-- Started on 2023-08-22 13:36:36 WIB

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE db_miniapps_employee;
--
-- TOC entry 3580 (class 1262 OID 16553)
-- Name: db_miniapps_employee; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE db_miniapps_employee WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';


ALTER DATABASE db_miniapps_employee OWNER TO postgres;

\connect db_miniapps_employee

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3581 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16635)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    age integer NOT NULL,
    name character varying(255) NOT NULL,
    nik character varying(255) NOT NULL,
    salary numeric(38,2) NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16644)
-- Name: employee_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_seq OWNER TO postgres;

--
-- TOC entry 3573 (class 0 OID 16635)
-- Dependencies: 209
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee VALUES (1, 24, 'Muhammad Irfan Adi Prayoga', '3201291999190001', 10000000.00);


--
-- TOC entry 3582 (class 0 OID 0)
-- Dependencies: 210
-- Name: employee_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_seq', 1, true);


--
-- TOC entry 3431 (class 2606 OID 16641)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 3433 (class 2606 OID 16643)
-- Name: employee uk_dxqnbnjx10wm4wb9xpe1rglxf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT uk_dxqnbnjx10wm4wb9xpe1rglxf UNIQUE (nik);


-- Completed on 2023-08-22 13:36:36 WIB

--
-- PostgreSQL database dump complete
--

