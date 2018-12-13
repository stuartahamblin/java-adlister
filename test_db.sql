# Setting up The Database Connection
# In IntelliJ:
#
# Open the database tool window
#
# View -> Tool Windows -> Database
#
# Add a new connection
#
# Click on the '+' Choose Data Source -> MySQL
#
# Fill in the following:
#
# Host: localhost
# Port: 3306
# Database:
# User: root
# Password: codeup (or your root password)
# Note that you should leave the "Database" field blank.
#
# Click 'Test Connection' and save if successful
#
# You should be dropped into the db console
#
# If you cannot run 'Test Connection', look for a prompt to update your drivers.
#
#     IntelliJ may tell you that you are missing a JDBC driver, and provide a button to click to download the missing driver. Go ahead and click the button if this is the case.
#
#     Accessing the Database Console
#     There are several ways to access what IntelliJ refers to as the "Database Console", which is essentially a scratchpad for running database queries. To access the database console:
#
#     Open the database tool window
#     Alt click and choose 'open console' or click on the console icon near the top of the database tool window.
#
#
# If IntelliJ prompts you to choose the dialect of SQL, select MySQL.
# For choosing SQL Dialect press Command + shift + A, type sql di, choose SQL Dialects, under project SQL Dialect select MySQL.


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

#   to display the table diagrams go to Database tool window > @localhost >
#   schemas > "right click" adlister_db > Diagrams > Show visualization

