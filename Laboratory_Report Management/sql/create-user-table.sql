CREATE DATABASE 'demo';
USE demo;

create table users (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	email varchar(220) NOT NULL,
	address varchar(120),
	number varchar(120),
	reason varchar(120),
	PRIMARY KEY (id)
);

