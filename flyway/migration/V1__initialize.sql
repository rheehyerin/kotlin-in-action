create table test (
    `test` varchar(200) NOT NULL
) ENGINE=InnoDB;

create table Product (
    `ProductId` int NOT NULL,
    `ProductType` char(1) NOT NULL,
    `ProductName` varchar(100) NOT NULL,
    `ProductPrice` int NOT NULL
) ENGINE=InnoDB

create table OrderHistory (
    `Date` char(8) NOT NULL,
    `OrderId` int NOT NULL,
    `ProductId` int NOT NULL,
    `EmployeeId` int NOT NULL,
    `ProductPrice` int NOT NULL
) ENGINE=InnoDB