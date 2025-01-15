CREATE TABLE Employees (
Name VARCHAR(50),
EmployeeID INT PRIMARY KEY,
Projects table
);

CREATE TABLE Tasks (
Name VARCHAR(50),
Priority INT,
Status VARCHAR(50),
DueDate datetime,
Comment VARCHAR(500),
Description VARCHAR(500)
);

CREATE TABLE Projects (
Employees table,
Tasks table,
ProjectName VARCHAR(50),
ProjectID INT PRIMARY KEY,
Deadline datetime
)