show databases;

DROP DATABASE IF EXISTS adlister_db;
CREATE DATABASE adlister_db;
USE adlister_db;
SHOW TABLES;

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(50) NOT NULL UNIQUE,
  EMAIL VARCHAR(240) NOT NULL UNIQUE,
  PASSWORD VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ADS;
CREATE TABLE ADS (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  USER_ID INT UNSIGNED NOT NULL,
  TITLE VARCHAR(100) NOT NULL,
  DESCRIPTION VARCHAR(500),
  FOREIGN KEY (USER_ID) REFERENCES USERS (id),
  PRIMARY KEY (id)

);

INSERT INTO users (USERNAME, EMAIL, PASSWORD)
VALUES ("user1", "user1.email", "user1pass"),
       ("user2", "user2.email", "user2pass"),
       ("user3", "user3.email", "user3pass");

INSERT INTO ads (USER_ID, TITLE, DESCRIPTION)
VALUES (1, "Bananas", "all the fruits"),
       (2, "Karen is cool", "On the weekend at least"),
       (3, "Maria likes to Math", "Does this all the time");

SELECT * FROM USERS;

SELECT * FROM ADS;