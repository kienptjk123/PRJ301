
CREATE DATABASE WorkShop1;
GO

USE WorkShop1;

CREATE TABLE tbl_User (
    userId VARCHAR(20) PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    [role] INT CHECK (role IN (0, 1, 2)),
	Password nvarchar(50)
);

CREATE TABLE tbl_Mobile (
    mobileId VARCHAR(10) PRIMARY KEY,
    [description] VARCHAR(250) NOT NULL,
    price decimal(10,2) ,
    mobileName VARCHAR(20) NOT NULL,
    yearOfProduction INT,
    quantity INT,
    notSale BIT
);

