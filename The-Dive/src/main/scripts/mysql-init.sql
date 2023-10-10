DROP DATABASE IF EXISTS divedb;
DROP USER IF EXISTS `diveadmin`@`%`;
CREATE DATABASE IF NOT EXISTS divedb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `diveadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `divedb`.* TO `diveadmin`@`%`;