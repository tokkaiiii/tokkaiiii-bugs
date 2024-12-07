-- Tokkaiiii-bugs Database Schema
-- Version 1.0

DROP SCHEMA IF EXISTS tokkaiiii_bugs CASCADE;
CREATE SCHEMA tokkaiiii_bugs;

DROP TABLE IF EXISTS bugs_user;

CREATE TABLE bugs_user(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL unique ,
    email VARCHAR(100) NOT NULL unique ,
    password VARCHAR(200) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
)

