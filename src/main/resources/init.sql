--
-- Name: account; Type: TABLE; Schema: public; Owner: admin
--
drop table if exists public.account ;
CREATE TABLE public.account (
    agency integer NOT NULL,
    accountnumber integer NOT NULL,
    status VARCHAR,
    name VARCHAR
);

--
----
---- Name: balance; Type: TABLE; Schema: public; Owner: admin
----

drop table if exists public.balance ;
CREATE TABLE public.balance (
    agency integer NOT NULL,
    accountnumber integer NOT NULL,
    balancevalue numeric(15,2)
);
--
--
----
---- Name: debitcard; Type: TABLE; Schema: public; Owner: admin
----
--
drop table if exists public.debitcard ;
CREATE TABLE public.debitcard (
    cardnumber numeric NOT NULL,
    agency integer,
    account integer,
    status VARCHAR
);
--
--
--
----
---- Name: provisionaldebit; Type: TABLE; Schema: public; Owner: admin
----
--
--CREATE TABLE public.provisionaldebit (
--    id serial NOT NULL,
--    agency integer,
--    accountnumber integer,
--    debitvalue numeric,
--    debitdate date,
--    status VARCHAR
--);
--
----
---- Name: transaction; Type: TABLE; Schema: public; Owner: admin
----
--
--CREATE TABLE public.transaction (
--    id serial NOT NULL,
--    agency integer,
--    accountnumber integer,
--    transactionvalue numeric(15,2),
--    transactiondate timestamp without time zone
--);

--
----
---- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: admin
----
--
--COPY public.account (agency, accountnumber, status, name) FROM stdin;
--111	222	ACTIVE	Tim McGraw
--111	333	ACTIVE	Brad Paisley
--111	444	INACTIVE	Keith Urban
--\.
--
--
----
---- Data for Name: balance; Type: TABLE DATA; Schema: public; Owner: admin
----
--
--COPY public.balance (agency, accountnumber, balancevalue) FROM stdin;
--111	222	100.00
--111	333	50.00
--111	444	200.00
--\.
--
--
----
---- Data for Name: debitcard; Type: TABLE DATA; Schema: public; Owner: admin
----
--
--COPY public.debitcard (cardnumber, agency, account, status) FROM stdin;
--12345	111	222	ACTIVE
--22334	111	333	INACTIVE
--99999	111	444	ACTIVE
--\.
