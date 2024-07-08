
Create table tblBooks (
	SKU nvarchar(25) primary key,
	Name nvarchar(50),
	Price decimal(10,2),
	Description varchar(25),
	Quantity decimal(10,0)
)

Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK01','Java', 150000.00, 'Java Book', 45);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK010','EL', 10000.00, 'Fundamental Book', 12);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK011','EU', 150000.00, 'EU Book', 25);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK02','MVC2', 90000.00, 'MVC2 Book', 80);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK03','Tomcat', 180000.00, 'Tomcat Book', 70);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK04','C++', 75000.00, 'C++ Book', 15);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK05','Servlet', 60000.00, 'Servlet Book', 50);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK06','JavaBean', 50000.00, 'Java Book', 40);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK07','JSB', 40000.00, 'JSB Book', 30);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK08','JDBC', 30000.00, 'JDBC Book', 20);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK09','Scripting', 250000.00, 'Scripting Book', 10);
Insert into tblBooks(SKU, Name, Price, Description, Quantity)
Values ('BOOK01','Java', 150000.00, 'Java Book', 45);