USE master
GO
CREATE DATABASE ItemsDB
GO
USE ItemsDB
GO
CREATE TABLE [dbo].[tblItems](
	[id] [varchar](5) PRIMARY KEY NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL
)
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) PRIMARY KEY NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 )
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00001', N'Apple Iphone 6', 1, 2)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00002', N'Apple Iphone 7', 2, 3)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00003', N'Samsung Galaxy S21', 3, 4)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00004', N'Xiaomi Mi 9', 4, 5)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00005', N'Oppo F9', 5, 6)
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'1', N'Minh', N'1')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'2', N'TNam', N'2')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'3', N'Vu', N'3')
GO
