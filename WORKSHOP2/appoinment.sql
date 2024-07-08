USE master;
GO

CREATE DATABASE appointmentDB;
GO

USE appointmentDB;
GO
CREATE TABLE USERS (
    userID INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE APPOINTMENTS (
    appointmentID INT IDENTITY(1,1) PRIMARY KEY,
    userID INT,
    appointmentDate DATE,
    appointmentTime TIME,
    purpose nvarchar(255),
    status VARCHAR(50),
    FOREIGN KEY (userID) REFERENCES USERS(userID)
);
