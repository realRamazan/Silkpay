use silkpay_db;
create table Accounts (
	id int primary key not null auto_increment,
    card_num varchar(255) not null,
    user_id int not null, 
    balance decimal(15, 2)
);
insert into Accounts (card_num, user_id, balance) values(
	"8524", 1, 600
);
insert into Users (user_name, user_surname) values(
	"Tom", "Blade"
);
select * from Accounts;
select * from Users;
create table Accounts (
	id int primary key not null auto_increment,
    card_num varchar(255) not null,
    user_id int not null, 
    num integer, 
    balance decimal(15, 2)
);

